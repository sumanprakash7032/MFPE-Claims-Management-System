import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Submit } from './submit';

@Injectable({
  providedIn: 'root'
})
export class SubmitService {

  constructor(private _http : HttpClient) { }

  public submitClaim(submit : Submit):Observable<any>{
    var x:any;
  
    x = sessionStorage.getItem('token');
 
   const header = new HttpHeaders({ 
     'Content-Type': 'application/json',
     'Authorization': 'Bearer ' + JSON.parse(x).jwtToken
  });
    return this._http.post<Submit>("http://localhost:8020/member/submitClaim/"+submit.policyId+"/"+submit.claimId+"/"+submit.memberId+"/"+submit.providerId+"/"+submit.benefitId+"/"+submit.totalBilledAmount+"/"+submit.totalClaimedAmount,submit,{headers: header})
  }

}
