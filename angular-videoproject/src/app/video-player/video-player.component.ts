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
    const id = +this.route.snapshot.paramMap.get('id');
    //console.log(`id test:` + id);
    this.videoService.getVideoByIdTest(id).subscribe(video => this.video = video[0]);

    console.log(this.video)
    //this.videoService.videoPromise(id).then(video => this.video = video);

    //this.video = this.videoService.findVideoById(id).s;

    //this.video = this.videoService.getVideoByIdTest(id).subscribe(async res => {

    // })
  }

}
