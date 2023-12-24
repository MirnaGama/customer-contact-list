import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Telephone } from '../interfaces/customer-contact.interface';
import { Observable } from 'rxjs';

import { environment } from './../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TelephoneService {

  private telephoneApiUrl = environment.apiUrl+"/telephones";

  constructor(private http: HttpClient) { }

  insertTelephone(telephone: Telephone): Observable<Telephone> {
    return this.http.post<Telephone>(this.telephoneApiUrl, telephone);
  }

  getTelephones(): Observable<Telephone[]> {
    return this.http.get<Telephone[]>(this.telephoneApiUrl);
  }

}
