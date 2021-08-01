import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClaimInputComponent } from './claim-input/claim-input.component';
import { ClaimOutputComponent } from './claim-output/claim-output.component';
import { ContactModuleComponent } from './contact-module/contact-module.component';
import { LoginModuleComponent } from './login-module/login-module.component';
import { MemberModuleComponent } from './member-module/member-module.component';
import { Memberdet1Component } from './memberdet1/memberdet1.component';
import { MemberdetailsModuleComponent } from './memberdetails-module/memberdetails-module.component';
import { SubmitInputComponent } from './submit-input/submit-input.component';
import { SubmitOutputComponent } from './submit-output/submit-output.component';

const routes: Routes = [
  {path : 'loginModule',component : LoginModuleComponent},
  {path : 'memberModule', component : MemberModuleComponent},
  {path : 'contactModule', component : ContactModuleComponent},
  {path : 'memberdetailsModule', component : MemberdetailsModuleComponent},
  {path : 'memberdet1Module', component : Memberdet1Component},
  {path : 'claimInput', component : ClaimInputComponent},
  {path : 'claimOutput', component : ClaimOutputComponent},
  {path : 'submitInput', component : SubmitInputComponent},
  {path : 'submitOutput', component : SubmitOutputComponent},
  {path:'',redirectTo:'/loginModule',pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [LoginModuleComponent,MemberModuleComponent,
  ContactModuleComponent,MemberdetailsModuleComponent,Memberdet1Component,ClaimInputComponent,
  ClaimOutputComponent,SubmitInputComponent]