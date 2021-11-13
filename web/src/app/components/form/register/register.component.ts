import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthService } from 'src/app/services/oauth/auth.service';
import { PasswordValidator } from 'src/app/ressources/password.validator';
import { FormGroup, FormControl, Validators, FormBuilder, AbstractControl } from '@angular/forms';
import { FormFactory } from 'src/app/ressources/form.factory';
import { RegisterInfo } from 'src/app/models/register.model';
import { AuthLogin } from 'src/app/models/login.model';
import { ParentErrorStateMatcher } from 'src/app/ressources/error.options';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  encapsulation: ViewEncapsulation.None
})
export class RegisterComponent implements OnInit {

  constructor(protected router: Router, private authService: AuthService, private fb: FormBuilder, private forms: FormFactory, private snackBar: MatSnackBar) {  }

  loading = false;
  
  protected registerForm: FormGroup;
  protected passwordForm: FormGroup;
  readonly errorMessages = this.forms.errorMessages;
  protected parentErrorStateMatcher = new ParentErrorStateMatcher();

  get username(): AbstractControl { return this.registerForm.get('username'); }
  get email(): AbstractControl { return this.registerForm.get('email'); }
  get password(): AbstractControl { return this.passwordForm.get('password'); }
  get confirm(): AbstractControl { return this.passwordForm.get('confirm'); }
  get agree(): AbstractControl { return this.registerForm.get('agree'); }
  data: any;
  ngOnInit(): void { 
    this.passwordForm = this.fb.group(
      { password: this.forms.userForm.password, confirm: new FormControl('', Validators.required) },
      (formGroup: FormGroup) => PasswordValidator.areEqual(formGroup)
    );
    this.registerForm =  this.fb.group({
      username: this.forms.userForm.username,
      email: this.forms.userForm.mail,
      passwordForm: this.passwordForm,
      agree: new FormControl(false, Validators.requiredTrue)
    });
  }

  register(): any {
      this.loading = true;
      this.authService.signUp(this.registerCredentials())
        .subscribe(registerForm => {
            registerForm = registerForm,
            window.alert('Votre compte à été ajouté!');
            window.alert('Pour vous connecter veuiller vous authentifier!');
            this.router.navigate(['/welcome']);
    }, error => {
      const err = error;
      if (!!err) {
        window.alert('Email ou Nom déja pris, veuillez choisir un email et un nom differents ...  ' );
        }});
      }

  private registerCredentials = () => new RegisterInfo(this.username.value, this.email.value, this.password.value);

  

}

