package fr.polytech.exam.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.exam.entity.EvaluationEntity;
import fr.polytech.exam.entity.RestaurantEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("auteur")
    @Size(max = 50)
    private String auteur;

    @JsonProperty("commentaire")
    @Size(max = 255)
    private String commentaire;

    @JsonProperty("note")
    @Max(3)
    @Min(0)
    private Integer note;
    public static EvaluationDto buildFromEntity(EvaluationEntity evaluationEntity) {
        return EvaluationDto.builder()
                .id(evaluationEntity.getId())
                .auteur(evaluationEntity.getAuteur())
                .commentaire(evaluationEntity.getCommentaire())
                .note(evaluationEntity.getNote())
                .build();
    }

}
