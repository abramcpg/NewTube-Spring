import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UploadVideoComponent} from "./upload-video/upload-video.component";
import {VideoListComponent} from "./video-list/video-list.component";
import {UserComponent} from "./user/user.component";


const routes: Routes = [
  { path: 'videos', component: VideoListComponent },
  { path: 'adduser', component: UploadVideoComponent },
  { path: 'login', component: UserComponent},
  { path: 'signup', component: UserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
