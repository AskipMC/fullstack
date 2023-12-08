package fr.polytech.exam.service;

import fr.polytech.exam.dto.request.AddRestaurantDto;
import fr.polytech.exam.entity.RestaurantEntity;
import fr.polytech.exam.entity.TagEntity;
import fr.polytech.exam.exception.InvalidValueException;
import fr.polytech.exam.exception.ResourceNotFoundException;
import fr.polytech.exam.repository.RestaurantRepository;
import fr.polytech.exam.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final TagRepository tagRepository;

    public List<RestaurantEntity> getRestaurants() {
        return this.restaurantRepository.findAll();
    }

    public RestaurantEntity getRestaurantById(final Integer id) {
        return this.restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Le restaurant d'id " + id + " est introuvable."));
    }

    public RestaurantEntity addRestaurant(final AddRestaurantDto restaurantDto) {
        final RestaurantEntity restaurantToAdd = RestaurantEntity.builder().nom(restaurantDto.getNom()).adresse(restaurantDto.getAdresse()).build();
        this.restaurantRepository.save(restaurantToAdd);

        for (int i = 0; i < restaurantDto.getTags().stream().count(); i++) {
            String tag = restaurantDto.getTags().get(i);
            this.tagRepository.save(TagEntity.builder().tag(tag).restaurant(restaurantToAdd).build());
        }

        return restaurantToAdd;
    }

    public RestaurantEntity updateRestaurant(final int id, final String nouveauNom, final String nouvelleAdresse) {
        if( nouveauNom == null ) throw new InvalidValueException("Le nouveau nom ne doit pas être null.");
        if( nouvelleAdresse == null) throw new InvalidValueException("La nouvelle addresse ne doit pas être null.");

        final RestaurantEntity restaurantToUpdate = this.restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Le restaurant d'id " + id + " est introuvable."));

        restaurantToUpdate.setNom(nouveauNom);
        restaurantToUpdate.setAdresse(nouvelleAdresse);

        restaurantRepository.save(restaurantToUpdate);
        return restaurantToUpdate;
    }
}
