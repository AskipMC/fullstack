package fr.polytech.exam.service;

import fr.polytech.exam.dto.request.AddEvaluationDto;
import fr.polytech.exam.entity.EvaluationEntity;
import fr.polytech.exam.entity.RestaurantEntity;
import fr.polytech.exam.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final RestaurantService restaurantService;

    public EvaluationEntity addEvaluationToRestaurant(final Integer restaurantId, final AddEvaluationDto evaluationDto) {

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        final RestaurantEntity restaurantEntity = this.restaurantService.getRestaurantById(restaurantId);
        final EvaluationEntity evaluationEntity = EvaluationEntity.builder()
                .auteur(evaluationDto.getAuteur())
                .commentaire(evaluationDto.getCommentaire())
                .note(evaluationDto.getNote())
                .creation(date)
                .modification(date)
                .restaurant(restaurantEntity)
                .build();

        return this.evaluationRepository.save(evaluationEntity);
    }

    public void deleteEvaluation(final Integer restaurantId) {
        this.evaluationRepository.deleteById(restaurantId);
    }
}
