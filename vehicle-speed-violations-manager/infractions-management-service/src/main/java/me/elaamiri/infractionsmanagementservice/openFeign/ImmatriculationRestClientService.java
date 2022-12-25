package me.elaamiri.infractionsmanagementservice.openFeign;

import me.elaamiri.infractionsmanagementservice.query.entities.models.Owner;
import me.elaamiri.infractionsmanagementservice.query.entities.models.Radar;
import me.elaamiri.infractionsmanagementservice.query.entities.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "IMMATRICULATION-MANAGEMENT-SERVICE")
public interface ImmatriculationRestClientService {
    @GetMapping("/query/owners")
    List<Owner> getAllOwners();

    @GetMapping("/query/owners/{id}")
    Owner getOwnerById(@PathVariable String id);

    @GetMapping("/query/vehicles")
    List<Vehicle> getAllVehicles();

    @GetMapping("/query/vehicles/{id}")
    Vehicle getVehicleById(@PathVariable String id);
}
