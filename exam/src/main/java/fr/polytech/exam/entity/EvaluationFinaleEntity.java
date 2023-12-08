package fr.polytech.exam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "evaluationsfinales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationFinaleEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "auteur", columnDefinition = "varchar(50)", nullable = false)
    private String auteur;

    @Column(name = "descriptif", columnDefinition = "TEXT", nullable = false)
    private String descriptif;

    @Column(name = "note", nullable = false)
    @Max(3)
    @Min(0)
    private Integer note;

    @OneToOne()
    @JoinColumn(name = "restaurant")
    private RestaurantEntity restaurant;

}
