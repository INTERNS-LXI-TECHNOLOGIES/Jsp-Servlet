import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AuthGuardService } from './security';
import { LoginComponent } from './login/login.component';
import { BookComponent } from './book/book.component';

const routes: Routes = [  
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'books',
    component: BookComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
