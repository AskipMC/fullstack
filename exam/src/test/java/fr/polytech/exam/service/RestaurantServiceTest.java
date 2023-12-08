package fr.polytech.exam.service;


import fr.polytech.exam.exception.ResourceNotFoundException;
import fr.polytech.exam.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    @Test
    public void get_restaurant_with_impossible_id() {
        assertThrows(ResourceNotFoundException.class, () -> this.restaurantService.getRestaurantById(-1));
    }
}
