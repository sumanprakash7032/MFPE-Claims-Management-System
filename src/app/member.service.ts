import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Member } from './member';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  constructor(private _http : HttpClient) { }

  public memberForm(member :Member):Observable<Member[]>{
    var x:any;
  
     x = sessionStorage.getItem('token');
  
    const header = new HttpHeaders({ 
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(x).jwtToken
   });
    return this._http.get<Member[]>("http://localhost:8020/member/viewBills/"+member.memberId+"/"+member.policyId, {headers:header})
  }  
}
