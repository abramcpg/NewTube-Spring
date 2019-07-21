import { Component } from '@angular/core';
import { FileUploader } from 'ng2-file-upload';
import {User} from "./user/user";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Welcome to NewTube!';
  user = new User();


}
