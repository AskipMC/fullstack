import { Component } from '@angular/core';
import { AddEvaluationFormComponent, AddEvaluationFormData } from "./add-evaluation-form/add-evaluation-form.component";
import { RestaurantDetailDisplayComponent } from "./restaurant-detail-display/restaurant-detail-display.component";
import { UpdateRestaurantFormComponent } from "./update-restaurant-form/update-restaurant-form.component";
import { RestaurantService } from '../../services/restaurant.service';
import { RestaurantDetailDto } from '../../models/restaurantdetail.dto';
import { ActivatedRoute, RouterLink, RouterOutlet } from '@angular/router';
import { EvaluationService } from '../../services/evaluation.service';

@Component({
  selector: 'app-restaurant-detail',
  standalone: true,
  imports: [AddEvaluationFormComponent, RestaurantDetailDisplayComponent, UpdateRestaurantFormComponent, RouterLink, RouterOutlet],
  templateUrl: './restaurant-detail.component.html',
  styleUrl: './restaurant-detail.component.css'
})
export class RestaurantDetailComponent {

  public restaurant?: RestaurantDetailDto;

  constructor(private route: ActivatedRoute, private readonly evaluationService: EvaluationService, private readonly restaurantService: RestaurantService) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(value => {
      const id = parseInt(value['id']);
      this.refreshRestaurant(id);
    })
  }

  refreshRestaurant(id : number) {
    this.restaurantService.loadRestaurant(id).subscribe(value => {
      this.restaurant = value;
    })
  }

  onEvaluationSubmitted(newEvaluationData: AddEvaluationFormData) : void {
    if(this.restaurant == undefined) return;

    this.evaluationService.addEvaluation(this.restaurant.id, newEvaluationData).subscribe(value => {
      this.restaurant?.evaluations.push(value);
    })
  }

  onDeleteEvaluation(id : number) : void {
    this.evaluationService.deleteEvaluation(id).subscribe(
      () => {
        if(this.restaurant != undefined) this.refreshRestaurant(this.restaurant.id);
      }
    );
  }
}
