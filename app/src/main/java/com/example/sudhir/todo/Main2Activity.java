package com.example.sudhir.todo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        title = (EditText)findViewById(R.id.edit_title);
        final EditText description = (EditText) findViewById(R.id.edit_description);
        title.setText(i.getStringExtra("title"));
        description.setText(i.getStringExtra("description"));
        final String index = i.getStringExtra("index");
        Button b = (Button) findViewById(R.id.edit_submit);
        Button b1 = (Button) findViewById(R.id.edit_delete);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t_title = title.getText().toString();
                String t_descritpion = description.getText().toString();
                Intent i = new Intent();
                i.putExtra("title",t_title);
                i.putExtra("description",t_descritpion);
                i.putExtra("index",index);
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("index",index);
                setResult(Activity.RESULT_CANCELED,i);
                finish();
            }
        });
    }
}
