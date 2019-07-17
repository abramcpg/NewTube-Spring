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

  switchVideo(video: Video){

    console.log(video.videoPath);

    let videoPlayer = document.getElementById('myVideo');
    //let videoPlayer = document.createElement("video");


    // if (videoPlayer.hasChildNodes()){
    //   videoPlayer.removeChild(videoPlayer.firstChild);
    // }

    let source = document.createElement('source');
    //let type = document.createElement('type');


    source.setAttribute('src', video.videoPath);
    source.setAttribute('type', video.videoType);


    videoPlayer.appendChild(source);
    //document.body.replaceChild(ogVideoPlayer, videoPlayer);

  }
}
