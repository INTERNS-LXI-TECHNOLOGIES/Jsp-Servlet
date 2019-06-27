import { Component } from '@angular/core';
import { OAuthService, NullValidationHandler, AuthConfig, JwksValidationHandler } from 'angular-oauth2-oidc';
import { filter } from 'rxjs/operators';

export const authConfig: AuthConfig = {
  issuer: 'http://localhost:8082/auth/realms/Library',
  redirectUri: window.location.origin,
  clientId: 'account',
  scope: 'openid profile email',
  dummyClientSecret: '3975ee7c-71ad-4da4-a2f5-e0ce39268dc7',
  tokenEndpoint: 'http://localhost:8082/auth/realms/Library/protocol/openid-connect/token',
  userinfoEndpoint: 'http://localhost:8082/auth/realms/Library/protocol/openid-connect/userinfo',
  oidc:false,
  requireHttps:false

  
};

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Library';

  constructor(
    private oauthService: OAuthService,
  ) {

   this.configureWithNewConfigApi();
   //this.configurePasswordFlow();
   //this.configureAuth();

  }


  

  private configureWithNewConfigApi() {
    this.oauthService.configure(authConfig);
    this.oauthService.setStorage(localStorage);
    this.oauthService.tokenValidationHandler = new JwksValidationHandler();
    this.oauthService.loadDiscoveryDocumentAndTryLogin();

    this.oauthService.setupAutomaticSilentRefresh();

    this.oauthService.events.subscribe(e => {
      console.debug('oauth/oidc event', e);
    });

    this.oauthService.events
      .pipe(filter(e => e.type === 'session_terminated'))
      .subscribe(e => {
        console.debug('Your session has been terminated!');
      });

    this.oauthService.events
      .pipe(filter(e => e.type === 'token_received'))
      .subscribe(e => {
      });
  }

  private configureAuth() {
    this.oauthService.redirectUri = window.location.origin + '/index.html';

    this.oauthService.silentRefreshRedirectUri =
      window.location.origin + '/silent-refresh.html';

    this.oauthService.clientId = 'account';

    this.oauthService.scope = 'openid profile email voucher';

    this.oauthService.issuer =
      'http://localhost:8082/auth/realms/Library';

    this.oauthService.tokenValidationHandler = new NullValidationHandler();

    this.oauthService.events.subscribe(e => {
      console.debug('oauth/oidc event', e);
    });

    this.oauthService.loadDiscoveryDocument().then(doc => {
      this.oauthService.tryLogin();
    });

    this.oauthService.events
      .pipe(filter(e => e.type === 'token_expires'))
      .subscribe(e => {
        console.debug('received token_expires event', e);
        this.oauthService.silentRefresh();
      });
  }

  private configurePasswordFlow() {

    this.oauthService.dummyClientSecret = '3975ee7c-71ad-4da4-a2f5-e0ce39268dc7';
  }


}
