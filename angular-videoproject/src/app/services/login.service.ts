import { Injectable } from '@angular/core';
import {User} from "../user/user";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  currentUser: User;

  constructor() { }


  logIn(user: User){
    //tempUser: this.http.get("http://localhost:8080/user/" + user.userId).subscribe(user => this.currentUser = user);

    console.log(user.userId);
    console.log(user.password);
    console.log(this.currentUser);
  }

}
