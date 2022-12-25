package me.elaamiri.infractionsmanagementservice.query.entities.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class Vehicle {

    private String id;

    private String mum_matricule;

    private String marque;

    private int model;

    private float puissance_fiscal;


}
