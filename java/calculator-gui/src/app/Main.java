package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel pnlMain;
    private JTextField txtResult;
    private JButton btn4;
    private JButton btn7;
    private JButton btnAdd;
    private JButton btnSubtract;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JButton btnCalculate;
    private JButton btnAddFloatingPoint;
    private JButton btnReset;
    private JButton btnClear;
    private JButton btn8;
    private JButton btn9;
    private JButton btn5;
    private JButton btn6;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn0;

    private boolean _isError;
    private boolean _isVal1Set;
    private boolean _isVal2Typed;
    private boolean _isResulted;
    private double _val1;
    private String _op;

    public Main() {
        // Setting up buttons.
        setNumberButton(btn0);
        setNumberButton(btn1);
        setNumberButton(btn2);
        setNumberButton(btn3);
        setNumberButton(btn4);
        setNumberButton(btn5);
        setNumberButton(btn6);
        setNumberButton(btn7);
        setNumberButton(btn8);
        setNumberButton(btn9);
        setNumberButton(btnAddFloatingPoint);

        setOpButton(btnAdd);
        setOpButton(btnSubtract);
        setOpButton(btnMultiply);
        setOpButton(btnDivide);

        setBtnCalculate();
        setBtnClear();
        setBtnReset();
    }

    void setNumberButton(JButton btn) {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(_isResulted || _isError) {
                    return;
                }

                if(_isVal1Set && !_isVal2Typed) {
                    clearResult();
                }

                String toAdd = btn.getText();
                String available = txtResult.getText();

                if(toAdd.equals("0") && available.equals("0")) {
                    return;
                }

                if(toAdd.equals(".") && available.contains(".")) {
                    return;
                }

                if(available.equals("0") && !toAdd.equals(".")) {
                    available = "";
                }

                txtResult.setText(available + toAdd);

                if(_isVal1Set) {
                    _isVal2Typed = true;
                }
            }
        };

        btn.addActionListener(al);
    }

    void setOpButton(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(_isError) {
                    return;
                }

                if(_isResulted) {
                    _val1 = Double.parseDouble(txtResult.getText());
                    _isVal2Typed = false;
                    _isResulted = false;
                } else {
                    _val1 = Double.parseDouble(txtResult.getText());
                }

                _isVal1Set = true;
                _op = btn.getText();
            }
        });
    }

    void reset() {
        _val1 = 0;
        _isVal1Set = false;
        _isVal2Typed = false;
        _isResulted = false;
        _isError = false;
    }

    void clearResult() {
        txtResult.setText("0");
    }

    void setBtnReset() {
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearResult();
            }
        });
    }

    void setBtnClear() {
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearResult();

                if(_isResulted || _isError) {
                    // Act as reset.
                    reset();
                }
            }
        });
    }

    void setBtnCalculate() {
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!_isVal1Set || _isResulted) {
                    return;
                }

                // Getting val 2.
                double val2 = Double.parseDouble(txtResult.getText());

                // Calculating.
                double result = 0;

                switch (_op) {
                    case "+":
                        result = _val1 + val2;
                        break;

                    case "-":
                        result = _val1 - val2;
                        break;

                    case "x":
                        result = _val1 * val2;
                        break;

                    case "/":
                        if(val2 == 0) {
                            reset();
                            txtResult.setText("Division by 0");
                            _isError = true;
                            return;
                        }

                        result = _val1 / val2;
                        break;
                }

                _isResulted = true;
                txtResult.setText(Double.toString(result));
            }
        });
    }

    // Static.
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {}

        JFrame frame = new JFrame("Kalkulator");
        frame.setContentPane(new Main().pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
