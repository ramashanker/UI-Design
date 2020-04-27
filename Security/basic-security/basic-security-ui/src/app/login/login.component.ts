import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../restapi.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:String;
  password:String;
  message:any;

  constructor(private service:RestapiService,private router:Router) { }

  ngOnInit() {
  }

  doLogin(){
    console.log(this.username,this.password)
    let response=this.service.login(this.username,this.password);
    response.subscribe(data=>{
      console.log(data)
      this.router.navigate(["/home"])

    })
  }
}
