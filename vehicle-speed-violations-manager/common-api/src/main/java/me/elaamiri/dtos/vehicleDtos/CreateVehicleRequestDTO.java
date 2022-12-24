package me.elaamiri.dtos.vehicleDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateVehicleRequestDTO {
    private String mum_matricule;

    private String marque;

    private int model;

    private float puissance_fiscal;
}
