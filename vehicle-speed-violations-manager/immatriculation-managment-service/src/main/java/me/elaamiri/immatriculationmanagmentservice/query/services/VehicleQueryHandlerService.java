package me.elaamiri.immatriculationmanagmentservice.query.services;

import lombok.AllArgsConstructor;
import me.elaamiri.exceptions.OwnerNotFoundException;
import me.elaamiri.immatriculationmanagmentservice.query.entities.Owner;
import me.elaamiri.immatriculationmanagmentservice.query.entities.Vehicle;
import me.elaamiri.immatriculationmanagmentservice.query.repositories.OwnerRepository;
import me.elaamiri.immatriculationmanagmentservice.query.repositories.VehicleRepository;
import me.elaamiri.queries.ownerQueries.GetAllOwnersQuery;
import me.elaamiri.queries.ownerQueries.GetOwnerByIdQuery;
import me.elaamiri.queries.vehicleQueries.GetAllVehiclesQuery;
import me.elaamiri.queries.vehicleQueries.GetVehicleByIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleQueryHandlerService {
    private VehicleRepository vehicleRepository;

    @QueryHandler
    public List<Vehicle> handle(GetAllVehiclesQuery query){
        return vehicleRepository.findAll();
    }

    @QueryHandler
    public Vehicle handle(GetVehicleByIdQuery query){
        return vehicleRepository.findById(query.getId()).orElseThrow(()-> new OwnerNotFoundException(""));
    }
}
