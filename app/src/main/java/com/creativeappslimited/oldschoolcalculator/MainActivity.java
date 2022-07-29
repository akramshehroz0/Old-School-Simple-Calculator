package com.creativeappslimited.oldschoolcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView Display;
    private String ExpressionText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display = (TextView) findViewById(R.id.textView3);
    }

    public void UpdateText(String TextToAdd){
        ExpressionText = (String) Display.getText();
        ExpressionText = ExpressionText + TextToAdd;
        Display.setText(ExpressionText);
    }

    public void ClearButton(View view) {
        Display.setText("");
    }

    public void ZeroBtn(View view){
        UpdateText("0");
    }

    public void OneBtn(View view){
        UpdateText("1");
    }

    public void TwoBtn(View view){
        UpdateText("2");
    }

    public void TreeBtn(View view){
        UpdateText("3");
    }

    public void FourBtn(View view){
        UpdateText("4");
    }

    public void FiveBtn(View view){
        UpdateText("5");
    }

    public void SixBtn(View view){
        UpdateText("6");
    }
    public void SevenBtn(View view){
        UpdateText("7");
    }

    public void EightBtn(View view){
        UpdateText("8");
    }

    public void NineBtn(View view){
        UpdateText("9");
    }

    public void Multiply(View view){
        UpdateText("x");
    }

    public void Plus(View view){
        UpdateText("+");
    }

    public void Minus(View view){
        UpdateText("-");
    }

    public void Divide(View view){
        UpdateText("÷");
    }

    public void Dot(View view){
        UpdateText(".");
    }

    public void BackButton(View view){
        ExpressionText = (String) Display.getText();
        if (ExpressionText != null && ExpressionText.length() > 0) {
            ExpressionText = ExpressionText.substring(0, ExpressionText.length() - 1);
        }
        Display.setText(ExpressionText);
    }

    public void EqualButton(View view){
        ExpressionText = (String) Display.getText();

        ExpressionText = ExpressionText.replaceAll("÷" , "/");
        ExpressionText = ExpressionText.replaceAll("x" , "*");

        Expression exp = new Expression(ExpressionText);

        String Result = String.valueOf(exp.calculate());

        if(Result == "NaN"){
            Toast.makeText(this , "Invalid Expression." , Toast.LENGTH_SHORT).show();
        }
        else{
            Display.setText(Result);
        }
    }
}