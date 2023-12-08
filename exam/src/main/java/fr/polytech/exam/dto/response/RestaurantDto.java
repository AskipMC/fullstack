package fr.polytech.exam.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.exam.entity.RestaurantEntity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    @Size(max = 90)
    private String nom;

    @JsonProperty("adresse")
    @Size(max = 255)
    private String adresse;

    @JsonProperty("moyenne")
    private double moyenne;

    @JsonProperty("notefinale")
    private Integer notefinale;

    public static RestaurantDto buildFromEntity(RestaurantEntity restaurantEntity) {

        double DEFAULT_MOYENNE = -1;
        int DEFAULT_NOTE = -1;

        return RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .adresse(restaurantEntity.getAdresse())
                .notefinale(restaurantEntity.getEvaluationFinale() != null ? restaurantEntity.getEvaluationFinale().getNote() : DEFAULT_NOTE)
                .moyenne(restaurantEntity.getEvaluations() != null ? restaurantEntity.getEvaluations().stream().mapToInt(eval -> eval.getNote()).average().orElse(-1) : DEFAULT_MOYENNE)
                .build();
    }

}
