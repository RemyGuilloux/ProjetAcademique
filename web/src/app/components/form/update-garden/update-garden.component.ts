import { Component, OnInit,Input,Output,EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GardenService } from '../../../services/garden/garden.service';
import { Garden } from '../../../models/garden';

@Component({
  selector: 'app-update-garden',
  templateUrl: './update-garden.component.html',
  styleUrls: ['./update-garden.component.css'],
  
})
export class UpdateGardenComponent implements OnInit {

  id: number;
  @Input() garden: Garden;
  submitted = false;
  constructor(private route: ActivatedRoute,private router: Router,private gardenService: GardenService) { }

  ngOnInit() {

    this.garden = new Garden();
    this.id = this.route.snapshot.params['id'];

    this.gardenService.getGarden(this.id)
    .subscribe(data => {
      console.log(data);
      this.garden = data;
    }, error => console.log(error));

  }

  updateGarden() {
    this.gardenService.updateGarden(this.id, this.garden)
    .subscribe(data => this.garden = data);
    this.gotoList();
    }

    onSubmit() {
      this.updateGarden();
    }

    gotoList() {
      console.log(this.gardenService.updateGarden(this.id, this.garden));
      this.router.navigate(['/gardens']);
    }
  }


