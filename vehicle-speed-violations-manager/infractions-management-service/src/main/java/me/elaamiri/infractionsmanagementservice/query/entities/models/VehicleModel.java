package me.elaamiri.infractionsmanagementservice.query.entities.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class VehicleModel {

    private String id;

    private String mum_matricule;

    private String marque;

    private int model;

    private float puissance_fiscal;


}
