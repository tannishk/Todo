package com.example.sudhir.todo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class create extends AppCompatActivity {

    Button button;
    EditText title;
    EditText description;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        button = (Button) findViewById(R.id.submit);
        title = (EditText) findViewById(R.id.create_title);
        description = (EditText) findViewById(R.id.create_description);
         i = getIntent();
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String title_text = title.getText().toString();
                String description_text = description.getText().toString();
                i.putExtra("title",title_text);
                i.putExtra("description",description_text);
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });
    }
}
