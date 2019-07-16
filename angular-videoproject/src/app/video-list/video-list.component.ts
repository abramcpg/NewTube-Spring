import { Component, OnInit } from '@angular/core';
import { Video } from '../video';
import { VideoService } from '../videoservice.service';

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrls: ['./video-list.component.css']
})
export class VideoListComponent implements OnInit {

  videos: Video[];

  constructor(private videoService: VideoService) {
  }

  ngOnInit() {
    this.videoService.findAll().subscribe(data => {
      this.videos = data;
    });
  }
}
