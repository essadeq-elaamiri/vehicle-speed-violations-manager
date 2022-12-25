package me.elaamiri.infractionsmanagementservice.query.entities.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Radar {

    private String radarId;
    private double vitesse_max;
    private float longitude;
    private  float latitude;
}
