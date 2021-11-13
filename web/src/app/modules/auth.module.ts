import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from '../components/form/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { MatButtonModule, MatFormFieldModule, MatInputModule } from '@angular/material';
import { AuthGuard } from '../services/oauth/guards/auth.gard';
import { AuthService } from '../services/oauth/auth.service';
import { UserGuard } from '../services/oauth/guards/user.gard';
import { TokenInterceptor } from '../services/oauth/token/token-interceptor';



@NgModule({
  declarations: [LoginComponent],
  providers: [
    AuthGuard,
    AuthService,
    UserGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    
  ]
})
export class AuthModule { }