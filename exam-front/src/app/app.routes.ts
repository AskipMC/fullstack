import { Routes } from '@angular/router';
import { RestaurantComponent } from "./components/restaurant/restaurant.component";
import { RestaurantDetailComponent } from "./components/restaurant-detail/restaurant-detail.component";

export const routes: Routes = [
    {
      path: '', redirectTo: 'restaurants', pathMatch: "full"
    },
    {
      path: 'restaurants', component: RestaurantComponent
    },
    {
      path: 'restaurants/:id', component: RestaurantDetailComponent
    }
  ];
  