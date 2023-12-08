import { Component, Input } from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';
import { RestaurantDto } from '../../../models/restaurant.dto';
import {RouterLink, RouterOutlet} from '@angular/router';
import { RestaurantColoredDirective } from '../../../directives/restaurant-colored';

@Component({
  selector: 'app-restaurant-display',
  standalone: true,
  imports: [CommonModule, NgOptimizedImage, RouterLink, RouterOutlet, RestaurantColoredDirective],
  templateUrl: './restaurant-display.component.html',
  styleUrl: './restaurant-display.component.css'
})
export class RestaurantDisplayComponent {

  @Input() restaurants: RestaurantDto[] = [];

}
