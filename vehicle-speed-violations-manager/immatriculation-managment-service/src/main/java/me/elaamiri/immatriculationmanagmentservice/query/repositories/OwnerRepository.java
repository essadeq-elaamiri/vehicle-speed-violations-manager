package me.elaamiri.immatriculationmanagmentservice.query.repositories;

import me.elaamiri.immatriculationmanagmentservice.query.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}
