package me.elaamiri.infractionsmanagementservice.query.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Infraction {

    @Id
    private String id;

    private Date date;

    private double viresse;


    private double montant;

    private String vehiculeId;


    private String radarId;
}
