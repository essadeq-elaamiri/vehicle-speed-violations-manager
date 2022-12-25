package me.elaamiri.infractionsmanagementservice.query.reposetories;

import me.elaamiri.infractionsmanagementservice.query.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction, String> {
}
