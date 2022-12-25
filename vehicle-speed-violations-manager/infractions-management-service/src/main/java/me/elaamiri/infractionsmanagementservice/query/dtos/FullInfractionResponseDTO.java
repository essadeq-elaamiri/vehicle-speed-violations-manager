package me.elaamiri.infractionsmanagementservice.query.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.elaamiri.infractionsmanagementservice.query.entities.models.Radar;
import me.elaamiri.infractionsmanagementservice.query.entities.models.Vehicle;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class FullInfractionResponseDTO {
    private String id;
    private Date date;
    private double viresse;
    private double montant;
    private String vehiculeId;
    private String radarId;
    private Radar radar;
    private Vehicle vehicle;
}
