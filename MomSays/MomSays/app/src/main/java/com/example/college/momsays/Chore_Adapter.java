package com.example.college.momsays;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Admin on 09/04/2018.
 */

public class Chore_Adapter extends ArrayAdapter<String> {

    public Chore_Adapter(@NonNull Context context, String[] chore_item) {
        super(context, R.layout.chore_row, chore_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckyInflater.inflate(R.layout.custom_row, parent,false )
    }
}
