import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, BehaviorSubject } from 'rxjs';
import { config } from '../../ressources/config';
import { Token } from './token/token';
import { MatSnackBar } from '@angular/material';

import { Cookie } from 'ng2-cookies';
import { AuthLogin } from '../../models/login.model';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private readonly registerURI = config.apiURI + 'api/auth/signup';
  private readonly loginURI = config.apiURI + 'oauth/token';
  private readonly currentUserURI = config.apiURI + 'api/secure/users/me';
  public loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>( Cookie.check('access_token') );

  constructor(protected router: Router, private http: HttpClient, private snackBar: MatSnackBar) {}

  logIn(data: AuthLogin): any {
    this.loadToken(data).subscribe(
      token => {
        this.saveToken( this.mapToken(token) );
        this.router.navigate(['/homepage']);
        window.alert('Bienvenue ' + data.username,  );
      }, error => {
        const err = error;
        if (err) {
          window.alert('Mot de passe ou Nom incorect, veuillez vous authentifier avec des identifiants valides   ... ');
      } else {
        window.alert('problème de serveur ' );
      }
      }
    );
  }

  signUp = (info: any): Observable<string> => this.http.post<string>(this.registerURI, info, config.httpOptions.json);

  saveToken = (token: Token): void => Cookie.set('access_token', JSON.stringify(token), token.expiresIn);

  logout = (): void => {Cookie.delete('access_token');
                        this.router.navigate(['/welcome']);
                      }

  private getToken = (): Token => JSON.parse(Cookie.get('access_token'));

  getCurrentUser = (): any => {
    const token: Token = this.getToken();
    return {id: token.userId, username: token.username };
  }

  getJwtToken = (): string => this.getToken().accessToken;

  isLoggedIn = (): boolean => {
    return Cookie.check('access_token');
  }

  private loadToken = (data: AuthLogin): Observable<any> => this.http.post<any>
    (this.loginURI, this.map(data), config.httpOptions.formUrlEncoded)

  private map = (data: AuthLogin): string => 'grant_type=' + config.grantType + '&username=' +
    data.username + '&password=' + data.password + '&client_id=' + config.clientId

  private mapToken = (token: any): Token => new Token(token.access_token, token.token_type,
    token.refresh_token, token.expires_in, token.scope, token.role, token.userId, token.username )

}
