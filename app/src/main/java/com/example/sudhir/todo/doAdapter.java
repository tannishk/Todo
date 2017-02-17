package com.example.sudhir.todo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sudhir on 12/02/17.
 */

public class doAdapter extends ArrayAdapter<toDo> {
    ArrayList<toDo> n;
    Context con;
    public doAdapter(Context context, int resource, ArrayList<toDo> objects) {
        super(context, 0, objects);
        con = context;
        n=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView = View.inflate(con,R.layout.list,null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50,50);
        TextView t = (TextView) convertView.findViewById(R.id.title);
        //t.setLayoutParams(params);
        t.setTextSize(TypedValue.COMPLEX_UNIT_SP,21);

        TextView t1 = (TextView) convertView.findViewById(R.id.description);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        imageView.setLayoutParams(params);
        imageView.setBackgroundResource(R.drawable.list123);
        t.setText(n.get(position).title);
        t1.setText(n.get(position).description);
        return convertView;
    }
}
