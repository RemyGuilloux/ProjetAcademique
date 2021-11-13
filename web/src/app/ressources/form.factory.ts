import { Validators, FormGroup, FormBuilder, FormControl, AbstractControl, FormGroupDirective, NgForm } from '@angular/forms';
import { Injectable } from '@angular/core';
import { ErrorStateMatcher } from '@angular/material/core';
import { ErrorMessages } from 'src/app/ressources/error-messages';
import { Patterns } from 'src/app/ressources/pattern';
import { PasswordValidator } from 'src/app/ressources/password.validator';
import { validateHorizontalPosition } from '@angular/cdk/overlay';

@Injectable({ providedIn: 'root' })
export class FormFactory {

    constructor(protected fb: FormBuilder) {
        this.fb = new FormBuilder();
    }

    readonly patterns = Patterns;

    readonly errorMessages = ErrorMessages;

    readonly userForm = {
        name: ['', [
            Validators.required,
            Validators.minLength(3),
            Validators.maxLength(20),
            Validators.pattern(this.patterns.text)
        ]],
        username: ['', [
            Validators.required,
            Validators.minLength(3),
            Validators.maxLength(20),
            Validators.pattern(this.patterns.text)
        ]],
        lastname: ['', [
            Validators.required,
            Validators.minLength(3),
            Validators.maxLength(20),
            Validators.pattern(this.patterns.text)
        ]],
        password: ['', [
            Validators.required,
            Validators.minLength(6),
            Validators.maxLength(25),
            Validators.pattern(this.patterns.password)
        ] ] ,
        mail: new FormControl('', Validators.compose([
            Validators.required,
            Validators.pattern(this.patterns.email)
        ])),
        phone: ['', [
            Validators.required,
            Validators.minLength(10),
            Validators.maxLength(10),
            Validators.pattern(this.patterns.phone)

        ]],
        size: ['', [
            Validators.required,
            Validators.minLength(2),
            Validators.maxLength(4),
            Validators.pattern(this.patterns.phone)

        ]],
        zipcode: ['', [
            Validators.required,
            Validators.minLength(5),
            Validators.maxLength(5),
            Validators.pattern(this.patterns.phone)

        ]],
        gender: ['', [
            Validators.required
        ]],
        localisation: ['', [
            Validators.required,
            Validators.minLength(3),
            Validators.maxLength(20),
            Validators.pattern(this.patterns.text)

        ]],
        type: ['', [
            Validators.required,
            Validators.minLength(10),
            Validators.pattern(this.patterns.text)

        ]]
    };
    readonly loginForm: FormGroup = this.fb.group( {
        username: ['', [
        Validators.required,
        Validators.pattern(this.patterns.text)
        ]],
        password: ['', [
        Validators.required,
        Validators.pattern(this.patterns.password)
        ]]
    });
    readonly passwordForm = new FormGroup({
        password: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(this.patterns.password)
        ])),
        confirm: new FormControl('', Validators.required)
    }, (formGroup: FormGroup) => {
        return PasswordValidator.areEqual(formGroup);
    });
    readonly registerForm: FormGroup = this.fb.group({
        username: new FormControl('', Validators.compose([
            Validators.pattern(this.patterns.text),
            Validators.required
        ])),
        email: new FormControl('', Validators.compose([
            Validators.required,
            Validators.pattern(this.patterns.email)
        ])),
        passwordForm: this.passwordForm,
        agree: new FormControl(false, Validators.requiredTrue)
    });
    
    isValid = (ctrl: AbstractControl, err: any): boolean => ctrl.hasError(err.type) && (ctrl.dirty || ctrl.touched);

}
export class ParentErrorStateMatcher implements ErrorStateMatcher {
    isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
        const controlTouched = !!(control && (control.dirty || control.touched));
        const controlInvalid = !!(control && control.invalid);
        const parentInvalid = !!(control && control.parent && control.parent.invalid && (control.parent.dirty || control.parent.touched));

        return (controlTouched && (controlInvalid || parentInvalid));
    }
}