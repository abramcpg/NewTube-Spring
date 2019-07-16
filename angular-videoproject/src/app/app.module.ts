import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommentsComponent } from './comments/comments.component';
import {FormsModule} from "@angular/forms";
import { VideoListComponent } from './video-list/video-list.component';
import { UploadVideoComponent } from './upload-video/upload-video.component';
import {VideoService} from "./videoservice.service";

@NgModule({
  declarations: [
    AppComponent,
    CommentsComponent,
    VideoListComponent,
    UploadVideoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [VideoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
