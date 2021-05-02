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
    }

    private void startQuestionActivity() {
        // Start new activity.
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        _binding.setVM(VMLocator.mainVM);

        // Reset vm.
        VMLocator.mainVM.reset();

        // Listeners.
        VMLocator.mainVM.setCloseRequestedListener(() -> finishAndRemoveTask());
        VMLocator.mainVM.setStartedListener(() -> startQuestionActivity());
    }
}