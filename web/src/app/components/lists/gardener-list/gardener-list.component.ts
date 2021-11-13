import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { GardenerService} from 'src/app/services/gardener/gardener.service';


import { Router } from '@angular/router';
import { User} from '../../../models/user';

import { AuthService } from 'src/app/services/oauth/auth.service';
import { Gardener } from '../../../models/gardener';

@Component({
  selector: 'app-gardener-list',
  templateUrl: './gardener-list.component.html',
  styleUrls: ['./gardener-list.component.css']
})

export class GardenerListComponent implements OnInit {
 p = 1;
user: User =  new User();
submitted = false;
id: number;
currentUser: any;
gardeners: Observable<Gardener[]>;
  constructor( private router: Router, private authService: AuthService, private gardenerService: GardenerService) { }

  ngOnInit() {
    this.reloadData();
    this.currentUser = this.authService.getCurrentUser();
    
  }
  reloadData() {
    this.gardeners = this.gardenerService.getGardenerList();
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
  gotoCreateGardener(){
    this.router.navigate(['add-gardening']);
  }
}
