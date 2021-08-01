import { Component, OnInit } from '@angular/core';

import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-login-module',
  templateUrl: './login-module.component.html',
  styleUrls: ['./login-module.component.css']
})
export class LoginModuleComponent implements OnInit {
  user =new User();
  errormsg='';
  
  constructor(private _service : RegistrationService , private _route : Router) { }

  ngOnInit(): void {
 
  }

  loginUser(){
    this._service.loginUserFormRemote(this.user).subscribe(
      data =>{
        console.log("response received");
        console.log(data);
        sessionStorage.setItem('token',JSON.stringify(data));
        this._route.navigate(['/memberModule'],{
          skipLocationChange : true,
          queryParams : {
            data : JSON.stringify(data)
          }
          
        });

      },
      error =>{
        console.log("Bad credentials");
        this.errormsg="Please Enter Correct Username or Password";
      }
    )
  }

}
