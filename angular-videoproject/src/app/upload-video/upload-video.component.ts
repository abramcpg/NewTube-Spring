import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Video } from '../video';
import { VideoService } from '../videoservice.service';


@Component({
  selector: 'app-upload-video',
  templateUrl: './upload-video.component.html',
  styleUrls: ['./upload-video.component.css']
})

export class UploadVideoComponent {

  video: Video;

  constructor(private route: ActivatedRoute, private router: Router, private videoService: VideoService) {
    this.video = new Video();
  }

  onSubmit() {
    this.videoService.save(this.video).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/videos']);
  }
}

