package com.springJDBC.dao;

public interface StudentDAO {
    int insert(int id, String name, String address);

    int insert(Student student);

    int delete(int id);

    int delete(Student student);

    int update(int id, String name, String address);

    int update(Student student);


}
