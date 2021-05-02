package com.ivanrio.covid19selfcheck.logic;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.ivanrio.covid19selfcheck.BR;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends BaseObservable {
    private EventInitiator _closeRequestedListeners;
    private EventInitiator _startedListener;
    private EventInitiator _conclusionMadeListener;

    private String _questionTitle;
    private String _conclusionTitle;
    private List<Boolean> _answers;
    private String[] _questions = { "q1", "q2", "q3", "q4", "q5" };
    private int _questionCounter = 0;

    @Bindable
    public String getQuestionTitle() {
        return _questionTitle;
    }

    public void setQuestionTitle(String title) {
        if (_questionTitle == title) {
            return;
        }

        _questionTitle = title;
        notifyPropertyChanged(BR.questionTitle);
    }

    @Bindable
    public String getConclusionTitle() {
        return _conclusionTitle;
    }

    public void setConclusionTitle(String title) {
        if (_conclusionTitle == title) {
            return;
        }

        _conclusionTitle = title;
        notifyPropertyChanged(BR.conclusionTitle);
    }

    public MainViewModel() {
        _closeRequestedListeners = new EventInitiator();
        _startedListener = new EventInitiator();
        _conclusionMadeListener = new EventInitiator();
        _answers = new ArrayList<>();
    }

    public void addCloseRequestedListener(IEventListener listener) {
        _closeRequestedListeners.addListener(listener);
    }

    public void addStartedListener(IEventListener listener) {
        _startedListener.addListener(listener);
    }

    public void addConclusionMadeListener(IEventListener listener) {
        _conclusionMadeListener.addListener(listener);
    }

    public void reset() {
        setConclusionTitle(null);
        setQuestionTitle(null);
        _answers = new ArrayList<>();
        _questionCounter = 0;
    }

    public void start() {
        setConclusionTitle(null);
        setQuestionTitle("q1");
        _startedListener.fire();
    }

    private void nextQuestion() {
        setQuestionTitle(_questions[++_questionCounter]);
    }

    private void conclude(String c) {
        setQuestionTitle(null);
        setConclusionTitle("c");
        _conclusionMadeListener.fire();
    }

    public void answer(boolean yes) {
        _answers.add(yes);

        // Checking responses.
        if (_answers.size() == 1 && _answers.get(0)) {
            conclude("con_danger");
            return;
        }

        // Nothing yet.
        nextQuestion();
    }

    public void closeApp() {
        _closeRequestedListeners.fire();
    }
}
