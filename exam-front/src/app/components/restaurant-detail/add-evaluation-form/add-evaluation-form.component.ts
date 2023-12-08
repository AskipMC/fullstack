import { Component, EventEmitter, Output } from '@angular/core';
import {FormsModule, NgForm} from "@angular/forms";
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-add-evaluation-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-evaluation-form.component.html',
  styleUrl: './add-evaluation-form.component.css'
})
export class AddEvaluationFormComponent {

  @Output("evaluationSubmitted") evaluationSubmitted = new EventEmitter<AddEvaluationFormData>();

  public formData: AddEvaluationFormData = {
    auteur: "",
    commentaire : "",
    note : 0,
  }

  public submit(form: NgForm): void {
    if (form.valid) {
      this.evaluationSubmitted.emit(this.formData);
    }
  }

}

export interface AddEvaluationFormData {
  auteur: string,
  commentaire : string,
  note : number,
}
