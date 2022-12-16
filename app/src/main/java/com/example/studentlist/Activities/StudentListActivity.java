package com.example.studentlist.Activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.studentlist.R;
import com.example.studentlist.StudentRecyclerAdapter;
import com.example.studentlist.model.DataModel;
import com.example.studentlist.model.Student;

import java.util.List;

public class StudentListActivity extends Activity {

    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);

        data = DataModel.instance().getAllStudents();
        RecyclerView list = findViewById(R.id.studentlistfrag_list);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter(getLayoutInflater(),data);
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Intent intent = new Intent(StudentListActivity.this, StudentDetailsActivity.class);
                Bundle b = new Bundle();
                b.putInt("id", pos); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
            }
        });

//        findViewById(R.id.addNewStudentActionButton)
    }
}