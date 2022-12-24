package me.elaamiri.events.infractionEvents;

import me.elaamiri.events.BaseEvent;

public class InfractionDeletedEvent extends BaseEvent<String> {
    public InfractionDeletedEvent(String id) {
        super(id);
    }
}
