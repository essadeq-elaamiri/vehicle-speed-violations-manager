package me.elaamiri.radarmanagement.query.entities;

import lombok.*;
import org.axonframework.modelling.command.AggregateIdentifier;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Radar {

    @Id
    private String radarId;
    private double vitesse_max;
    private float longitude;
    private  float latitude;
}
