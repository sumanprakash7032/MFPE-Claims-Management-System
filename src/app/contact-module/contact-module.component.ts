import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact-module',
  templateUrl: './contact-module.component.html',
  styleUrls: ['./contact-module.component.css']
})
export class ContactModuleComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  logout(){
    console.log("logout");
    sessionStorage.removeItem('key');
  }

}
