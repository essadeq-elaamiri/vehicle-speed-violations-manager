package me.elaamiri.queries.radarQueries;

import lombok.Getter;

public class GetRadarByIdQuery {
    @Getter
    private String radarId;

    public GetRadarByIdQuery(String radarId) {
        this.radarId = radarId;
    }
}
