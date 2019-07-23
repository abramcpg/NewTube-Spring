import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from "../user/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private currentUser: User;

  constructor(private http: HttpClient) {
    this.currentUser = new User();
  }

  public addUser(user) {
    console.log(user);
    this.http.post("http://localhost:8080/users", user).subscribe();
  }


  public logIn(user : User){

    this.http.get<User>("http://localhost:8080/user/" + user.userId).subscribe(user =>
    {
      let tempUser = user;
      if (user.password === tempUser.password && user.password === tempUser.password){
        this.currentUser = tempUser;
      } else {
        this.currentUser = null;
        console.log('Wrong username or password');
      }

    });

    console.log(user.userId);
    console.log(user.password);
    console.log(this.currentUser);

  }





}
