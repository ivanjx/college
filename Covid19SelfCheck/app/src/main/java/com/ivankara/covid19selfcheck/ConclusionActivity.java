package com.ivankara.covid19selfcheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ivankara.covid19selfcheck.databinding.ActivityConclusionBinding;
import com.ivankara.covid19selfcheck.logic.VMLocator;

public class ConclusionActivity extends AppCompatActivity {
    private ActivityConclusionBinding _binding;

    private void reset() {
        VMLocator.mainVM.setResetRequestedListener(null);
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_conclusion);
        _binding.setVM(VMLocator.mainVM);

        // Listener.
        VMLocator.mainVM.setResetRequestedListener(() -> reset());
    }
}