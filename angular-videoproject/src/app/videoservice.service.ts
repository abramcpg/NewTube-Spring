import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Video } from './video';
import { Observable } from 'rxjs';

@Injectable()
export class VideoService {

  private videoUrl: string;

  constructor(private http: HttpClient) {
    this.videoUrl = 'http://localhost:8080/videos';
  }

  public findAll(): Observable<Video[]> {
    console.log(this.http.get<Video[]>(this.videoUrl));
    return this.http.get<Video[]>(this.videoUrl);
  }

  public save(fileToUpload: File) {
    return this.http.post<Video>(this.videoUrl + "/uploadFile", fileToUpload);
  }
}