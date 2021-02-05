package com.springJDBC;

import com.springJDBC.dao.Student;
import com.springJDBC.dao.StudentDAO;
import com.springJDBC.dao.StudentDaoManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("JDBCConfig.xml");
        StudentDAO dao = context.getBean("studentDaoManager", StudentDaoManager.class);
        System.out.println(dao.delete(1));
        System.out.println(dao.delete(2));
        System.out.println(dao.insert(new Student(1, "Akhilesh Garg", "Haryana")));
        System.out.println(dao.delete(new Student(1, "Akhilesh Garg", "Haryana")));
    }
}
