import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AddressResponse } from '../interfaces/address-response.interface';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private hostUrl = "https://brasilapi.com.br/api/cep/v1/";

  constructor(private http: HttpClient) { }

  getAddress(cep: string) {
    return this.http.get<AddressResponse>(this.hostUrl + cep);
  }
  
}
