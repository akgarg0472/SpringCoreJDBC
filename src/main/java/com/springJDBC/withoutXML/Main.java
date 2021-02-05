package com.springJDBC.withoutXML;

import com.springJDBC.dao.StudentDAO;
import com.springJDBC.dao.StudentDaoManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        StudentDAO dao = context.getBean("studentDaoManager", StudentDaoManager.class);
        System.out.println(dao.getStudent(1));
    }
}
