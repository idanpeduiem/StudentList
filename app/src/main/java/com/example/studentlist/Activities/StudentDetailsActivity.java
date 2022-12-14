package com.example.studentlist.Activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.studentlist.R;
import com.example.studentlist.model.DataModel;
import com.example.studentlist.model.Student;

public class StudentDetailsActivity extends Activity {
    private Student st;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("StudentDetailsActivity","got here");
        setContentView(R.layout.student_details);

        Bundle b = getIntent().getExtras();
        int pos = b.getInt("pos");

        st = DataModel.instance().getStudentByPos(pos);
        refreshDisplay();
        Button editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(view -> {
            Intent intent = new Intent(StudentDetailsActivity.this, EditStudentActivity.class);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        });
        ImageView backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void refreshDisplay(){
        TextView nameTv = findViewById(R.id.nameTextView);
        TextView idTv = findViewById(R.id.idTextView);
        TextView phoneTv = findViewById(R.id.phoneTextView);
        TextView addressTv = findViewById(R.id.addressTextView);
        CheckBox cb = findViewById(R.id.checkBox);

        Log.d("StudentDetails", st.toString());

        nameTv.setText("Name: " + st.name);
        idTv.setText("id: " + st.id);
        phoneTv.setText("phone: " + st.phone);
        addressTv.setText("address: " + st.address);
        cb.setChecked(st.cb);
        cb.setEnabled(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle b = getIntent().getExtras();
        int pos = b.getInt("pos");
        st = DataModel.instance().getStudentByPos(pos);
        refreshDisplay();
    }
}
