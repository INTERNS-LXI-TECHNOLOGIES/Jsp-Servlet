import { Component, OnInit } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';
import { HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  constructor(
    private oauthService: OAuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  login() {
    console.log(this.username);
    this.oauthService.fetchTokenUsingPasswordFlowAndLoadUserProfile(this.username, this.password, new HttpHeaders())
    .then(() => {
      let claims = this.oauthService.getIdentityClaims();
      if (claims) console.log(claims);
      if (this.oauthService.hasValidAccessToken()) {
        this.router.navigateByUrl('/home')
      }
    }).catch((err:HttpErrorResponse)=>{
      console.log(err.error.error_description);
    });
  }

}
