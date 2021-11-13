import { Component, OnInit} from '@angular/core';
import { Observable } from 'rxjs';
import { ProfilService } from 'src/app/services/profil/profil.service';
import { Profil } from 'src/app/models/profil';
import { GardenService } from 'src/app/services/garden/garden.service';
import { Garden } from 'src/app/models/garden';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';
import { User} from 'src/app/models/user';


@Component({
  selector: 'app-profil-list',
  templateUrl: './profil-list.component.html',
  styleUrls: ['./profil-list.component.css']
})
export class ProfilListComponent implements OnInit {
  profils: Observable<Profil[]>;
  profil: Profil = new Profil();
  garden: Garden = new Garden();
  users: Observable<User[]>;
  p = 1;
  submitted = false;
  id: number;
  constructor(private userService: UserService,
              private profilService: ProfilService,
              private router: Router,
              private gardenService: GardenService) {
    this.garden = new Garden();
  }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.users = this.userService.getUsersList();
  }


  get(gardenId) {
    this.gardenService.getGarden(gardenId)
    .subscribe(data => {
      this.gardenService.garden = data;
      this.goto();
    });
  }
  goto() {
    this.router.navigate(['/garden']);
  }

  getH() {
    this.gotohome();
  }

  gotohome() {
    this.router.navigate(['/homepage']);
  }
  pageChange(newPage: number) {
    this.router.navigate([''], { queryParams: { page: newPage } });
  }
}


