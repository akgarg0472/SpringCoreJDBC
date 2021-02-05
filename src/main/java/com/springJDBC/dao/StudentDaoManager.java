package com.springJDBC.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoManager implements StudentDAO {
    private JdbcTemplate jdbcTemplate;

    public StudentDaoManager(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public int insert(int id, String name, String address) {
        String query = "INSERT INTO student (id, name, address) VALUES(?,?,?)";
        int queryResult = this.jdbcTemplate.update(query, id, name, address);
        return queryResult;
    }

    @Override
    public int insert(Student student) {
        int queryResult = this.insert(student.getId(), student.getName(), student.getAddress());
        return queryResult;
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM student WHERE id=(?)";
        int queryResult = this.jdbcTemplate.update(query, id);
        return queryResult;
    }

    @Override
    public int delete(Student student) {
        int queryResult = this.delete(student.getId());
        return queryResult;
    }
}
