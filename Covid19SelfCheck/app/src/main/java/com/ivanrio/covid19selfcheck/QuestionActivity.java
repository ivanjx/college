package com.ivanrio.covid19selfcheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ivanrio.covid19selfcheck.databinding.ActivityMainBinding;
import com.ivanrio.covid19selfcheck.databinding.ActivityQuestionBinding;
import com.ivanrio.covid19selfcheck.logic.MainViewModel;
import com.ivanrio.covid19selfcheck.logic.VMLocator;

public class QuestionActivity extends AppCompatActivity {
    private ActivityQuestionBinding _binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_question);
        _binding.setVM(VMLocator.mainVM);
    }
}