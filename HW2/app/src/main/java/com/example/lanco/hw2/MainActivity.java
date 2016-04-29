package com.example.lanco.hw2;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

// Using listActivity
public class MainActivity extends ListActivity {

    String[] menu;

    @Override
    // OnCreate function : get StringArray, make lists using CustomArrayAdapter and set ArrayAdapter
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        menu = getResources().getStringArray(R.array.menu);
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, menu);
        setListAdapter(adapter);
    }

    // onListItemClick function : handle each list - call DescriptionActivity that be relevant lists
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        // Exception by list position 3(change password), call DescriptionActivity that be relevant position's list using intent
        if (position != 3) {
            Intent intent = new Intent(getApplicationContext(), DescriptionActivity.class);
            intent.putExtra("whatAct", position);
            switch (position) {
                case 0:
                    startActivity(intent);
                    break;
                case 1:
                    startActivity(intent);
                    break;
                // in case of calculator, it need result from calActivity to show Toast message. So, it needs startActivityForResult function to get result from requestCode(101)
                case 2:
                    startActivityForResult(intent, 101);
                    break;
            }
        }
        // in case of change password, call ChangeActivity using intent
        else {
            Intent intent = new Intent(getApplicationContext(), ChangeActivity.class);
            startActivity(intent);
        }
    }

    // onActivityResult function : it gets calculator result from requestCode(101) and show result value using Toast Message.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
                Bundle calResult = data.getExtras();
                Double calDouble = calResult.getDouble("calTemp");
                Toast.makeText(getApplicationContext(), calDouble + "", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Problems - 101 Code", Toast.LENGTH_SHORT).show();
        }
    }
}

