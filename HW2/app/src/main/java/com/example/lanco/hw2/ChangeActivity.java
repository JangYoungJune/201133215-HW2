package com.example.lanco.hw2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bc;// each number buttons
    EditText pass1,pass2,pass3,pass4;// each password inputText boxes
    String p; // String to compare password
    SharedPreferences sh_Pref; // SharedPreference to indentify and process(compare) password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);

        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b5 = (Button) findViewById(R.id.btn5);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);
        b0 = (Button) findViewById(R.id.btn0);
        bc = (Button) findViewById(R.id.btnC);
        pass1 = (EditText) findViewById(R.id.passEdit1);
        pass2 = (EditText) findViewById(R.id.passEdit2);
        pass3 = (EditText) findViewById(R.id.passEdit3);
        pass4 = (EditText) findViewById(R.id.passEdit4);
        p = "";
    }

    // onClick function : handle button event
    public void onClick(View v) {
        // input number 0~9
        if (v.getId() == b1.getId()){
            keyChange("1");
            p = p + "1";
        }
        if (v.getId() == b2.getId()) {
            keyChange("2");
            p = p + "2";
        }
        if (v.getId() == b3.getId()) {
            keyChange("3");
            p = p + "3";
        }
        if (v.getId() == b4.getId()) {
            keyChange("4");
            p = p + "4";
        }
        if (v.getId() == b5.getId()) {
            keyChange("5");
            p = p + "5";
        }
        if (v.getId() == b6.getId()) {
            keyChange("6");
            p = p + "6";
        }
        if (v.getId() == b7.getId()) {
            keyChange("7");
            p = p + "7";
        }
        if (v.getId() == b8.getId()) {
            keyChange("8");
            p = p + "8";
        }
        if (v.getId() == b9.getId()) {
            keyChange("9");
            p = p + "9";
        }
        if (v.getId() == b0.getId()) {
            keyChange("0");
            p = p + "0";
        }
        // button C : clear last previous input content, not all.
        if (v.getId() == bc.getId()) {
            if (!p.equals("")) {
                if(p.length()==1){
                    pass1.setText("");
                }
                else if(p.length()==2){
                    pass2.setText("");
                }
                else if(p.length()==3){
                    pass3.setText("");
                }
                p = p.substring(0, p.length() - 1);
            }
        }

        // if all password input boxes is fulled - it changes sharedPreference value to new password value p using sharedPreferences.Editor
        if (pass4.length() == 1) {
            SharedPreferences.Editor editor = sh_Pref.edit();
            editor.putString("Pass",p);
            editor.commit(); // save new password p
            Toast.makeText(getApplicationContext(),"Change complete!",Toast.LENGTH_SHORT).show(); // show toast to announce change success.
            finish();
        }

    }

    // keyChange function : it input value from number button to editText.
    public void keyChange(String input){
        if(p.length()==0){
            pass1.setText(input);
        }
        else if(p.length()==1){
            pass2.setText(input);
        }
        else if(p.length()==2){
            pass3.setText(input);
        }
        else if(p.length()==3){
            pass4.setText(input);
        }
    }
}

