package me.elaamiri.radarmanagement.query.services;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elaamiri.exceptions.RadarNotFoundException;
import me.elaamiri.queries.radarQueries.GetAllRadarsQuery;
import me.elaamiri.queries.radarQueries.GetRadarByIdQuery;
import me.elaamiri.radarmanagement.query.entities.Radar;
import me.elaamiri.radarmanagement.query.repositories.RadarRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class RadarQueryHandlerService {
    @Autowired
    private RadarRepository radarRepository;

    @QueryHandler
    public List<Radar> handle(GetAllRadarsQuery query){
        return radarRepository.findAll();
    }

    @QueryHandler
    public Radar handle(GetRadarByIdQuery query){
        return radarRepository.findById(query.getRadarId()).orElseThrow(()-> new RadarNotFoundException(String.format("Radar with ID [%s] not found.", query.getRadarId())));
    }
}
