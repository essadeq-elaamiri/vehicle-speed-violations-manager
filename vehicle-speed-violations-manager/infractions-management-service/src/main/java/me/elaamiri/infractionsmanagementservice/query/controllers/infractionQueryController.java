package me.elaamiri.infractionsmanagementservice.query.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elaamiri.infractionsmanagementservice.query.entities.Infraction;
import me.elaamiri.queries.infractionQueries.GetAllInfractionsQuery;
import me.elaamiri.queries.infractionQueries.GetInfractionByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/query/infractions")
public class infractionQueryController {
    private QueryGateway queryGateway;

    @GetMapping("")
    public List<Infraction> getAllInfractions(){
        return queryGateway.query(new GetAllInfractionsQuery(), ResponseTypes.multipleInstancesOf(Infraction.class)).join();
    }


    @GetMapping("/{id}")
    public Infraction getInfractionById(@PathVariable String id){
        return queryGateway.query(new GetInfractionByIdQuery(id), ResponseTypes.instanceOf(Infraction.class)).join();
    }

}
