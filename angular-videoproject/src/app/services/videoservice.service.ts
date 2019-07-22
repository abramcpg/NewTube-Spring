import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Video } from '../classes/video';
import {Observable, of} from 'rxjs';
import {tap, catchError} from "rxjs/operators";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({ providedIn: 'root' })
export class VideoService {

  private videoUrl: string;

  constructor(private http: HttpClient) {
    this.videoUrl = 'http://localhost:8080/videos';
  }

  public findAll(): Observable<Video[]> {
    console.log(this.http.get<Video[]>(this.videoUrl));
    return this.http.get<Video[]>(this.videoUrl);
  }


  public save(fileToUpload: EventTarget) {
    return this.http.post<Video>(this.videoUrl + '/uploadFile', fileToUpload);
  }

  getVideoById(id: number): Observable<Video> {
    const url = `${this.videoUrl}/videostorage/${id}`;
    return this.http.get<Video>(url).pipe(
      tap(_ => this.log(`fetched video id=${id}`)),
      catchError(this.handleError<Video>(`getVideo id=${id}`))
    );
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
