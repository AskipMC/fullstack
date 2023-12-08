package fr.polytech.exam.controller;

import fr.polytech.exam.dto.request.AddRestaurantDto;
import fr.polytech.exam.dto.request.UpdateRestaurantDto;
import fr.polytech.exam.dto.response.RestaurantDetailDto;
import fr.polytech.exam.dto.response.RestaurantDto;
import fr.polytech.exam.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantDto> getRestaurants() {
        return this.restaurantService.getRestaurants().stream().map(restaurantEntity -> RestaurantDto.buildFromEntity(restaurantEntity)).toList();
    }

    @GetMapping("/restaurants/{id}")
    public RestaurantDetailDto getRestaurantById(@PathVariable Integer id) {
        return RestaurantDetailDto.buildFromEntity(this.restaurantService.getRestaurantById(id));
    }

    @PostMapping("/restaurants")
    public RestaurantDto addRestaurant(@Valid @RequestBody AddRestaurantDto restaurantDto) {
        return RestaurantDto.buildFromEntity(this.restaurantService.addRestaurant(restaurantDto));
    }

    @PutMapping("/restaurants/{id}")
    public RestaurantDto updateRestaurant(@Valid @PathVariable Integer id, @Valid @RequestBody UpdateRestaurantDto updateRestaurantDto) {
        return RestaurantDto.buildFromEntity(this.restaurantService.updateRestaurant(id, updateRestaurantDto.getNom(), updateRestaurantDto.getAdresse()));
    }
}
