import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { AddEvaluationFormData } from '../components/restaurant-detail/add-evaluation-form/add-evaluation-form.component';
import { EvaluationDto } from '../models/evaluation.dto';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class EvaluationService {

  constructor(private httpClient: HttpClient) {
    
  }

  public addEvaluation(restaurantId : number, newEvaluation: AddEvaluationFormData): Observable<EvaluationDto> {
    return this.httpClient.post<EvaluationDto>(`http://localhost:8080/restaurants/`+restaurantId+`/evaluations`, newEvaluation)
  }

  public deleteEvaluation(evaluationId : number): Observable<any> {
     return this.httpClient.delete(`http://localhost:8080/restaurants/evaluations/`+evaluationId)
  }
}
