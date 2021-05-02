package com.ivanrio.covid19selfcheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ivanrio.covid19selfcheck.databinding.ActivityMainBinding;
import com.ivanrio.covid19selfcheck.logic.IEventListener;
import com.ivanrio.covid19selfcheck.logic.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel _vm;
    private ActivityMainBinding _binding;

    public MainActivity() {
        ResHelper.inject(this);
        _vm = new MainViewModel();
        _vm.addCloseRequestedListener(() -> finishAndRemoveTask()); // As long as the interface only has one method.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        _binding.setVM(_vm);
    }
}