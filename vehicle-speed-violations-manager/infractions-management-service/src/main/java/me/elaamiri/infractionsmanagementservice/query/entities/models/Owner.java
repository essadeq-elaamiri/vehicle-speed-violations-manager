package me.elaamiri.infractionsmanagementservice.query.entities.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor @Builder
public class Owner {
    private String ownerId;
    private String name;
    private Date birthDate;
    private String email;
}
