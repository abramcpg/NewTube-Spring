import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from "../user/user";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private currentUser: any;
  private tempUser: User;

  constructor(private http: HttpClient) {
  }

  public addUser(user) {
    console.log(user);
    this.http.post("http://localhost:8080/users", user).subscribe();
  }


  public logIn(user : User){

    tempUser: this.http.get("http://localhost:8080/user/" + user.userId).subscribe(user => this.currentUser = user);



    console.log(user.userId);
    console.log(user.password);



    console.log(this.currentUser);


  }





}
