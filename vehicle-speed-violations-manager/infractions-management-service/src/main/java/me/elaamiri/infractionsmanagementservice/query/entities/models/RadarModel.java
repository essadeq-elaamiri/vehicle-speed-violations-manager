package me.elaamiri.infractionsmanagementservice.query.entities.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RadarModel {

    private String radarId;
    private double vitesse_max;
    private float longitude;
    private  float latitude;
}
