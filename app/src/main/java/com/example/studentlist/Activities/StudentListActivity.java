package com.example.studentlist.Activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.studentlist.R;
import com.example.studentlist.StudentRecyclerAdapter;
import com.example.studentlist.model.DataModel;
import com.example.studentlist.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class StudentListActivity extends Activity {

    List<Student> data;
    StudentRecyclerAdapter adapter;
    static boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);

        data = DataModel.instance().getAllStudents();
        RecyclerView list = findViewById(R.id.studentlistfrag_list);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentRecyclerAdapter(getLayoutInflater(),data);
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Intent intent = new Intent(StudentListActivity.this, StudentDetailsActivity.class);
                Bundle b = new Bundle();
                b.putInt("pos", pos);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        FloatingActionButton btn = findViewById(R.id.addNewStudentActionButton);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(StudentListActivity.this,NewStudentActivity.class));
            }
        });

        ImageView backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        data = DataModel.instance().getAllStudents();
        adapter.notifyDataSetChanged();
    }
}