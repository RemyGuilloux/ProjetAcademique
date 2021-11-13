import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Garden } from '../../models/garden';


@Injectable({
  providedIn: 'root'
})
export class GardenService {

  
  public garden:Garden;

  private baseUrl = 'http://localhost:8083/api/gardens';
  

  constructor(private http: HttpClient) { }

  getGarden(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/` + id);
  }

  createGarden(garden: Object): Observable<any> {
    return this.http.post(`${this.baseUrl}`, garden);
  }

  updateGarden(id: number, garden: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, garden);
  }

  deleteGarden(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/` + id);
  }

  getGardensList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
