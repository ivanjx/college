package app;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
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
                if (_isResulted || _isError) {
                    return;
                }

                if (_isVal1Set && !_isVal2Typed) {
                    clearResult();
                }

                String toAdd = btn.getText();
                String available = txtResult.getText();

                if (toAdd.equals("0") && available.equals("0")) {
                    return;
                }

                if (toAdd.equals(".") && available.contains(".")) {
                    return;
                }

                if (available.equals("0") && !toAdd.equals(".")) {
                    available = "";
                }

                txtResult.setText(available + toAdd);

                if (_isVal1Set) {
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
                if (_isError) {
                    return;
                }

                if (_isResulted) {
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

                if (_isResulted || _isError) {
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
                if (!_isVal1Set || _isResulted) {
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
                        if (val2 == 0) {
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
        } catch (Exception ex) {
        }

        JFrame frame = new JFrame("Kalkulator");
        frame.setContentPane(new Main().pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        pnlMain = new JPanel();
        pnlMain.setLayout(new GridLayoutManager(8, 6, new Insets(10, 10, 10, 10), -1, -1));
        txtResult = new JTextField();
        txtResult.setEditable(false);
        Font txtResultFont = this.$$$getFont$$$(null, -1, 24, txtResult.getFont());
        if (txtResultFont != null) txtResult.setFont(txtResultFont);
        txtResult.setHorizontalAlignment(11);
        txtResult.setMargin(new Insets(2, 6, 2, 6));
        txtResult.setText("0");
        pnlMain.add(txtResult, new GridConstraints(0, 0, 1, 6, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(-1, 40), 0, false));
        btn4 = new JButton();
        btn4.setText("4");
        pnlMain.add(btn4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btn7 = new JButton();
        btn7.setText("7");
        pnlMain.add(btn7, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btnAdd = new JButton();
        btnAdd.setText("+");
        pnlMain.add(btnAdd, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btnSubtract = new JButton();
        btnSubtract.setText("-");
        pnlMain.add(btnSubtract, new GridConstraints(1, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btn8 = new JButton();
        btn8.setText("8");
        pnlMain.add(btn8, new GridConstraints(2, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btn5 = new JButton();
        btn5.setText("5");
        pnlMain.add(btn5, new GridConstraints(3, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btnMultiply = new JButton();
        btnMultiply.setText("x");
        pnlMain.add(btnMultiply, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btnDivide = new JButton();
        btnDivide.setText("/");
        pnlMain.add(btnDivide, new GridConstraints(1, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btn9 = new JButton();
        btn9.setText("9");
        pnlMain.add(btn9, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btn6 = new JButton();
        btn6.setText("6");
        pnlMain.add(btn6, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btnCalculate = new JButton();
        btnCalculate.setText("=");
        pnlMain.add(btnCalculate, new GridConstraints(2, 5, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btn0 = new JButton();
        btn0.setText("0");
        pnlMain.add(btn0, new GridConstraints(5, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btnAddFloatingPoint = new JButton();
        btnAddFloatingPoint.setText(".");
        pnlMain.add(btnAddFloatingPoint, new GridConstraints(5, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btnReset = new JButton();
        btnReset.setText("RESET");
        pnlMain.add(btnReset, new GridConstraints(7, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btnClear = new JButton();
        btnClear.setText("CLEAR");
        pnlMain.add(btnClear, new GridConstraints(7, 4, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        final JSeparator separator1 = new JSeparator();
        pnlMain.add(separator1, new GridConstraints(6, 0, 1, 6, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn1 = new JButton();
        btn1.setText("1");
        pnlMain.add(btn1, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btn2 = new JButton();
        btn2.setText("2");
        pnlMain.add(btn2, new GridConstraints(4, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
        btn3 = new JButton();
        btn3.setText("3");
        pnlMain.add(btn3, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 50), null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnlMain;
    }
}
