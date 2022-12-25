package me.elaamiri.infractionsmanagementservice.query.services;


import lombok.AllArgsConstructor;
import me.elaamiri.exceptions.InfractionNotFoundException;
import me.elaamiri.exceptions.RadarNotFoundException;
import me.elaamiri.exceptions.VehicleNotFoundException;
import me.elaamiri.infractionsmanagementservice.openFeign.ImmatriculationRestClientService;
import me.elaamiri.infractionsmanagementservice.openFeign.RadarRestClientService;
import me.elaamiri.infractionsmanagementservice.query.dtos.FullInfractionResponseDTO;
import me.elaamiri.infractionsmanagementservice.query.entities.Infraction;
import me.elaamiri.infractionsmanagementservice.query.entities.models.Radar;
import me.elaamiri.infractionsmanagementservice.query.entities.models.Vehicle;
import me.elaamiri.infractionsmanagementservice.query.reposetories.InfractionRepository;
import me.elaamiri.queries.infractionQueries.GetAllInfractionsQuery;
import me.elaamiri.queries.infractionQueries.GetInfractionByIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InfractionQueryHandlerService {
    private InfractionRepository infractionRepository;
    private RadarRestClientService radarRestClientService;
    private ImmatriculationRestClientService immatriculationRestClientService;
    @QueryHandler
    public List<Infraction> handle(GetAllInfractionsQuery query){
        // Find the Radar

        // Find the Vehicle

        // Create infraction response

//        List<Infraction> infractions = infractionRepository.findAll();
//        List<FullInfractionResponseDTO> infractionResponseDTOList = new ArrayList<>();
//        FullInfractionResponseDTO fullInfractionResponseDTO ;
//        infractions.forEach((infraction) ->{
//            fullInfractionResponseDTO
//        } );

        return infractionRepository.findAll();
    }

    @QueryHandler
    public FullInfractionResponseDTO handle(GetInfractionByIdQuery query){

        Infraction infraction = infractionRepository.findById(query.getId()).orElseThrow(()-> new InfractionNotFoundException(""));

        // Find the Radar
        Radar radar = radarRestClientService.getRadarById(infraction.getRadarId());
        if(radar == null) throw new RadarNotFoundException("");

        // Find the Vehicle
        Vehicle vehicle = immatriculationRestClientService.getVehicleById(infraction.getVehiculeId());
        if(vehicle == null) throw new VehicleNotFoundException("");

        // Create infraction response

        FullInfractionResponseDTO fullInfractionResponseDTO = FullInfractionResponseDTO.builder()
                .id(infraction.getId())
                .date(infraction.getDate())
                .montant(infraction.getMontant())
                .radarId(infraction.getRadarId())
                .radar(radar)
                .vehiculeId(infraction.getVehiculeId())
                .vehicle(vehicle)
                .viresse(infraction.getViresse())
                .build();

        //return infractionRepository.findById(query.getId()).orElseThrow(()-> new InfractionNotFoundException(""));
        return fullInfractionResponseDTO;
    }
}
