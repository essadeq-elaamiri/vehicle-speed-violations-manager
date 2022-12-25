package me.elaamiri.infractionsmanagementservice.query.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elaamiri.events.infractionEvents.InfractionCreatedEvent;
import me.elaamiri.events.infractionEvents.InfractionDeletedEvent;
import me.elaamiri.events.infractionEvents.InfractionUpdatedEvent;
import me.elaamiri.exceptions.InfractionNotFoundException;
import me.elaamiri.infractionsmanagementservice.query.entities.Infraction;
import me.elaamiri.infractionsmanagementservice.query.reposetories.InfractionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class InfractionEventHandlerService {
    private InfractionRepository infractionRepository;

    @EventHandler
    public void handle(InfractionCreatedEvent event){

        Infraction infraction = Infraction.builder()
                .id(event.getId())
                .date(event.getDate())
                .montant(event.getMontant())
                .radarId(event.getRadarId())
                .vehiculeId(event.getVehiculeId())
                .build();

        infractionRepository.save(infraction);
    }

    @EventHandler
    public void handle(InfractionUpdatedEvent event){
        Infraction infraction = infractionRepository.findById(event.getId()).orElseThrow(()-> new InfractionNotFoundException(""));
        infraction.setDate(event.getDate());
        infraction.setMontant(event.getMontant());
        infraction.setViresse(event.getViresse());
        infraction.setRadarId(event.getRadarId());
        infraction.setVehiculeId(event.getVehiculeId());

        infractionRepository.save(infraction);
    }

    @EventHandler
    public void handle(InfractionDeletedEvent event){
        Infraction infraction = infractionRepository.findById(event.getId()).orElseThrow(()-> new InfractionNotFoundException(""));
        infractionRepository.deleteById(infraction.getId());
    }
}
