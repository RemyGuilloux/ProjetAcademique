import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthService } from '../auth.service';
import { User} from '../../../models/user';
import { UserService } from '../../../services/user/user.service';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
user: User =  new User();


  constructor(private authService: AuthService, private router: Router) { }

  canActivate() {
      if (this.authService.isLoggedIn()) {
       return true;
      }else {
     this.router.navigate(['/welcome']);
    }
}
}
