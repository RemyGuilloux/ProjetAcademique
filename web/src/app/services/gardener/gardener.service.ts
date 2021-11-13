import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GardenerService {
id: number;
  private baseUrl = 'http://localhost:8083/api/gardeners';

  constructor(private http: HttpClient) { }

  getGardener(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}`+ id);
  }

  createGardener(gardening: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, gardening);
  }

  updateGardener(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteGardener(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  getGardenerList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}