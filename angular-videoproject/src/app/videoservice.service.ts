import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Video } from './video';
import {Observable, of} from 'rxjs';
import {tap, catchError} from "rxjs/operators";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({ providedIn: 'root' })
export class VideoService {

  //private videoUrl: 'http://localhost:8080/videos';

  private videoUrl: string;

  constructor(private http: HttpClient) {
    this.videoUrl = 'http://localhost:8080/videos';
  }

  public findAll(): Observable<Video[]> {
    console.log(this.http.get<Video[]>(this.videoUrl));
    return this.http.get<Video[]>(this.videoUrl);
  }

  public findVideoById(id: number): Observable<Video> {
    console.log(this.http.get<Video>(this.videoUrl  + `/videoplayer/${id}`));
    return this.http.get<Video>(this.videoUrl + `/videoplayer/${id}`);
  }

  public save(fileToUpload: EventTarget) {
    return this.http.post<Video>(this.videoUrl + '/uploadFile', fileToUpload);
  }

  getVideoByIdTest(id: number): Observable<Video[]> {
    const url = `${this.videoUrl}/videostorage/${id}`;
    let asdf = this.http.get<Video[]>(url).pipe(
      tap(_ => this.log(`fetched video id=${id}`)),
      catchError(this.handleError<Video>(`getVideo id=${id}`))
    );

    console.log(asdf);

    return asdf as Observable<Video[]>;
  }

  videoPromise(id: number): Promise<Video> {
    const url = `${this.videoUrl}/videostorage/${id}`;
    return this.http.get(url)
      .toPromise().then(response => response as Video);
  }


  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  private log(message: string) {
    console.log(`VideoService: ${message}`);
  }
}
