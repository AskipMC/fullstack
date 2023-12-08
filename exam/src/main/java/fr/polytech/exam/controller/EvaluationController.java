package fr.polytech.exam.controller;


import fr.polytech.exam.dto.request.AddEvaluationDto;
import fr.polytech.exam.dto.response.EvaluationDto;
import fr.polytech.exam.service.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping("/restaurants/{restaurantId}/evaluations")
    public EvaluationDto addEvaluation(@Valid @PathVariable Integer restaurantId, @Valid @RequestBody AddEvaluationDto evaluationDto) {
        return EvaluationDto.buildFromEntity(this.evaluationService.addEvaluationToRestaurant(restaurantId, evaluationDto));
    }

    @DeleteMapping("/restaurants/evaluations/{evaluationId}")
    public void deleteEvaluation(@Valid @PathVariable Integer evaluationId) {
        this.evaluationService.deleteEvaluation(evaluationId);
    }

}
