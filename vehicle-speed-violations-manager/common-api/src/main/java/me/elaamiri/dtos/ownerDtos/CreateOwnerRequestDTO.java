package me.elaamiri.dtos.ownerDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateOwnerRequestDTO {

    private String name;

    private Date birthDate;

    private String email;
}
