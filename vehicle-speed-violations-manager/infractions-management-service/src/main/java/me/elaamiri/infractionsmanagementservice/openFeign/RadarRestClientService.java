package me.elaamiri.infractionsmanagementservice.openFeign;

import me.elaamiri.infractionsmanagementservice.query.entities.models.Radar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RADAR-MANAGEMENT-SERVICE")
public interface RadarRestClientService {

    @GetMapping("/query/radars")
    List<Radar> getAllRadars();

    @GetMapping("/query/radars/{id}")
    Radar getRadarById(@PathVariable String id);
}
