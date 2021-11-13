import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Address } from 'src/app/models/address';

@Injectable({
  providedIn: 'root'
})
export class AddressService {
  public address:Address;

  private baseUrl = 'http://localhost:8083/api/addresses';
  static address: Address;

  constructor(private http: HttpClient) { }

  getAddress(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/`+ id);
  }

  createAddress(address: Object): Observable<any> {
    return this.http.post(`${this.baseUrl}`, address);
  }

  updateAddress(id: number, value: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteAddress(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  getAddressList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  
}
