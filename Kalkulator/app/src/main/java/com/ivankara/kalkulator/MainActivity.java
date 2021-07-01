package com.ivankara.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private final int[] _numberButtons = {
            R.id.btnZero,
            R.id.btnOne,
            R.id.btnTwo,
            R.id.btnThree,
            R.id.btnFour,
            R.id.btnFive,
            R.id.btnSix,
            R.id.btnSeven,
            R.id.btnEight,
            R.id.btnNine,
    };

    private final int[] _operatorButtons = {
            R.id.btnAdd,
            R.id.btnSubtract,
            R.id.btnMultiply,
            R.id.btnDivide
    };

    private TextView _txtScreen;
    private boolean _lastNumeric;
    private boolean _stateError;
    private boolean _lastDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _txtScreen = findViewById(R.id.txtScreen);
        setNumericOnClickListener();
        setOperatorOnClickListener();
    }

    private void setNumericOnClickListener() {
        View.OnClickListener listener = v -> {
            Button btn = (Button)v;

            if (_stateError) {
                _txtScreen.setText(btn.getText());
                _stateError = false;
            } else {
                _txtScreen.append(btn.getText());
            }

            _lastNumeric = true;
        };

        for (int id : _numberButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperatorOnClickListener() {
        View.OnClickListener listener = v -> {
            if (_lastNumeric && !_stateError) {
                Button btn = (Button)v;
                _txtScreen.append(btn.getText());
                _lastNumeric = false;
                _lastDot = false;
            }
        };

        for (int id : _operatorButtons) {
            findViewById(id).setOnClickListener(listener);
        }

        findViewById(R.id.btnDot).setOnClickListener(v -> {
            if (_lastNumeric && !_stateError && !_lastDot) {
                _txtScreen.append(".");
                _lastNumeric = false;
                _lastDot = true;
            }
        });

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            _txtScreen.setText("");
            _lastNumeric = false;
            _stateError = false;
            _lastDot = false;
        });

        findViewById(R.id.btnEqual).setOnClickListener(v -> onEqual());
    }

    private void onEqual() {
        if (_lastNumeric && !_stateError) {
            String txt = _txtScreen.getText().toString();
            Expression exp = new ExpressionBuilder(txt).build();

            try {
                double result = exp.evaluate();
                _txtScreen.setText(Double.toString(result));
                _lastDot = true;
            } catch (ArithmeticException ex) {
                _txtScreen.setText("Error");
                _stateError = true;
                _lastNumeric = false;
            }
        }
    }
}