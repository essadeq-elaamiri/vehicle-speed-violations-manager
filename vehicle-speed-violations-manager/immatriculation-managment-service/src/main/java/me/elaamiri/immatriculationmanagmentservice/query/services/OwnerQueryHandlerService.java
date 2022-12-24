package me.elaamiri.immatriculationmanagmentservice.query.services;

import lombok.AllArgsConstructor;
import me.elaamiri.exceptions.OwnerNotFoundException;
import me.elaamiri.immatriculationmanagmentservice.query.entities.Owner;
import me.elaamiri.immatriculationmanagmentservice.query.repositories.OwnerRepository;
import me.elaamiri.queries.ownerQueries.GetAllOwnersQuery;
import me.elaamiri.queries.ownerQueries.GetOwnerByIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerQueryHandlerService {
    private OwnerRepository ownerRepository;

    @QueryHandler
    public List<Owner> handle(GetAllOwnersQuery query){
        return ownerRepository.findAll();
    }

    @QueryHandler
    public Owner handle(GetOwnerByIdQuery query){
        return ownerRepository.findById(query.getId()).orElseThrow(()-> new OwnerNotFoundException(""));
    }
}
