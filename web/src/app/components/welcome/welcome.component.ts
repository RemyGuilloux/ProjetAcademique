import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  isDisabled: boolean;
  constructor() {
    this.isDisabled = false;
   }

  ngOnInit() {
  }
  toggleDisable() {
    if(this.isDisabled) {
      this.isDisabled = false;
    }else {
      this.isDisabled = true;
    }
  }
}
