package com.castor.base.event;

import org.greenrobot.eventbus.EventBus;
import org.springframework.stereotype.Component;


public class CastorEventBus {

    private static EventBus eventBus = new EventBus();

    public static EventBus getEventBus() {
        return eventBus;
    }
}
