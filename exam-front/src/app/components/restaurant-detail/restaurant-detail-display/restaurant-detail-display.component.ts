import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RestaurantDetailDto } from '../../../models/restaurantdetail.dto';
import {CommonModule, NgOptimizedImage} from '@angular/common';

@Component({
  selector: 'app-restaurant-detail-display',
  standalone: true,
  imports: [CommonModule, NgOptimizedImage],
  templateUrl: './restaurant-detail-display.component.html',
  styleUrl: './restaurant-detail-display.component.css'
})
export class RestaurantDetailDisplayComponent {
  
  @Output("deleteEvaluationSubmitted") deleteEvaluationSubmitted = new EventEmitter<number>();

  @Input() restaurant?: RestaurantDetailDto;

  deleteEvaluation(id : number) {
    this.deleteEvaluationSubmitted.emit(id);
  }

}
