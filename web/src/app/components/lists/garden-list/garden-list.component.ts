import { Component, OnInit,Input, OnChanges, SimpleChanges } from '@angular/core';
import { Observable } from 'rxjs';
import { GardenService } from '../../../services/garden/garden.service';
import { Garden } from '../../../models/garden';
import { Router } from '@angular/router';
import { ProfilService } from '../../../services/profil/profil.service';
import { Profil } from '../../../models/profil';
import { AddressService } from '../../../services/address/address.service';
import { Address } from '../../../models/address';
import { ActivatedRoute } from '@angular/router';
import { User} from '../../../models/user';
import { UserService } from '../../../services/user/user.service';
import { AuthService } from 'src/app/services/oauth/auth.service';


@Component({
  selector: 'app-garden-list',
  templateUrl: './garden-list.component.html',
  styleUrls: ['./garden-list.component.css']
})
export class GardenListComponent implements OnInit, OnChanges {
gardens: Observable<Garden[]>;
profil: Profil = new Profil();
address: Address = new Address();
@Input() garden: Garden = new Garden();
user: User =  new User();
submitted = false;
id: number;
currentUser: any;

p = 1;
config: any;
  constructor(private gardenService: GardenService,
              private profilService: ProfilService, private addressService: AddressService,
              private router: Router, private authService: AuthService, ) {
    this.profil = new Profil();
    this.address = new Address();
    this.garden = new Garden();
  }
  ngOnChanges(changes: SimpleChanges){
    console.log((changes));
  }
  ngOnInit() {
    this.reloadData();
    this.currentUser = this.authService.getCurrentUser();
  }
  reloadData() {
    this.gardens = this.gardenService.getGardensList();
  }
  get(profilId) {
    this.profilService.getProfil(profilId)
      .subscribe(data => {
    this.profilService.profil = data;
    this.goto();
      });
  }
  goto() {
    this.router.navigate(['/profil']);
  }

  gotoList1() {
    this.router.navigate(['/profils']);
  }
  getH() {
    this.gotohome();
  }

  gotohome() {
    this.router.navigate(['/homepage']);
  }
  getAd(addressId) {

    this.addressService.getAddress(addressId)
      .subscribe(data => {
        this.addressService.address = data;
        this.gotoAddress();
      });
    }
      deleteGarden(gardenId){
        this.gardenService.deleteGarden(gardenId)
        .subscribe(data => {
          this.gardenService.garden = data;
          this.garden = new Garden();
          });
            }

    gotoAddress() {
    this.router.navigate(['/address']);
  }

  updateGarden(id) {
    this.gotoGardenUpdatePage(id);
  }
  gotoGardenUpdatePage(id) {
    this.router.navigate(['/gardenUpdate', id]);
  }
  pageChange(newPage: number) {
    this.router.navigate([''], { queryParams: { page: newPage } });
  }
}
