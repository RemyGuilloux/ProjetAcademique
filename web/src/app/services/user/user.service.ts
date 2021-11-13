import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User} from '../../models/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  public user: User;
  listUsers: any;

  private baseUrl = 'http://localhost:8083/api/secure/users';

  constructor(private http: HttpClient) { }

  getUser(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  getUserid(user: object): Observable<any> {
    return this.http.get(`${this.baseUrl}/me`);
  }
  createUser(user: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`, user);
  }

  updateUser(id: number, value: any): Observable<object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  getUsersList(): Observable<any> {
   
    this.listUsers = this.http.get(`${this.baseUrl}`);
    
    return this.listUsers;

  }
}
