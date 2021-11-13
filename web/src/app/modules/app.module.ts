import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from '../app-routing.module';
import { AppComponent } from '../components/app/app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { HomepageComponent } from '../components/homepage/homepage.component';
import { CreateProfilComponent } from '../components/form/create-profil/create-profil.component';
import { ProfilListComponent } from '../components/lists/profil-list/profil-list.component';
import { HeaderComponent } from '../components/header/header.component';
import { GardenListComponent } from '../components/lists/garden-list/garden-list.component';
import { GardenerListComponent } from '../components/lists/gardener-list/gardener-list.component';
import { CreateProfilGardenerComponent } from '../components/form/create-profil-gardener/create-profil-gardener.component';
import { GardenComponent } from '../components/garden/garden.component';
import { BannerComponent } from '../components/banner/banner.component';
;
import { FooterComponent } from '../components/footer/footer.component';
import { AddressComponent } from '../components/address/address.component';
import { LoginComponent } from '../components/form/login/login.component';
import { RegisterComponent } from '../components/form/register/register.component';
import { WelcomeComponent } from '../components/welcome/welcome.component';
import { JwPaginationComponent } from 'jw-angular-pagination';
import { ProfilComponent } from '../components/profil/profil.component';
import { FourComponent } from '../four/four.component';

import {FileUploadModule} from 'ng2-file-upload';
import { UploadFileComponent } from '../components/upload-file/upload-file.component';
import { UpdateGardenComponent } from '../components/form/update-garden/update-garden.component';
import { NgxPaginationModule } from 'ngx-pagination';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AboutUsComponent } from '../components/about-us/about-us.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ScrollingModule} from '@angular/cdk/scrolling';





@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    CreateProfilComponent,
    ProfilListComponent,
    HeaderComponent,
    GardenListComponent,
    GardenerListComponent,
    CreateProfilGardenerComponent,
    GardenComponent,
    BannerComponent,
    FooterComponent,
    AddressComponent,
    LoginComponent,
    RegisterComponent,
    WelcomeComponent,
    JwPaginationComponent,
    ProfilComponent,
    UploadFileComponent,
    UpdateGardenComponent,
    FourComponent,
    AboutUsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    FileUploadModule,
    NgxPaginationModule,
    NgbModule,
    
    FlexLayoutModule,
    ScrollingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
