import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SubmitService } from '../submit.service';

@Component({
  selector: 'app-submit-output',
  templateUrl: './submit-output.component.html',
  styleUrls: ['./submit-output.component.css']
})
export class SubmitOutputComponent implements OnInit {
  res: any
  key1 : any;
  constructor(private _service : SubmitService, private _route : Router,
    private route : ActivatedRoute) { }
  ngOnInit(): void {
    this.key1 = sessionStorage.getItem("key");
    this.route.queryParams.subscribe(
      result =>{
      this.res = JSON.parse(result.data);
       console.log(JSON.parse(result.data));
      })
  }
  logout(){
    console.log("logout");
    sessionStorage.removeItem('key');
  }

}
