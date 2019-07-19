import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Video } from '../video';
import { VideoService } from '../videoservice.service';
import {Observable} from "rxjs";
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { AngularFileUploaderModule } from "angular-file-uploader";



@Component({
  selector: 'app-upload-video',
  templateUrl: './upload-video.component.html',
  styleUrls: ['./upload-video.component.css']
})

export class UploadVideoComponent {

  video: Video;
  http: 'http://localhost:8080/videos';
  //form: FormGroup;

  constructor(private route: ActivatedRoute, private router: Router, private videoService: VideoService, AngularFileUploaderModule: AngularFileUploaderModule) {
    this.video = new Video();
  }

  onSubmit(event) {
    // this.videoService.save(this.video).subscribe(result => this.gotoVideoList());
    this.videoService.save(event);
  }

  gotoVideoList() {
    this.router.navigate(['/videos']);
  }

  upload(fileToUpload : EventTarget){
    this.videoService.save(fileToUpload);
  }






}

