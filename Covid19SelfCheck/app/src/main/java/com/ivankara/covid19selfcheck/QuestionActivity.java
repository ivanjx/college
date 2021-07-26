package com.ivankara.covid19selfcheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.ivankara.covid19selfcheck.databinding.ActivityMainBinding;
import com.ivankara.covid19selfcheck.databinding.ActivityQuestionBinding;
import com.ivankara.covid19selfcheck.logic.VMLocator;

public class QuestionActivity extends AppCompatActivity {
    private ActivityQuestionBinding _binding;

    private void startConclusionActivity() {
        // Clear listeners.
        VMLocator.mainVM.setConclusionMadeListener(null);

        // Start new activity.
        Intent intent = new Intent(this, ConclusionActivity.class);
        finish(); // Dont include this activity on back stack.
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_question);
        _binding.setVM(VMLocator.mainVM);

        // Listener.
        VMLocator.mainVM.setConclusionMadeListener(() -> startConclusionActivity());
    }
}