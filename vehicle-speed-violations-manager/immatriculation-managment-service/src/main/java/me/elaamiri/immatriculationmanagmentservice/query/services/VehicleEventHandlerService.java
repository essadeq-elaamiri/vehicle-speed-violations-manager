package me.elaamiri.immatriculationmanagmentservice.query.services;

import lombok.AllArgsConstructor;
import me.elaamiri.events.ownerEvents.OwnerCreatedEvent;
import me.elaamiri.events.ownerEvents.OwnerDeletedEvent;
import me.elaamiri.events.ownerEvents.OwnerUpdatedEvent;
import me.elaamiri.events.vehicleEvents.VehicleCreatedEvent;
import me.elaamiri.events.vehicleEvents.VehicleUpdatedEvent;
import me.elaamiri.exceptions.OwnerNotFoundException;
import me.elaamiri.exceptions.VehicleNotFoundException;
import me.elaamiri.immatriculationmanagmentservice.query.entities.Owner;
import me.elaamiri.immatriculationmanagmentservice.query.entities.Vehicle;
import me.elaamiri.immatriculationmanagmentservice.query.repositories.OwnerRepository;
import me.elaamiri.immatriculationmanagmentservice.query.repositories.VehicleRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleEventHandlerService {
    private VehicleRepository vehicleRepository;

    @EventHandler
    public void on(VehicleCreatedEvent event){
        Vehicle vehicle = Vehicle.builder()
                .id(event.getId())
                .marque(event.getMarque())
                .model(event.getModel())
                .mum_matricule(event.getMum_matricule())
                .puissance_fiscal(event.getPuissance_fiscal())
                .build();
        vehicleRepository.save(vehicle);
    }

    @EventHandler
    public void on(VehicleUpdatedEvent event){

        Vehicle vehicle = vehicleRepository.findById(event.getId()).orElseThrow(()-> new VehicleNotFoundException(""));
        vehicle.setId(event.getId());
        vehicle.setMarque(event.getMarque());
        vehicle.setModel(event.getModel());
        vehicle.setMum_matricule(event.getMum_matricule());
        vehicle.setPuissance_fiscal(event.getPuissance_fiscal());

        vehicleRepository.save(vehicle);
    }


    @EventHandler
    public void on(OwnerDeletedEvent event){

        Vehicle vehicle = vehicleRepository.findById(event.getId()).orElseThrow(()-> new VehicleNotFoundException(""));

        vehicleRepository.delete(vehicle);
    }
}
