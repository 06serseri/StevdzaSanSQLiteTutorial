package com.s3cilabs.stevdzasansqlitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    private static final String TAG = "AddActivity";
    EditText editTextTitle, editTextAuthor, editTextPages;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initViews();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDatabaseHelper bookDB = new BookDatabaseHelper(AddActivity.this);
                bookDB.addBook(editTextTitle.getText().toString().trim(),
                        editTextAuthor.getText().toString().trim(),
                        Integer.valueOf(editTextPages.getText().toString().trim()));
            }
        });

    }

    private void initViews() {
        Log.d(TAG, "initViews: started");
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextAuthor = findViewById(R.id.editTextAuthor);
        editTextPages = findViewById(R.id.editTextPages);
        buttonAdd = findViewById(R.id.buttonAdd);
    }
}