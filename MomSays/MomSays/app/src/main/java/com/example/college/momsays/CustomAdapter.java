package com.example.college.momsays;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 13/04/2018.
 */

class CustomAdapter extends ArrayAdapter<String>{
    public CustomAdapter(@NonNull Context context, String[] chores) {
        super(context,R.layout.chore_row, chores);
    }

        //shortcut key to the method is [alt + insert]
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater chore_inflater = LayoutInflater.from(getContext());
        View customView = chore_inflater.inflate(R.layout.chore_row, parent, false);

        //Get references of the items of the object
        String single_chore_item = getItem(position);
        TextView chore_text = (TextView) customView.findViewById(R.id.chore_text);
        ImageView send_chore_image_view = (ImageView) customView.findViewById(R.id.send_chore_image_view);

        chore_text.setText(single_chore_item);
        send_chore_image_view.setImageResource(R.drawable.send);
        return customView;
    }
}
















