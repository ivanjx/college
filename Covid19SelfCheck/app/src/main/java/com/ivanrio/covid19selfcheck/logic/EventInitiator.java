package com.ivanrio.covid19selfcheck.logic;

import java.util.ArrayList;
import java.util.List;

public class EventInitiator {
    private List<IEventListener> _listeners;

    public EventInitiator() {
        _listeners = new ArrayList<>();
    }

    public void addListener(IEventListener listener) {
        _listeners.add(listener);
    }

    public void fire() {
        for (IEventListener l : _listeners) {
            l.handle();
        }
    }
}
