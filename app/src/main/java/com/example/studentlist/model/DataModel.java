package com.example.studentlist.model;

import java.util.LinkedList;
import java.util.List;

public class DataModel {
    private static final DataModel _instance = new DataModel();

    public static DataModel instance() {
        return _instance;
    }

    private DataModel() {
        for (int i = 0; i < 20; i++) {
            this.addStudent(new Student("name " + i, "" + i, "", false, "phone" + i, "address" + i));
        }
    }

    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student st) {
        data.add(st);
    }


}
