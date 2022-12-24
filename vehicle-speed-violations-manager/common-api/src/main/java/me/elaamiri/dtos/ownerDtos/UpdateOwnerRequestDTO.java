package me.elaamiri.dtos.ownerDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateOwnerRequestDTO {

    private String name;

    private Date birthDate;
  
    private String email;
}
