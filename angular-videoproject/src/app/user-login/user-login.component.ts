import { Component, OnInit } from '@angular/core';
import {User} from "../user/user";
import {UserService} from "../services/user.service";
import {LoginService} from "../services/login.service";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  private user: User = new User();

  constructor(private service: UserService,
              private logInService: LoginService) { }

  ngOnInit() {

  }

  public addUser() {
    console.log(this.user);
    this.service.addUser(this.user);
  }


  onSubmit() {
    //this.service.logIn(event);
    console.log(this.user);
    this.service.logIn(this.user);
  }
}
