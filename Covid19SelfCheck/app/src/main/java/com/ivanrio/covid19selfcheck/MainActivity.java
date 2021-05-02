package com.ivanrio.covid19selfcheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ivanrio.covid19selfcheck.databinding.ActivityMainBinding;
import com.ivanrio.covid19selfcheck.logic.IEventListener;
import com.ivanrio.covid19selfcheck.logic.MainViewModel;
import com.ivanrio.covid19selfcheck.logic.VMLocator;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding _binding;

    public MainActivity() {
        ResHelper.inject(this);
        VMLocator.mainVM.addCloseRequestedListener(() -> finishAndRemoveTask()); // As long as the interface only has one method.
        VMLocator.mainVM.addStartedListener(() -> startQuestionActivity());
        VMLocator.mainVM.addConclusionMadeListener(() -> startConclusionActivity());
    }

    private void startQuestionActivity() {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    private void startConclusionActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        _binding.setVM(VMLocator.mainVM);
    }
}