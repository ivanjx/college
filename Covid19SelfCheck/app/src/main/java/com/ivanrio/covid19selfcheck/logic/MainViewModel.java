package com.ivanrio.covid19selfcheck.logic;

import androidx.databinding.BaseObservable;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends BaseObservable {
    private EventInitiator _closeRequestedListeners;

    public MainViewModel() {
        _closeRequestedListeners = new EventInitiator();
    }

    public void addCloseRequestedListener(IEventListener listener) {
        _closeRequestedListeners.addListener(listener);
    }

    public void closeApp() {
        _closeRequestedListeners.fire();
    }
}
