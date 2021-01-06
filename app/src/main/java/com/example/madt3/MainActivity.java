package com.example.madt3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public static int charArrayToInteger(char[] array){
        String arr = new String(array);
        int number = Integer.parseInt(arr);

        return number;
    }

    private TextView calculatorScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.calculatorScreen=findViewById(R.id.calculatorScreen);
        //this.calculatorScreen.setText('0');
    }
    public void onBack(View view)
    {
        String exp=this.calculatorScreen.getText().toString();
        int expLength = exp.length();
        if (!(expLength < 1)) {
            if (expLength == 1) {
                this.calculatorScreen.setText("");
            } else {
                this.calculatorScreen.setText(exp.substring(0, expLength - 1));
            }
        }
    }
    public void onCE(View view)
    {
       this.calculatorScreen.setText("0");
    }
    public void onPlusMinus(View view)
    {
        //this.calculatorScreen.setText(calculatorScreen.getText()+"7");
    }
    public void onSqrt(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"√");
    }
    public void on7(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"7");
    }
    public void on8(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"8");
    }
    public void on9(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"9");
    }
    public void onDivide(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"/");
    }
    public void onPercent(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"%");
    }
    public void on4(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"4");
    }
    public void on5(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"5");
    }
    public void on6(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"6");
    }
    public void onMultiplication(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"*");
    }
    public void onOnebyX(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+" 1/X ");
    }
    public void on1(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"1");
    }
    public void on2(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"2");
    }
    public void on3(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"3");
    }
    public void onPlus(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"+");
    }
    public void on0(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"0");
    }
    public void onDot(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+".");
    }
    public void onMinus(View view)
    {
        this.calculatorScreen.setText(calculatorScreen.getText()+"-");
    }
    public void onEqual(View view)
    {
        /*String comp=this.calculatorScreen.getText().toString();
        String temp="0";
        int sum=0;
        for(int i=0;i<comp.length();i++) {
            char ch = comp.charAt(i);
            if (Character.isDigit(ch)) {
                temp += ch;
            } else {
                sum += Integer.parseInt(temp);
                temp = "0";
            }
        }
        Toast.makeText(this, sum, Toast.LENGTH_LONG).show();
        this.calculatorScreen.setText(sum);*/

        String exp = calculatorScreen.getText().toString();
        String result;
        if (exp.equals("") || exp.equals(".") || isSpecialChar("" + exp.charAt(exp.length() - 1))) {
            return;
        }
        Expression expression = new Expression(exp);
        result = String.valueOf(expression.calculate());
        calculatorScreen.setText(result);
    }
    public void onC(View view)
    {
        this.calculatorScreen.setText("");
    }
    public boolean isSpecialChar(String str) {
        return Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]").matcher(str).find();
    }
}