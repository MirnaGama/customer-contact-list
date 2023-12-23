import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerContactFormComponent } from './customer-contact-form/customer-contact-form.component';

const routes: Routes = [ { path: 'customer-contact-form', component: CustomerContactFormComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
