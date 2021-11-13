import { Component, OnInit, ViewChild } from '@angular/core';
import { Observable } from "rxjs";
import { GardenService } from "../../services/garden/garden.service";
import { Garden } from "../../models/garden";

import { Router, ActivatedRoute } from '@angular/router';
import { throwToolbarMixedModesError } from '@angular/material';
import { AddressService } from "../../services/address/address.service";
import { Address } from "../../models/address";


@Component({
  selector: 'app-garden',
  templateUrl: './garden.component.html',
  styleUrls: ['./garden.component.css']
})
export class GardenComponent implements OnInit {
  gardens: Observable<Garden[]>;

  garden: Garden = new Garden();
  address: Address = new Address();
  id: number;
  data: string;

  constructor(private router: Router, private gardenService: GardenService, private addressService: AddressService) {
    this.garden = new Garden();
   }

  ngOnInit() {
    this.garden = this.gardenService.garden;
  }

  get() {
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/profils']);
  }
  getAd(id) {
    console.log("id de l'adresse est =", id);
    this.addressService.getAddress(id)
      .subscribe(data => {
        this.addressService.address = data;
        this.goto();
      });
      }
  goto() {
    this.router.navigate(['/address']);
  }
}









