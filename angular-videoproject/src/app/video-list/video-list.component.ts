import { Component, OnInit } from '@angular/core';
import { Video } from '../classes/video';
import { VideoService } from '../services/videoservice.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrls: ['./video-list.component.css']
})
export class VideoListComponent implements OnInit {

  videos: Video[];

  constructor(private videoService: VideoService, private router: Router) {
  }

  ngOnInit() {
    this.videoService.findAll().subscribe(data => {
      this.videos = data;
    });
  }

  gotoVideo(videoId: Number): void {
    this.router.navigate(['/videos/videoplayer' + videoId]);
  }




}
