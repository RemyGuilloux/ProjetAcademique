import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateProfilComponent } from './components/form/create-profil/create-profil.component';
import { ProfilListComponent } from './components/lists/profil-list/profil-list.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { GardenListComponent } from './components/lists/garden-list/garden-list.component';
import { ProfilComponent } from './components/profil/profil.component';
import { GardenerListComponent} from './components/lists/gardener-list/gardener-list.component';
import { CreateProfilGardenerComponent } from './components/form/create-profil-gardener/create-profil-gardener.component';

import { GardenComponent } from './components/garden/garden.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { AddressComponent } from './components/address/address.component';
import { AuthGuard } from './services/oauth/guards/auth.gard';
import { UserGuard } from './services/oauth/guards/user.gard';
import { UpdateGardenComponent } from './components/form/update-garden/update-garden.component';
import { AboutUsComponent} from './components/about-us/about-us.component';
import { FourComponent } from './four/four.component';



const routes: Routes = [
  {path: '', redirectTo: '/welcome', pathMatch: 'full'},
  {path: 'gardenUpdate/:id' , canActivate:[AuthGuard], component: UpdateGardenComponent},
  {path: 'gardens', component: GardenListComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'profils', component: ProfilListComponent},
  {path: 'gardening', component: GardenerListComponent},
  {path: 'add', component: CreateProfilComponent},
  {path: 'add-gardening', component: CreateProfilGardenerComponent},
  {path: 'homepage', component: HomepageComponent},
  {path: 'garden', component: GardenComponent},
  {path: 'address', component: AddressComponent},
  {path: 'profil', component: ProfilComponent},
  {path: 'aboutUs', component: AboutUsComponent},
  {path: 'not-found', component: FourComponent},
  {path: '**' , redirectTo: 'not-found'},

  {
    path: 'homepage',
    component: HomepageComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'homepage',
    component: HomepageComponent,
    canActivate: [UserGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
