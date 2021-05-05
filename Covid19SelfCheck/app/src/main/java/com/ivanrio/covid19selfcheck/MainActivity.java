package com.ivanrio.covid19selfcheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ivanrio.covid19selfcheck.databinding.ActivityMainBinding;
import com.ivanrio.covid19selfcheck.logic.IEventListener;
import com.ivanrio.covid19selfcheck.logic.MainViewModel;
import com.ivanrio.covid19selfcheck.logic.VMLocator;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
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

        // Binding.
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        _binding.setVM(VMLocator.mainVM);

        // Reset vm.
        VMLocator.mainVM.reset();

        // Listeners.
        VMLocator.mainVM.setCloseRequestedListener(() -> finishAndRemoveTask());
        VMLocator.mainVM.setStartedListener(() -> startQuestionActivity());

        Spinner s = (Spinner) findViewById(R.id.langSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(this);

        Locale current = getResources().getConfiguration().locale;
        String ss = current.getLanguage();
        if (current.getLanguage() == "in") {
            s.setSelection(1);
        } else {
            s.setSelection(0);
        }
    }

    private void setAppLocale(String localeCode){
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.setLocale(new Locale(localeCode.toLowerCase()));
        resources.updateConfiguration(config, dm);

        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.langSpinner) {
            Locale current = getResources().getConfiguration().locale;

            if (position == 0 && current.getLanguage() != "en") {
                setAppLocale("en");
            } else if (position == 1 && current.getLanguage() != "in") {
                setAppLocale("in");
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}