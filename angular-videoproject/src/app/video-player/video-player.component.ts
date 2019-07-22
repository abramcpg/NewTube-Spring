import {Component, Input, OnInit} from '@angular/core';
import { Video} from "../video";
import {VideoService} from "../videoservice.service";
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs";

@Component({
  selector: 'app-video-player',
  templateUrl: './video-player.component.html',
  styleUrls: ['./video-player.component.css']
})


export class VideoPlayerComponent implements OnInit {
  @Input() video: Video;

  constructor(private videoService: VideoService,
              private route: ActivatedRoute
              //private location: Location
) { }

  ngOnInit(): void {
    this.getVideo();
    console.log(this.video);

  }

  getVideo() {
    const id = +this.route.snapshot.paramMap.get('videoId');
    //console.log(`videoId test:` + videoId);
    this.videoService.getVideoByIdTest(id).subscribe(video => this.video = video);

    console.log(this.video)
    //this.videoService.videoPromise(videoId).then(video => this.video = video);

    //this.video = this.videoService.findVideoById(videoId).s;

    //this.video = this.videoService.getVideoByIdTest(videoId).subscribe(async res => {

    // })
  }

}
