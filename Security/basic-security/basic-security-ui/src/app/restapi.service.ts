import { Injectable } from '@angular/core';
import { HttpHeaders,HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class RestapiService {

  constructor(private http:HttpClient) { }

  public login (username:String,password:String){
    console.log(username,password)
    console.log(btoa(username+":"+password))
    const headers=new HttpHeaders({Authorization:'Basic '+btoa(username+":"+password)})
    return this.http.get("http://localhost:8381/",{headers,responseType:'text' as 'json'});
  }

  public currentUser (){
    return this.http.get("http://localhost:8381/user-name",{responseType:'text' as 'json'});
  }
}
