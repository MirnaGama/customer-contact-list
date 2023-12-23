import { Component } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AddressResponse } from '../customer-contact/core/interfaces/address-response.interface';
import { AddressService } from '../customer-contact/core/services/address.service';
import { Telephone } from '../customer-contact/core/interfaces/customer-contact.interface';

@Component({
  selector: 'app-customer-contact-form',
  templateUrl: './customer-contact-form.component.html',
  styleUrl: './customer-contact-form.component.css'
})
export class CustomerContactFormComponent {

  customerContactForm!: FormGroup;

  customerAddress!: AddressResponse;

  submitted = false;

  constructor(private formBuilder: FormBuilder, private addressService: AddressService) {}

  get f(): { [key: string]: AbstractControl } {
    return this.customerContactForm.controls;
  }

  get telephones(): FormArray {
    return this.customerContactForm.get('telephones') as FormArray;
  }

  ngOnInit(): void {
    this.customerContactForm = this.formBuilder.group(
      {
        fullname: ['', Validators.compose([Validators.required, Validators.minLength(10)])],
        cep: ['',  Validators.compose([Validators.required, Validators.minLength(8)])],
        street: ['', [Validators.required]],
        houseNumber: ['', [Validators.required]],
        city: ['', [Validators.required]],
        neighborhood: ['', [Validators.required]],
        state: ['', [Validators.required]],
        telephones: this.formBuilder.array([], Validators.required),
  });

}

  onSubmit(): void {
    this.submitted = true;

    if (this.customerContactForm.invalid) {
      return;
    }

    console.log(JSON.stringify(this.customerContactForm.value, null, 2));

  }

  onReset(): void {
    this.submitted = false;
    this.customerContactForm.reset();
  }

  onGetAddress(cep: string) {

    if (cep.length == 8) {
      this.addressService.getAddress(cep).subscribe((addressResponse: AddressResponse) => {
        this.customerContactForm.patchValue({street: addressResponse.street, city: addressResponse.city, neighborhood:addressResponse.neighborhood, state: addressResponse.state});
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


}
