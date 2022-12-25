import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-infraction-details',
  templateUrl: './infraction-details.component.html',
  styleUrls: ['./infraction-details.component.css']
})
export class InfractionDetailsComponent implements OnInit {

  infractionDetails: any;
  infractionId: any;
  constructor(private http:HttpClient, private activatedRoute: ActivatedRoute, private router: Router) { 
    this.infractionId = activatedRoute.snapshot.params['infractionId'];
  }

  ngOnInit(): void {
    let url = "http://localhost:8888/GATEWAY-SERVICE/INFRACTIONS-MANAGEMENT-SERVICE/query/infractions/"+this.infractionId;
    this.http.get(url).subscribe({
      next: data => {
        this.infractionDetails = data;
      },
      error: err =>{
        console.log(err);
      }
    });
  }

}
