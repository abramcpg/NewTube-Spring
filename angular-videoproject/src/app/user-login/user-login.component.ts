import { Component, OnInit } from '@angular/core';
import {User} from "../user/user";
import {UserService} from "../user.service";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  private user: User = new User();

  constructor(private service: UserService) { }

  ngOnInit() {

  }

  public addUser() {
    console.log(this.user);
    this.service.addUser(this.user);
  }


  onSubmit() {
    // this.videoService.save(this.video).subscribe(result => this.gotoVideoList());
    //this.service.addUser(event);
    //this.service.logIn(event);
    console.log(this.user);
    this.service.logIn(this.user);
  }
}
