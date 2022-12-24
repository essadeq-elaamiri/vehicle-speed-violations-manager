package me.elaamiri.events.ownerEvents;

import me.elaamiri.events.BaseEvent;

public class OwnerDeletedEvent extends BaseEvent<String> {
    public OwnerDeletedEvent(String id) {
        super(id);
    }
}
