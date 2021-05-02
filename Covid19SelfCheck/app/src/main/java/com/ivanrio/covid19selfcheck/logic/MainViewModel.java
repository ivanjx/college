package com.ivanrio.covid19selfcheck.logic;

import androidx.databinding.BaseObservable;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends BaseObservable {
    private List<IEventListener> _closeRequestedListeners;

    public MainViewModel() {
        _closeRequestedListeners = new ArrayList<>();
    }

    public void addCloseRequestedListener(IEventListener listener) {
        _closeRequestedListeners.add(listener);
    }

    private void fireCloseRequestedEvent() {
        for (IEventListener listener : _closeRequestedListeners) {
            listener.handle();
        }
    }

    public void closeApp() {
        fireCloseRequestedEvent();
    }
}
