package com.example.lanco.hw2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DescriptionActivity extends AppCompatActivity {

    TextView actText, desText;
    int posi;
    Intent myLocalIntent;
    @Override
    // onCreate function : when called by main function, it sets description screen's text using whatAct in intent.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        actText = (TextView)findViewById(R.id.actText);
        desText = (TextView)findViewById(R.id.desText);

        // get whatAct value in intent to seperate activity
        myLocalIntent = getIntent();
        Bundle myBundle = myLocalIntent.getExtras();
        posi = myBundle.getInt("whatAct");
        String desAct, desCon;
        if(posi==0) {
            desAct="Time Table";
            desCon="Simple junior-university Scheduler \n- Made by Jang Young June";
        }
        else if(posi==1){
            desAct="Tip Calculator";
            desCon="SimplTip Calculator \n- Made by Jang Young June";
        }
        else{
            desAct="Calculator";
            desCon="Simple Calculator.\n If you input '=', you can see Toast result \n- Made by Jang Young June";
        }
        actText.setText(desAct);
        desText.setText(desCon);
    }
    // onActBtn function : through button event, it links(calls) a relevant activity using intents
    public void onActBtn(View v){
        if(posi==0){
            Intent intent = new Intent(getApplicationContext(),TimeActivity.class);
            startActivity(intent);
            finish();
        }
        else if(posi==1){
            Intent intent = new Intent(getApplicationContext(),TipActivity.class);
            startActivity(intent);
            finish();
        }
        // In case of calculator, it delivers calActivity's result to MainActivity-onResultActivity function's value. So, it needs requestCode(102) to get calActivity's result
        else if (posi == 2) {
            Intent intent = new Intent(getApplicationContext(), CalActivity.class);
            startActivityForResult(intent,102);
        }
    }

    // onActivityResult function : get requestCode 102 and CalActivity's result, and repackage and send it to MainActivity through setResult.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 102 && resultCode == Activity.RESULT_OK) {
                Intent reIntent = getIntent();

                Bundle calResult = data.getExtras();
                reIntent.putExtras(calResult);

                setResult(Activity.RESULT_OK,reIntent);
                finish();
            }
            else{
                finish();
            }
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Problems - 102 Code", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
