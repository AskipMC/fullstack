import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RestaurantDto} from "../models/restaurant.dto";
import { AddRestaurantFormData } from '../components/restaurant/add-restaurant-form/add-restaurant-form.component';
import { RestaurantDetailDto } from '../models/restaurantdetail.dto';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private httpClient: HttpClient) {
    this.loadRestaurants();
  }

  public loadRestaurants(): Observable<RestaurantDto[]> {
    return this.httpClient.get<RestaurantDto[]>(`http://localhost:8080/restaurants`)
  }

  public loadRestaurant(id: number): Observable<RestaurantDetailDto> {
    return this.httpClient.get<RestaurantDetailDto>(`http://localhost:8080/restaurants/`+id)
  }

  public addRestaurant(newRestaurant: AddRestaurantFormData): Observable<RestaurantDto> {
    return this.httpClient.post<RestaurantDto>(`http://localhost:8080/restaurants`, newRestaurant)
  }

}
