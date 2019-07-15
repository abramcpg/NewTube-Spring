import {Component, Input, OnInit} from '@angular/core';
import { Comment } from './comment';
import {CommentsService} from "../comments.service";

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {
  public comments : Comment[] = [];
  public commentText: string;
  @Input() videoId: string;
  @Input() userId: string;

  constructor(private commentsService: CommentsService) { }

  ngOnInit() {
    console.log("VideoId === " + this.videoId);
    console.log("UserId === " + this.userId);
     this.commentsService.getComments(this.videoId).subscribe(videoComments => {
       this.comments = videoComments.comments;
     });
  }

  addComment() {
    let comment: Comment = new Comment();
    comment.text = this.commentText;
    comment.userId = this.userId;
    this.commentsService.addComment(this.videoId, comment);
    this.commentsService.getComments(this.videoId).subscribe(videoComments => {
      this.comments = videoComments.comments;
    });
  }

}
