package com.s3cilabs.stevdzasansqlitetutorial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    private static final String TAG = "UpdateActivity started";
    EditText editTextTitle2, editTextAuthor2, editTextPages2;
    Button buttonUpdate;
    String id, title, author, pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initViews();
        //First we call this method
        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null){
            ab.setTitle(title);
        }

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDatabaseHelper bookDB = new BookDatabaseHelper(UpdateActivity.this);
                title = editTextTitle2.getText().toString().trim();
                author = editTextAuthor2.getText().toString().trim();
                pages = editTextPages2.getText().toString().trim();
                bookDB.updateData(id, title, author, pages);
            }
        });

    }

    void getAndSetIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("author") && getIntent().hasExtra("pages")){
            //Getting data from intent
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author= getIntent().getStringExtra("author");
            pages = getIntent().getStringExtra("pages");

            //Setting intent data
            editTextTitle2.setText(title);
            editTextAuthor2.setText(author);
            editTextPages2.setText(pages);

        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void initViews() {
        Log.d(TAG, "initViews: started");
        editTextTitle2 = findViewById(R.id.editTextTitle2);
        editTextAuthor2 = findViewById(R.id.editTextAuthor2);
        editTextPages2 = findViewById(R.id.editTextPages2);
        buttonUpdate = findViewById(R.id.buttonUpdate);
    }
}