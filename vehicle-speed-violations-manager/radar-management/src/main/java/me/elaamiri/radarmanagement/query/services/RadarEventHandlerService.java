package me.elaamiri.radarmanagement.query.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elaamiri.events.radarEvents.RadarCreatedEvent;
import me.elaamiri.events.radarEvents.RadarDeletedEvent;
import me.elaamiri.events.radarEvents.RadarUpdatedEvent;
import me.elaamiri.exceptions.RadarNotFoundException;
import me.elaamiri.radarmanagement.query.entities.Radar;
import me.elaamiri.radarmanagement.query.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor @NoArgsConstructor
public class RadarEventHandlerService {

    @Autowired
    private  RadarRepository radarRepository;

    @EventHandler
    public void on(RadarCreatedEvent event){
        log.info("#==> RadarCreatedEvent Received");
        Radar radar = Radar.builder()
                .radarId(event.getId())
                .vitesse_max(event.getVitesse_max())
                .longitude(event.getLongitude())
                .latitude(event.getLatitude())
                .build();
        System.out.println(radar);

        Radar savedRadar = radarRepository.save(radar);
        log.info("#==> Radar saved");
    }

    @EventHandler
    public void on(RadarUpdatedEvent event){
        log.info("#==> RadarUpdatedEvent Received");
        Radar radar = radarRepository.findById(event.getId()).orElseThrow(()-> new RadarNotFoundException(String.format("Radar with ID [%s] Not Found !", event.getId())));
        radar.setVitesse_max(event.getVitesse_max());
        radar.setLongitude(event.getLongitude());
        radar.setLatitude(event.getLatitude());

        radarRepository.save(radar);
    }

    @EventHandler
    public void on(RadarDeletedEvent event){
        log.info("RadarDeletedEvent Received");
        Radar radar = radarRepository.findById(event.getId()).orElseThrow(()-> new RadarNotFoundException(String.format("Radar with ID [%s] Not Found !", event.getId())));
        radarRepository.deleteById(radar.getRadarId());
    }
}
