package fr.polytech.exam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "evaluation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "auteur", columnDefinition = "varchar(50)", nullable = false)
    private String auteur;

    @Column(name = "commentaire", columnDefinition = "varchar(255)", nullable = false)
    private String commentaire;

    @Column(name = "note", nullable = false)
    @Max(3)
    @Min(0)
    private Integer note;

    @Column(name = "creation", columnDefinition = "date", nullable = false)
    private Date creation;

    @Column(name = "modification", columnDefinition = "date", nullable = false)
    private Date modification;

    @ManyToOne()
    @JoinColumn(name = "restaurant")
    private RestaurantEntity restaurant;

}
