package me.elaamiri.infractionsmanagementservice.query.services;


import lombok.AllArgsConstructor;
import me.elaamiri.exceptions.InfractionNotFoundException;
import me.elaamiri.infractionsmanagementservice.query.entities.Infraction;
import me.elaamiri.infractionsmanagementservice.query.reposetories.InfractionRepository;
import me.elaamiri.queries.infractionQueries.GetAllInfractionsQuery;
import me.elaamiri.queries.infractionQueries.GetInfractionByIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InfractionQueryHandlerService {
    private InfractionRepository infractionRepository;

    @QueryHandler
    public List<Infraction> handle(GetAllInfractionsQuery query){
        return infractionRepository.findAll();
    }

    @QueryHandler
    public Infraction handle(GetInfractionByIdQuery query){
        return infractionRepository.findById(query.getId()).orElseThrow(()-> new InfractionNotFoundException(""));
    }
}
