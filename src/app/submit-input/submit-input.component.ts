import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Submit } from '../submit';
import { SubmitService } from '../submit.service';

@Component({
  selector: 'app-submit-input',
  templateUrl: './submit-input.component.html',
  styleUrls: ['./submit-input.component.css']
})
export class SubmitInputComponent implements OnInit {
submit = new Submit();
key1 : any;
  constructor(private _service : SubmitService , private _route : Router) { }

  ngOnInit(): void {
    this.key1 = sessionStorage.getItem("key");
  }
  logout(){
    console.log("logout");
    sessionStorage.removeItem('key');
  }

  submitForm(){
    if(sessionStorage.getItem('token')){
    this._service.submitClaim(this.submit).subscribe(
      data =>{
        console.log("response received");
        console.log(data);
        this._route.navigate(['/submitOutput'],{
          skipLocationChange : true,
          queryParams:{
            data : JSON.stringify(data)
          }
        });

      },
      error =>{
        console.log("Bad credentials");
        
      }
    )
    }
     else{
    
       alert("Please relogin");
     }
  }
}
