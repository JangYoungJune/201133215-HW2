package com.example.lanco.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TipActivity extends AppCompatActivity {

    RadioGroup btnGroup;
    RadioButton btn15, btn20, btnOther;
    EditText textAmount, textPercent;
    Button btnResult;
    boolean checked; // Boolean type : Return value that radio button is clicked
    double cal_percent; // double type : to save value about each radio button's fixed value
    double input; // double type : to save and calculate Amount value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        btnGroup=(RadioGroup)findViewById(R.id.percentGroup);
        btn15=(RadioButton)findViewById(R.id.btn15);
        btn20=(RadioButton)findViewById(R.id.btn20);
        btnOther=(RadioButton)findViewById(R.id.btnOther);
        textAmount=(EditText)findViewById(R.id.amount);
        textPercent=(EditText)findViewById(R.id.percent);
        btnResult=(Button)findViewById(R.id.btnReslut);

        textPercent.setVisibility(View.INVISIBLE);

    }

    // onRestoreInstanceState : To restore button ID and set cal_percent
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        // using savedInstanceState's value, set button's check and cal_percent
        if(R.id.btn15==savedInstanceState.getInt("check")) {
            btn15.setChecked(true);
            cal_percent = 0.15;
        }
        else if(R.id.btn20==savedInstanceState.getInt("check")) {
            btn20.setChecked(true);
            cal_percent = 0.20;
        }
        else if(R.id.btnOther==savedInstanceState.getInt("check")) {
            cal_percent = 0.0;
            textPercent.setVisibility(View.VISIBLE);
        }
    }

    // onSaveInstanceState : To store value of getCheckedRadioButtonId()
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("check", btnGroup.getCheckedRadioButtonId()); // save Radio button ID
    }



    // onRadioClicked : Identify the check, and get cal_percent and visibility
    public void onRadioClicked(View view)
    {
        checked=((RadioButton)view).isChecked();

        switch(view.getId())
        {
            case R.id.btn15:
                if(checked) {
                    cal_percent = 0.15;
                    textPercent.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.btn20:
                if(checked) {
                    cal_percent = 0.20;
                    textPercent.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.btnOther:
                if(checked)
                {
                    cal_percent = 0.0;
                    textPercent.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
    // result_click : if pushed result value, calculate the value(textAmount's value * cal_percent)
    //                and show the result using toast
    public void result_click(View view)
    {
        double tip;
        double tipAmount;
        // check the amount is no input - exception : alert no input
        if(textAmount.getText().toString().equals(null) || textAmount.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Input Amount", Toast.LENGTH_SHORT).show();
        }
        // the amount value is exist
        else {
            input = Double.parseDouble(textAmount.getText().toString());
            // textPercent editText is invisible(15%, 20%) - calculate value and show
            if (textPercent.getVisibility() == View.INVISIBLE) {
                tip = input * cal_percent;
                tipAmount = input + tip;
                String tip_msg = String.format("%.2f", tip);
                String tipa_msg = String.format("%.2f", tipAmount);
                String msg = "Tip : " + tip_msg + " Total : " + tipa_msg;
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
            // textPercent editText is visible - get cal_percent through editText(textPercent) and calculate value
            else {
                String tempP = textPercent.getText().toString();
                // if edittext is no input - exception : alert no input
                if (tempP.equals("") || tempP.equals(null)) {
                    Toast.makeText(getApplicationContext(), "Input Percent", Toast.LENGTH_SHORT).show();
                }
                // if edittext is exist - calculate value and show
                else {
                    cal_percent = Double.parseDouble(tempP) / 100;
                    tip = input * cal_percent;
                    tipAmount = input + tip;
                    String tip_msg = String.format("%.2f", tip);
                    String tipa_msg = String.format("%.2f", tipAmount);
                    String msg = "Tip : " + tip_msg + " Total : " + tipa_msg;
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
