import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OAuthModule } from 'angular-oauth2-oidc';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { AuthInterceptor } from './security/auth-interceptor';
import { BookComponent } from './book/book.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    BookComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    OAuthModule.forRoot()

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
