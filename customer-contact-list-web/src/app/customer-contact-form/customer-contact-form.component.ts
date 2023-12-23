import { Component } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-customer-contact-form',
  templateUrl: './customer-contact-form.component.html',
  styleUrl: './customer-contact-form.component.css'
})
export class CustomerContactFormComponent {

  customerContactForm: FormGroup = new FormGroup({
    fullname: new FormControl(''),
    address: new FormControl(''),
    neighborhood: new FormControl(''),
    telephones: new FormArray([
      new FormGroup({
        numbers: new FormControl('')
      })
    ])
  });

  submitted = false;

  constructor(private formBuilder: FormBuilder) {}

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
        address: ['', [Validators.required]],
        neighborhood: ['', [Validators.required]],
        telephones: [{numbers: new FormControl('')}, Validators.required],
      }
    );
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
  
}
