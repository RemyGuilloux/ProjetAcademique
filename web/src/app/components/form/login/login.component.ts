
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/oauth/auth.service';
import { FormFactory } from 'src/app/ressources/form.factory';
import { AuthLogin } from 'src/app/models/login.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(protected authService: AuthService, protected forms: FormFactory) { }
  loginForm = this.forms.loginForm;
  readonly errorMessages = this.forms.errorMessages;
  ngOnInit() {
  }
  get username() { return this.loginForm.get('username'); }
  get password() { return this.loginForm.get('password'); }

  login(): void { this.authService.logIn( this.credentials() ); }

  private credentials = () => new AuthLogin(this.username.value, this.password.value);

}
