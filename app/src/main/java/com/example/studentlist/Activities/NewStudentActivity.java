package com.example.studentlist.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.studentlist.R;
import com.example.studentlist.model.DataModel;
import com.example.studentlist.model.Student;

public class NewStudentActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("NewStudentActivity","got here");
        setContentView(R.layout.new_student);
        Button cancelBtn = findViewById(R.id.CancelBtn);
        Button saveBtn = findViewById(R.id.SaveBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nameRef = findViewById(R.id.editTextTextPersonName);
                EditText idRef = findViewById(R.id.editTextTextPersonId);
                EditText addressRef = findViewById(R.id.editTextTextPersonAddress);
                EditText phoneRef = findViewById(R.id.editTextTextPersonPhone);
                CheckBox cbRef = findViewById(R.id.checkBox);

                String name = nameRef.getText().toString();
                String id = idRef.getText().toString();
                String address = addressRef.getText().toString();
                String phone = phoneRef.getText().toString();
                Boolean cb = cbRef.isChecked();

                DataModel.instance().addStudent(new Student(name,id,"",cb,phone,address));
                finish();
            }
        });
    }
}
