import { Component, ViewChild, OnInit } from '@angular/core';
import { Profil } from 'src/app/models/profil';
import { ProfilService } from 'src/app/services/profil/profil.service';
import { Router } from '@angular/router';
import { Garden } from 'src/app/models/garden';
import { GardenService } from 'src/app/services/garden/garden.service';
import { Address } from 'src/app/models/address';
import { AddressService } from 'src/app/services/address/address.service';
import { FormGroup, FormControl, AbstractControl } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { NgForm } from '@angular/forms';
import { FormFactory } from 'src/app/ressources/form.factory';
@Component({
  selector: 'app-create-profil',
  templateUrl: './create-profil.component.html',
  styleUrls: ['./create-profil.component.css']
})
export class CreateProfilComponent implements OnInit {
profil: Profil = new Profil();
garden: Garden = new Garden();
address: Address = new Address();
submitted = false;
profilId: number;
addressId: number;
name: string;
errors: string;
readonly errorMessages = this.forms.errorMessages;
@ViewChild('contactForm', null) contactForm: NgForm;
 protected myform: FormGroup;
// protected gardenForm: FormGroup;


  constructor(private formBuilder: FormBuilder,
              protected forms: FormFactory,
              private profilService: ProfilService,
              private router: Router,
              private gardenService: GardenService,
              private addressService : AddressService) { }

  
  //get name(): AbstractControl { return this.profilForm.get('name'); }
  // get lastname(): AbstractControl{ return this.profilForm.get('lastname')}
  // get mail(): AbstractControl { return this.profilForm.get('mail'); }
  // get phone(): AbstractControl { return this.profilForm.get('phone'); }
  // get gender(): AbstractControl { return this.profilForm.get('gender'); }
  // get localisation(): AbstractControl { return this.profilForm.get('localisation'); }

  // get localisation1(): AbstractControl { return this.gardenlForm.get('localisation1'); }
  // get name1(): AbstractControl { return this.gardenForm.get('name1'); }

  ngOnInit() {


  }
 

  save() {
    this.profilService.createProfil(this.profil)
    .subscribe(data=>
      {
      console.log("voila tron profil = ", data);
    }, error => console.log(error));

    this.gardenService.createGarden(this.garden)
    .subscribe(data=>
      {
      console.log("voila tron profil = ", data);
    }, error => console.log(error));

    this.addressService.createAddress(this.address)
      .subscribe(data => 
      {
        console.log("voila tron profil = ", data);
      }, error => console.log(error));
    
   
  
  }
  
  get() {
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
   
  }
  gotoList(){
    this.router.navigate(['/profils']);
  }
 
}