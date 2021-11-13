import { Component, OnInit } from '@angular/core';
import { Gardener } from 'src/app/models/gardener';
import { GardenerService } from 'src/app/services/gardener/gardener.service';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormBuilder, AbstractControl } from '@angular/forms';
import { FormFactory } from 'src/app/ressources/form.factory';
@Component({
  selector: 'app-create-profil-gardener',
  templateUrl: './create-profil-gardener.component.html',
  styleUrls: ['./create-profil-gardener.component.css']
})
export class CreateProfilGardenerComponent implements OnInit {

submitted = false;
protected gardenerForm: FormGroup;

readonly errorMessages = this.forms.errorMessages;

  constructor(private formbuilder: FormBuilder,
              protected forms: FormFactory,
              private gardenerService: GardenerService,
              private router: Router) { }

  get name(): AbstractControl { return this.gardenerForm.get('name'); }
  get lastname(): AbstractControl { return this.gardenerForm.get('lastname'); }
  get mail(): AbstractControl { return this.gardenerForm.get('mail'); }
  get phone(): AbstractControl { return this.gardenerForm.get('phone'); }
  get gender(): AbstractControl { return this.gardenerForm.get('gender'); }
  get localisation(): AbstractControl { return this.gardenerForm.get('localisation'); }
  get type(): AbstractControl  { return this.gardenerForm.get('type'); }

  ngOnInit() {    
    this.gardenerForm = this.formbuilder.group({
      name: this.forms.userForm.name,
      lastname: this.forms.userForm.lastname,
      mail: this.forms.userForm.mail,
      phone: this.forms.userForm.phone,
      gender: this.forms.userForm.gender,
      localisation: this.forms.userForm.localisation,
      type: this.forms.userForm.type,
    });
    console.log(this.gardenerForm);
  }
  protected save() {
    const formGardener = new Gardener(
      this.name.value,
      this.lastname.value,
      this.mail.value,
      this.phone.value,
      this.gender.value,
      this.localisation.value,
      this.type.value);

    this.gardenerService.createGardener(formGardener)
      .subscribe(
        data => console.log(data),
        error => console.log(error));
    this.gotoList();
  }

  protected onSubmit() {
    this.submitted = true;
    this.save();
  }
  private gotoList(){
    this.router.navigate(['/gardening']);
  }
}

