package com.example.studentlist.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.studentlist.R;

public class EditStudentActivity  extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_student);


        Button cancelButton = findViewById(R.id.cancelButton);
        Button deleteButton = findViewById(R.id.deleteButton);
        Button saveButton = findViewById(R.id.saveButton);

        cancelButton.setOnClickListener(view -> {
            Intent intent = new Intent(EditStudentActivity.this, StudentDetailsActivity.class);
        });
        deleteButton.setOnClickListener(view -> {
            Intent intent = new Intent(EditStudentActivity.this, StudentListActivity.class);
        });
        saveButton.setOnClickListener(view -> {
            Intent intent = new Intent(EditStudentActivity.this, StudentDetailsActivity.class);
        });
    }
}
