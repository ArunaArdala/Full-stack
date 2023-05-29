import { Component } from '@angular/core';
import { Router } from '@angular/router';
// import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  currentEnv : string;
  constructor( public router : Router)
  {
      this.currentEnv = "Development";
      this.router.navigate(['']);
      console.log("constructor");
  }

  signoutUser()
  {

  }

  NavToHome()
  {
    this.router.navigate([''])
  }
}
