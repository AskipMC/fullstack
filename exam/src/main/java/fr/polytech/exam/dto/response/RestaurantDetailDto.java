package fr.polytech.exam.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.exam.entity.EvaluationEntity;
import fr.polytech.exam.entity.RestaurantEntity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDetailDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    @Size(max = 90)
    private String nom;

    @JsonProperty("adresse")
    @Size(max = 255)
    private String adresse;

    @JsonProperty("evaluations")
    private List<EvaluationDto> evaluations;

    public static RestaurantDetailDto buildFromEntity(RestaurantEntity restaurantEntity) {
        return RestaurantDetailDto.builder()
                .id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .adresse(restaurantEntity.getAdresse())
                .evaluations(restaurantEntity.getEvaluations().stream().map(evaluation -> EvaluationDto.buildFromEntity(evaluation)).toList())
                .build();
    }

}
