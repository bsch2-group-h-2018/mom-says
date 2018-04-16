package com.example.college.momsays;

import android.widget.BaseAdapter;
import android.widget.Toast;
import android.content.Context;
import java.util.*;
;import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by Admin on 16/04/2018.
 */


public class Cus_Ad extends BaseAdapter {

    Context c;
    ArrayList<Chore> chores;

    public Cus_Ad(Context c, ArrayList<Chore> chores) {
        this.c = c;
        this.chores = chores;
    }

    @Override
    public int getCount() {
        return chores.size();
    }

    @Override
    public Object getItem(int position) {
        return chores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.chore_row,parent,false);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.chore_name_3);
        TextView propTxt= (TextView) convertView.findViewById(R.id.chore_det_3);
        TextView descTxt= (TextView) convertView.findViewById(R.id.ass_to_3);

        final Chore s= (Chore) this.getItem(position);

        nameTxt.setText(s.getChoreName());
        propTxt.setText(s.getChoreDetail());
        descTxt.setText(s.getAssignedTo());

        //ONITECLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,s.getChoreName(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

}
