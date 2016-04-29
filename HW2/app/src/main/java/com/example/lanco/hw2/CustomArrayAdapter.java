package com.example.lanco.hw2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    public CustomArrayAdapter(Context context,String[] values) {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }
    // set custom Array Adapter list
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout,parent,false);
        TextView textView = (TextView)rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.icon);
        textView.setText(values[position]);

        // set each list's image
        String s = values[position];
        if(s.startsWith("Time-Table"))
            imageView.setImageResource(R.drawable.calendar);
        else if(s.startsWith("Tip"))
            imageView.setImageResource(R.drawable.tip);
        else if(s.startsWith("Calculator"))
            imageView.setImageResource(R.drawable.calculator);
        else
            imageView.setImageResource(R.drawable.change);

        return rowView;
    }
}
