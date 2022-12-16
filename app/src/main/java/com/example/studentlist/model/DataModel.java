package com.example.studentlist.model;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

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

    Vector<Student> data = new Vector<>();

    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student st) {
        data.add(st);
    }

    public Student getStudentByPos(int pos) {
        return data.get(pos);
    }

    public void deleteStudent(int pos) {
        data.remove(pos);
    }

    public void setStudent(int pos,Student newStudent) {
        data.set(pos,newStudent);
    }
}
