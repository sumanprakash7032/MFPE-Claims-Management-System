import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-memberdet1',
  templateUrl: './memberdet1.component.html',
  styleUrls: ['./memberdet1.component.css']
})
export class Memberdet1Component implements OnInit {

  constructor(private _route : Router,private route : ActivatedRoute) { }
  res: any

  ngOnInit(): void {
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
