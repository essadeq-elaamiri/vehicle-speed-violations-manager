package me.elaamiri.immatriculationmanagmentservice.query.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class Vehicle {

    @Id
    private String id;

    private String mum_matricule;

    private String marque;

    private int model;

    private float puissance_fiscal;

    @ManyToOne
    private Owner owner;
}
