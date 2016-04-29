package com.example.lanco.hw2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalActivity extends AppCompatActivity implements View.OnClickListener {

    Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, cancel, sub, plus, div, mul, equal;
    TextView show;
    String text, op, pre;
    double temp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // to maintain display - vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_cal);

        text = "0"; // String type : to show screen text
        temp1 = 0; // Double type : to save previous number
        op = ""; // String type : to save mathematical sign
        pre=""; // String type : to save previous input value

        num1 = (Button) findViewById(R.id.button1);
        num2 = (Button) findViewById(R.id.btn2);
        num3 = (Button) findViewById(R.id.btn3);
        num4 = (Button) findViewById(R.id.btn4);
        num5 = (Button) findViewById(R.id.btn5);
        num6 = (Button) findViewById(R.id.btn6);
        num7 = (Button) findViewById(R.id.btn7);
        num8 = (Button) findViewById(R.id.btn8);
        num9 = (Button) findViewById(R.id.btn9);
        num0 = (Button) findViewById(R.id.button0);
        equal = (Button) findViewById(R.id.buttonEqual);
        cancel = (Button) findViewById(R.id.buttonC);
        plus = (Button) findViewById(R.id.buttonPlus);
        sub = (Button) findViewById(R.id.buttonSub);
        div = (Button) findViewById(R.id.buttonDiv);
        mul = (Button) findViewById(R.id.buttonMulti);
        show = (TextView) findViewById(R.id.showNum);

        show.setText(text);

        // set setOnClickListener
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        num0.setOnClickListener(this);
        cancel.setOnClickListener(this);
        equal.setOnClickListener(this);
        plus.setOnClickListener(this);
        sub.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
    }

    @Override
    // onClick : proceed button event
    public void onClick(View v) {
        // push cancel button - initial all values
        if (v.getId() == cancel.getId()) {
            text = "0";
            temp1 = 0;
            op = "";
            pre="";
            show.setText(text);
        }
        // push mathematical sign (+,-,*,/,=) - call op_control function
        if (v.getId() == plus.getId() || v.getId() == sub.getId() || v.getId() == mul.getId() || v.getId() == div.getId() || v.getId() == equal.getId()) {
            op_control(v);
        }
        // push button - stack 'text' and show value from display
        if (v.getId() == num1.getId()) {
            if (text.equals("0"))
                text = "";
            text = text + "1";
            pre="n";
            show.setText(text);
        }
        if (v.getId() == num2.getId()) {
            if (text.equals("0"))
                text = "";
            text = text + "2";
            pre="n";
            show.setText(text);
        }
        if (v.getId() == num3.getId()) {
            if (text.equals("0"))
                text = "";
            text = text + "3";
            pre="n";
            show.setText(text);
        }
        if (v.getId() == num4.getId()) {
            if (text.equals("0"))
                text = "";
            text = text + "4";
            pre="n";
            show.setText(text);
        }
        if (v.getId() == num5.getId()) {
            if (text.equals("0"))
                text = "";
            text = text + "5";
            pre="n";
            show.setText(text);
        }
        if (v.getId() == num6.getId()) {
            if (text.equals("0"))
                text = "";
            text = text + "6";
            pre="n";
            show.setText(text);
        }
        if (v.getId() == num7.getId()) {
            if (text.equals("0"))
                text = "";
            text = text + "7";
            pre="n";
            show.setText(text);
        }
        if (v.getId() == num8.getId()) {
            if (text.equals("0"))
                text = "";
            text = text + "8";
            pre="n";
            show.setText(text);
        }
        if (v.getId() == num9.getId()) {
            if (text.equals("0"))
                text = "";
            text = text + "9";
            pre="n";
            show.setText(text);
        }
        if (v.getId() == num0.getId()) {
            pre="n";
            if (text.equals("0"))
                show.setText(text);
            else {
                text = text + "0";
                show.setText(text);
            }
        }
    }

    // op_control : control math symbol's operation
    public void op_control(View v)
    {
        // user doesn't push any button
        if(pre.equals("")){}
        // user push any button
        else {
            // previous button is +,-,*,/,=
            if (pre.equals("+") || pre.equals("-") || pre.equals("*") || pre.equals("/") || pre.equals("=")) {
                switch(v.getId())
                {
                    case R.id.buttonPlus:
                        pre="+";
                        op=pre;
                        break;
                    case R.id.buttonSub :
                        pre="-";
                        op=pre;
                        break;
                    case R.id.buttonMulti:
                        pre="*";
                        op=pre;
                        break;
                    case R.id.buttonDiv :
                        pre="/";
                        op=pre;
                        break;
                    case R.id.buttonEqual :
                        pre="=";
                        op="";
                        break;
                }
            }
            // previous button is number
            else
            {
                // no input symbol operation
                if(op.equals(""))
                {
                    temp1=Double.parseDouble(text);
                    switch(v.getId())
                    {
                        case R.id.buttonPlus:
                            pre="+";
                            break;
                        case R.id.buttonSub :
                            pre="-";
                            break;
                        case R.id.buttonMulti:
                            pre="*";
                            break;
                        case R.id.buttonDiv :
                            pre="/";
                            break;

                    }
                    op=pre;
                }
                // inputted symbol operation
                else
                {
                    switch(op)
                    {
                        case "+":
                            temp1=temp1+Double.parseDouble(text);
                            text=String.valueOf(temp1);
                            show.setText(text);
                            break;
                        case "-":
                            temp1=temp1-Double.parseDouble(text);
                            text=String.valueOf(temp1);
                            show.setText(text);
                            break;
                        case "*":
                            temp1=temp1*Double.parseDouble(text);
                            text=String.valueOf(temp1);
                            show.setText(text);
                            break;
                        case "/":
                            temp1=temp1/Double.parseDouble(text);
                            // Exception : to handle zero division
                            if(Double.parseDouble(text) == 0)
                            {
                                show.setText("DivideBy 0");
                                temp1 = 0;
                                op = "";
                                break;
                            }
                            text=String.valueOf(temp1);
                            show.setText(text);
                            break;
                    }

                    switch(v.getId())
                    {
                        case R.id.buttonPlus:
                            pre="+";
                            op=pre;
                            break;
                        case R.id.buttonSub :
                            pre="-";
                            op=pre;
                            break;
                        case R.id.buttonMulti:
                            pre="*";
                            op=pre;
                            break;
                        case R.id.buttonDiv :
                            // Exception : to handle zero division
                            if(Double.parseDouble(text) == 0)
                            {
                                pre="";
                                break;
                            }
                            pre="/";
                            op=pre;
                            break;
                        case R.id.buttonEqual :
                            pre="=";
                            op="";
                            break;
                    }
                }
                text="0";
            }

        }

        // if user click button "=" - it send result using setResult to DescriptionActivity - it needs intent package to store result.
        if(v.getId()==R.id.buttonEqual){
            Intent calIntent = getIntent();
            Bundle tBundle = new Bundle();
            Double temp = Double.parseDouble(show.getText().toString());
            tBundle.putDouble("calTemp",temp);
            calIntent.putExtras(tBundle);

            setResult(Activity.RESULT_OK,calIntent);
            finish();
        }
    }
}
