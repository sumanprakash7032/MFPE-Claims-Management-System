import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Member } from '../member';
import { MemberService } from '../member.service';
import { User } from '../user';

@Component({
  selector: 'app-memberdetails-module',
  templateUrl: './memberdetails-module.component.html',
  styleUrls: ['./memberdetails-module.component.css']
})
export class MemberdetailsModuleComponent implements OnInit {
  member =new Member();
  key1 : any;
  mem : any;
  errormsg='';
 
  
  constructor(private _service : MemberService, private _route : Router) { }

  ngOnInit(): void {
    this.key1 = sessionStorage.getItem("key");
   
}
logout(){
  console.log("logout");
  sessionStorage.removeItem('key');
}

  memberl(){
    if(sessionStorage.getItem('token')){
    this._service.memberForm(this.member).subscribe(
      (data : Member[]) => { console.log("response received");
      console.log(data);
      this._route.navigate(['/memberdet1Module'],{
        skipLocationChange : true,
        queryParams:{
          data : JSON.stringify(data)
        }
      });
     
    },
    error =>{
      console.log("Bad credentials");
      this.errormsg="Please Enter Correct Member ID or Policy ID";
    }
  )
    }
     else{
       alert("Please relogin");
     }

  }
  

}
