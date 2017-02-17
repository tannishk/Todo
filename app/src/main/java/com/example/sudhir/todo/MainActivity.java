package com.example.sudhir.todo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ArrayList<toDo> tos;
    ArrayList<toDo> li;
    //ArrayAdapter<String> adapter;
    doAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li = new ArrayList<toDo>();
        li.add(new toDo(" Create","A New Post"));
       // li.add(new toDo("2","Fill asfg"));
        ListView l = (ListView) findViewById(R.id.list);
        adapter = new doAdapter(this,R.layout.list,li);
        l.setAdapter(adapter);
       l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              // if()
               Intent i1 = new Intent();
               i1.setClass(MainActivity.this,Main2Activity.class);
               i1.putExtra("index",i+"");
               i1.putExtra("title",li.get(i).title);
               i1.putExtra("description",li.get(i).description);
               startActivityForResult(i1,2);
           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                toDo a = new toDo(data.getStringExtra("title"),data.getStringExtra("description"));
                li.add(a);
                adapter.notifyDataSetChanged();
            }
        }
        if(requestCode==2)
        {
            if(resultCode==Activity.RESULT_OK)
            {
                toDo a = li.get(Integer.parseInt(data.getStringExtra("index")));
                a.title = data.getStringExtra("title");
                a.description = data.getStringExtra("description");
                adapter.notifyDataSetChanged();
            }
            else if(resultCode==Activity.RESULT_CANCELED)
            {
                li.remove(Integer.parseInt(data.getStringExtra("index")));
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void create(View v)
    {
        Intent i1 = new Intent();
        i1.setClass(MainActivity.this,create.class);
        startActivityForResult(i1,1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater me = getMenuInflater();
        me.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.ew)
        {
            li.add(new toDo("Hello","123"));
            adapter.notifyDataSetChanged();
        }
        else if(id==R.id.del)
        {
            li.remove(li.size()-1);
            adapter.notifyDataSetChanged();
        }
        return true;
    }
}
