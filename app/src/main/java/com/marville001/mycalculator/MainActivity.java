package com.marville001.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;


public class MainActivity extends AppCompatActivity {

    //Variables
    EditText et_result;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_result =  findViewById(R.id.et_result);

        et_result.setShowSoftInputOnFocus(false);
        et_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(et_result.getText().toString())){
                    et_result.setText("");
                }
            }
        });

    }

    private void updateText(String strToAdd){
        String oldStr = et_result.getText().toString().trim();
        int cursorPos = et_result.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if (getString(R.string.display).equals(et_result.getText().toString())){
            et_result.setText(strToAdd);
            et_result.setSelection(cursorPos + 1);
        }else {
            et_result.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            et_result.setSelection(cursorPos + 1);
        }
    }

    public void clear(View v) {
        et_result.setText("");
    }

    public void times(View v) {
        updateText("x");
    }

    public void divide(View v) {
        updateText("/");
    }

    public void delete(View v) {
        int cursorPos = et_result.getSelectionStart();
        int textLen = et_result.getText().length();
        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) et_result.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            et_result.setText(selection);
            et_result.setSelection(cursorPos - 1);
        }
    }

    public void seven(View v) {
        updateText("7");
    }

    public void eight(View v) {
        updateText("8");
    }

    public void nine(View v) {
        updateText("9");
    }

    public void plus(View v) {
        updateText("+");
    }

    public void four(View v) {
        updateText("4");
    }

    public void five(View v) {
        updateText("5");
    }

    public void six(View v) {
        updateText("6");
    }

    public void minus(View v) {
        updateText("-");
    }

    public void one(View v) {
        updateText("1");
    }

    public void two(View v) {
        updateText("2");
    }

    public void three(View v) {
        updateText("3");
    }

    public void modulus(View v) {
        updateText("%");
    }

    public void zero(View v) {
        updateText("0");
    }

    public void dot(View v) {
        updateText(".");
    }

    public void equals(View v) {
        String userExp = et_result.getText().toString();

        userExp = userExp.replaceAll("x", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        et_result.setText(result);
        et_result.setSelection(result.length());
    }
}