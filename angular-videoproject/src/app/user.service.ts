import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public addUser(user) {
    console.log(user);
    this.http.post("http://localhost:8080/users", user).subscribe();
  }
}
