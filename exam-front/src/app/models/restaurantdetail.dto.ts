import { EvaluationDto } from "./evaluation.dto";

export interface RestaurantDetailDto {
    id: 0,
    nom: "",
    adresse: "",
    evaluations: EvaluationDto[],
}