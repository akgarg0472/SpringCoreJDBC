package com.springJDBC;

import com.springJDBC.dao.Student;
import com.springJDBC.dao.StudentDAO;
import com.springJDBC.dao.StudentDaoManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("JDBCConfig.xml");
        StudentDAO dao = context.getBean("studentDaoManager", StudentDaoManager.class);

//        // insertion in Database using DAO layer
        System.out.println(dao.insert(new Student(1, "Akhilesh Garg", "Haryana")));
//
//        // deletion in Database using DAO layer
        System.out.println(dao.delete(1));
        System.out.println(dao.delete(new Student(1, "Akhilesh Garg", "Haryana")));
//
//        // updating in Database using DAO layer
        Student student = new Student(1, "Akhilesh Garg", "Gurugram, Haryana");
        System.out.println(dao.update(student));
        System.out.println(dao.update(15, "Shubham Yadav", "Gurugram, Haryana, India"));

//        performing select query using DAO layer
        System.out.println(dao.getStudent(1));
        List<Student> studentList = dao.getAllStudents();
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}