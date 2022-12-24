package me.elaamiri.immatriculationmanagmentservice.query.repositories;

import me.elaamiri.immatriculationmanagmentservice.query.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
