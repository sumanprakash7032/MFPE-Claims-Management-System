import { Component, EventEmitter, Inject, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

import { Claim } from '../claim';
import { ClaimService } from '../claim.service';
import { Member } from '../member';


@Component({
  selector: 'app-claim-input',
  templateUrl: './claim-input.component.html',
  styleUrls: ['./claim-input.component.css']
})

export class ClaimInputComponent implements OnInit {
  @Output() show = new EventEmitter<boolean>();
  claim = new Claim();
  key1 : any;
  constructor(private _service : ClaimService, private _route : Router) { }

  ngOnInit(): void {
    this.key1 = sessionStorage.getItem("key");
  }
  logout(){
    console.log("logout");
    sessionStorage.removeItem('key');
    sessionStorage.removeItem('token');
  }

  claims(){
    console.log("function called");
    if(sessionStorage.getItem('token')) {
    this._service.claimStatus(this.claim).subscribe(
      (data : Claim) => { console.log("response received");
      this._route.navigate(['/claimOutput'],{
        skipLocationChange : true,
        queryParams:{
          data : JSON.stringify(data)
        }
      });
     
    },
    error =>{
      console.log(error);
    }
  )
  }
    else{

     alert('Please relogin');
    }
  }
  

}
