package com.example.studentlist.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.studentlist.R;
import com.example.studentlist.model.DataModel;
import com.example.studentlist.model.Student;

public class EditStudentActivity  extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_student);

        Bundle b = getIntent().getExtras();
        int pos = b.getInt("pos");

        Student st = DataModel.instance().getStudentByPos(pos);

        Log.d("StudentDetails", st.toString());

        TextView nameTv = findViewById(R.id.nameTextView);
        TextView idTv = findViewById(R.id.idTextView);
        TextView phoneTv = findViewById(R.id.phoneTextView);
        TextView addressTv = findViewById(R.id.addressTextView);
        CheckBox cb = findViewById(R.id.checkBox);

        Button cancelButton = findViewById(R.id.cancelButton);
        Button deleteButton = findViewById(R.id.deleteButton);
        Button saveButton = findViewById(R.id.saveButton);

        nameTv.setText(st.name);
        idTv.setText(st.id);
        phoneTv.setText(st.phone);
        addressTv.setText(st.address);
        cb.setChecked(st.cb);


        cancelButton.setOnClickListener(view -> {
            Intent intent = new Intent(EditStudentActivity.this, StudentDetailsActivity.class);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        });
        deleteButton.setOnClickListener(view -> {
            DataModel.instance().deleteStudent(pos);
            finish();
        });
        saveButton.setOnClickListener(view -> {
            Intent intent = new Intent(EditStudentActivity.this, StudentDetailsActivity.class);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        });


    }
}
