package me.elaamiri.queries.infractionQueries;

import lombok.Getter;

public class GetInfractionByIdQuery {
    @Getter
    private String id;

    public GetInfractionByIdQuery(String id) {
        this.id = id;
    }
}
