package me.elaamiri.radarmanagement.query.repositories;

import me.elaamiri.radarmanagement.query.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadarRepository extends JpaRepository<Radar, String> {

}
