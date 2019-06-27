import { OAuthService } from 'angular-oauth2-oidc';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private oauthService: OAuthService, private router: Router) { }
 
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    console.log("Check if token valid "+this.oauthService.hasValidIdToken());
    if (this.oauthService.hasValidAccessToken()) {
      return true;
    }

    this.router.navigateByUrl('');
    return false;
  }
}
