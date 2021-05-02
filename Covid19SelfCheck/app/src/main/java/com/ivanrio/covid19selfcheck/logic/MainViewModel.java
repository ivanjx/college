package com.ivanrio.covid19selfcheck.logic;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.ivanrio.covid19selfcheck.BR;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends BaseObservable {
    private IEventListener _closeRequestedListener;
    private IEventListener _startedListener;
    private IEventListener _conclusionMadeListener;
    private IEventListener _resetRequestedListener;

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
        _answers = new ArrayList<>();
    }

    public void setCloseRequestedListener(IEventListener listener) {
        _closeRequestedListener = listener;
    }

    public void setStartedListener(IEventListener listener) {
        _startedListener = listener;
    }

    public void setConclusionMadeListener(IEventListener listener) {
        _conclusionMadeListener = listener;
    }

    public void setResetRequestedListener(IEventListener listener) {
        _resetRequestedListener = listener;
    }

    public void reset() {
        setConclusionTitle(null);
        setQuestionTitle(null);
        _answers = new ArrayList<>();
        _questionCounter = 0;

        if (_resetRequestedListener != null) {
            _resetRequestedListener.handle();
        }
    }

    public void start() {
        setQuestionTitle("q1");

        if (_startedListener != null) {
            _startedListener.handle();
        }
    }

    private void nextQuestion() {
        setQuestionTitle(_questions[++_questionCounter]);
    }

    private void conclude(String c) {
        setConclusionTitle(c);

        if (_conclusionMadeListener != null) {
            _conclusionMadeListener.handle();
        }
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
        if (_closeRequestedListener != null) {
            _closeRequestedListener.handle();
        }
    }
}
