import { Component, EventEmitter, Output } from '@angular/core';
import {FormsModule, NgForm} from "@angular/forms";
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-add-restaurant-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-restaurant-form.component.html',
  styleUrl: './add-restaurant-form.component.css'
})
export class AddRestaurantFormComponent {

  @Output("restaurantSubmitted") restaurantSubmitted = new EventEmitter<AddRestaurantFormData>();

  public formData: AddRestaurantFormData = {
    nom: "",
    adresse : "",
    tags : [],
  }

  public submit(form: NgForm): void {
    if (form.valid) {
      this.restaurantSubmitted.emit(this.formData);
    }
  }

}

export interface AddRestaurantFormData {
  nom: string,
  adresse : string,
  tags : string[],
}
