package com.example.studentlist.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.studentlist.R;

public class StudentDetailsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("StudentDetailsActivity","got here");
        setContentView(R.layout.student_details);
    }
}
