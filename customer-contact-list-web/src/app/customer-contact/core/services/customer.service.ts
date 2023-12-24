import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../interfaces/customer-contact.interface';
import { Observable } from 'rxjs';

import { environment } from './../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customerApiUrl = environment.apiUrl+"/customers";

  constructor(private http: HttpClient) { }

  insertCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.customerApiUrl, customer);
  }

}
