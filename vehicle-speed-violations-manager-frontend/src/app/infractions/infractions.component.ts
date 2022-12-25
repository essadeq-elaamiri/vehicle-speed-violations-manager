import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-infractions',
  templateUrl: './infractions.component.html',
  styleUrls: ['./infractions.component.css']
})
export class InfractionsComponent implements OnInit {

  infractionsList: any

  constructor(private http:HttpClient, private activateRoute: ActivatedRoute, private router: Router) { 
    
  }

  ngOnInit(): void {
    let url = "http://localhost:8888/GATEWAY-SERVICE/INFRACTIONS-MANAGEMENT-SERVICE/query/infractions"

    this.http.get(url).subscribe({
      next: data => {
        this.infractionsList = data;
      },
      error: err =>{
        console.log(err);
      }
    });

  }

  getInfractionDetails(infraction: any):void{
    this.router.navigateByUrl(`/infractionDetails/${infraction.id}`)
  }

}
