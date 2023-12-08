import { Component } from '@angular/core';
import { AddRestaurantFormComponent, AddRestaurantFormData } from "./add-restaurant-form/add-restaurant-form.component";
import { RestaurantDisplayComponent } from "./restaurant-display/restaurant-display.component";
import { RestaurantService } from '../../services/restaurant.service';
import { RestaurantDto } from '../../models/restaurant.dto';

@Component({
  selector: 'app-restaurant',
  standalone: true,
  imports: [AddRestaurantFormComponent, RestaurantDisplayComponent],
  templateUrl: './restaurant.component.html',
  styleUrl: './restaurant.component.css'
})
export class RestaurantComponent {

  public restaurants: RestaurantDto[] = [];

  constructor(private readonly restaurantService: RestaurantService) {
  }

  ngOnInit(): void {
    this.refreshRestaurants();
  }

  refreshRestaurants() {
    this.restaurantService.loadRestaurants().subscribe(value => {
      this.restaurants = value;
    })
  }

  onRestaurantSubmitted(newRestaurantData: AddRestaurantFormData) : void {
    this.restaurantService.addRestaurant(newRestaurantData).subscribe(value => {
      this.restaurants.push(value);
    })
  }


}
