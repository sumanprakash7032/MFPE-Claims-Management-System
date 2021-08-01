import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Claim } from './claim';
import { Member } from './member';

@Injectable({
  providedIn: 'root'
})
export class ClaimService {
  claimForm(claim: Claim) {
    throw new Error('Method not implemented.');
  }

  constructor(private _http :HttpClient) { }

  public claimStatus(claim : Claim):Observable<Claim>{
    var x:any;
  
    x = sessionStorage.getItem('token');
 
   const header = new HttpHeaders({ 
     'Content-Type': 'application/json',
     'Authorization': 'Bearer ' + JSON.parse(x).jwtToken
  });
    console.log("10  "+sessionStorage.getItem('token'));
    return this._http.get<Claim>("http://localhost:8020/member/getClaimStatus/"+claim.claimId+"/"+claim.policyId+"/"+claim.memberId, {headers: header})
    }
}
