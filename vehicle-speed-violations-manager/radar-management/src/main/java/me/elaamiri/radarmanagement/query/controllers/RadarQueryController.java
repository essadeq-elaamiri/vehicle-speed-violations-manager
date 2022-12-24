package me.elaamiri.radarmanagement.query.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.elaamiri.queries.radarQueries.GetAllRadarsQuery;
import me.elaamiri.queries.radarQueries.GetRadarByIdQuery;
import me.elaamiri.radarmanagement.query.entities.Radar;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor @NoArgsConstructor
@RequestMapping("/query/radars")
public class RadarQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("")
    public List<Radar> getAllRadars(){
        List<Radar> radars = queryGateway.query(new GetAllRadarsQuery(), ResponseTypes.multipleInstancesOf(Radar.class)).join();
        return  radars;
    }

    @GetMapping("/{radar_id}")
    public Radar getRadarById(@PathVariable String radar_id){
        Radar radar = queryGateway.query(new GetRadarByIdQuery(radar_id), ResponseTypes.instanceOf(Radar.class)).join();
        return  radar;
    }

    //@ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );

        return responseEntity;
    }
}
