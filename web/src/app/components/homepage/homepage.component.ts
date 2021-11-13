import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  public homeText: string;
  content: string;
  constructor() { }

  ngOnInit() {
    this.homeText = "WELCOME TO GARDEN APPLICATION"; 
  }
}
