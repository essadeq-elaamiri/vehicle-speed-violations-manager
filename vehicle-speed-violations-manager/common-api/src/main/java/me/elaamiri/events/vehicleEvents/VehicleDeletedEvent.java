package me.elaamiri.events.vehicleEvents;

import me.elaamiri.events.BaseEvent;

public class VehicleDeletedEvent extends BaseEvent<String> {
    public VehicleDeletedEvent(String id) {
        super(id);
    }
}
