package com.example.lanco.hw2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import java.util.Calendar;

public class TimeActivity extends AppCompatActivity {

    LinearLayout MonLayout,TueLayout,WedLayout,ThuLayout,FriLayout;
    Calendar cal; // calendar type : to get day of the week information
    int day_of_week; // int type : to store today's day of the week

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        // get 'day of the week' value - use calendar
        cal = Calendar.getInstance();
        day_of_week=cal.get(Calendar.DAY_OF_WEEK);

        MonLayout=(LinearLayout)findViewById(R.id.monLayout);
        TueLayout=(LinearLayout)findViewById(R.id.tueLayout);
        WedLayout=(LinearLayout)findViewById(R.id.wedLayout);
        ThuLayout = (LinearLayout)findViewById(R.id.thuLayout);
        FriLayout=(LinearLayout)findViewById(R.id.friLayout);

        // if today is monday - highlight monday's schedule
        if(day_of_week==2)
        {
            MonLayout.setBackgroundColor(Color.CYAN);
        }
        // if today is Tuesday - highlight Tuesday's schedule
        else if(day_of_week==3)
        {
            TueLayout.setBackgroundColor(Color.CYAN);
        }
        // if today is Wednesday - highlight Wednesday's schedule
        else if(day_of_week==4)
        {
            WedLayout.setBackgroundColor(Color.CYAN);
        }
        // if today is thursday - highlight thursday's schedule
        else if(day_of_week==5)
        {
            ThuLayout.setBackgroundColor(Color.CYAN);
        }
        // if today is friday - highlight friday's schedule
        else if(day_of_week==6)
        {
            FriLayout.setBackgroundColor(Color.CYAN);
        }
    }
}
