import { Component } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AddressResponse } from '../../core/interfaces/address-response.interface';
import { AddressService } from '../../core/services/address.service';
import { Customer, Telephone } from '../../core/interfaces/customer-contact.interface';
import { CustomerService } from '../../core/services/customer.service';
import { TelephoneService } from '../../core/services/telephone.service';

import Swal from 'sweetalert2';

@Component({
  selector: 'app-customer-contact-form',
  templateUrl: './customer-contact-form.component.html',
  styleUrl: './customer-contact-form.component.css'
})
export class CustomerContactFormComponent {

  customerContactForm!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private addressService: AddressService, private customerService: CustomerService, private telephoneService: TelephoneService) { }

  get f(): { [key: string]: AbstractControl } {
    return this.customerContactForm.controls;
  }

  get telephones(): FormArray {
    return this.customerContactForm.get('telephones') as FormArray;
  }

  ngOnInit(): void {
    this.customerContactForm = this.formBuilder.group(
      {
        fullname: ['', Validators.compose([Validators.required, Validators.minLength(10), Validators.pattern("/^[^a-zA-Z]*$/")])],
        cep: ['', Validators.compose([Validators.required, Validators.minLength(8), Validators.maxLength(8)])],
        street: ['', [Validators.required]],
        houseNumber: ['', [Validators.required]],
        city: ['', [Validators.required]],
        neighborhood: ['', [Validators.required]],
        state: ['', [Validators.required]],
        telephones: this.formBuilder.array([], Validators.required),
      });

      this.addNewTelephone(); // adding at least one field when initializing then form

  }

  onSubmit(): void {
    this.submitted = true;

    this.customerContactForm.patchValue({fullname: this.customerContactForm.value.fullname.trim()})

    if (this.customerContactForm.invalid) {
      return;
    }

    const customerPayLoad: Customer = {
      fullname: this.customerContactForm.value.fullname,
      street: this.customerContactForm.value.street,
      houseNumber: this.customerContactForm.value.houseNumber,
      cep: this.customerContactForm.value.cep,
      neighborhood: this.customerContactForm.value.neighborhood,
      city: this.customerContactForm.value.city,
      state: this.customerContactForm.value.state
    }

    this.insertCustomerContact(customerPayLoad);

  }

  onReset(): void {
    this.submitted = false;
    this.customerContactForm.reset();
  }

  onGetAddress(cep: string) {

    this.customerContactForm.patchValue({cep: cep.replace(/\D+/g, '') });

    if (cep.length == 8) {
      this.addressService.getAddress(cep).subscribe((addressResponse: AddressResponse) => {
        this.customerContactForm.patchValue({ street: addressResponse.street, city: addressResponse.city, neighborhood: addressResponse.neighborhood, state: addressResponse.state });
      });
    }
  }

  createTelephoneFormGroup(telephone: Telephone = { number: '' }) {
    return this.formBuilder.group({
      number: [telephone.number, Validators.required]
    })
  }

  addNewTelephone() {
    this.telephones.push(this.createTelephoneFormGroup());
  }

  removeTelephone(index: number) {
    this.telephones.removeAt(index);
  }

  getDuplicatedTelephones(telephones: Telephone[], telephonesNumbersStored: string[]): string[] {
    const telephonesNumbers = telephones.map(telephone => telephone.number);
    return telephonesNumbersStored.filter(telephone => telephonesNumbers.includes(telephone));
  }

  insertCustomerContact(customerPayLoad: Customer) {
    this.telephoneService.getTelephones().subscribe((telephonesResponse =>
      {
  
      const telephones = this.customerContactForm.value.telephones as Telephone[]; // getting telephones inserted in the form

      const telephonesNumbersStored = telephonesResponse.map(telephone => telephone.number); // getting telephone numbers already stored / inserted

      const duplicatedTelephones = this.getDuplicatedTelephones(telephones, telephonesNumbersStored); // check for duplicated telephones

      if (duplicatedTelephones.length > 0) { // if there are duplicated telephones, it will return instead of insert a new customer contact

        Swal.fire({
          icon: "error",
          title: "Oops...",
          html: `Telefone já está inserido em outro cliente: [${duplicatedTelephones}]`,
        });

        return;
        }

        this.customerService.insertCustomer(customerPayLoad).subscribe( // creating new customer first...
          (customerResponse: Customer) => {
    
            telephones.forEach(telephone => {
              telephone = {...telephone, customerId: customerResponse.id} // getting the customer id 
    
              this.telephoneService.insertTelephone(telephone).subscribe((telephoneResponse: Telephone) => { // creating new telephone record
                Swal.fire({
                  icon: "success",
                  title: "Dados inseridos com sucesso!",
                  showConfirmButton: false,
                  timer: 1500
                });
              })
            });
    
            this.onReset(); // resetting the form
          })

      }));
  }


}
