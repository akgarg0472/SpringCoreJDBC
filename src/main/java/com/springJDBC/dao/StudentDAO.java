package com.springJDBC.dao;

import java.util.List;

public interface StudentDAO {
    int insert(int id, String name, String address);

    int insert(Student student);

    int delete(int studentId);

    int delete(Student student);

    int update(int studentId, String studentName, String studentAddress);

    int update(Student student);

    Student getStudent(int studentId);

    List<Student> getAllStudents();
}
