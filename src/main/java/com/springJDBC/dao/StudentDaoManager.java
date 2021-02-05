package com.springJDBC.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoManager implements StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    public StudentDaoManager(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public int insert(int id, String name, String address) {
        String query = "INSERT INTO student (id, name, address) VALUES(?,?,?)";
        return this.jdbcTemplate.update(query, id, name, address);
    }

    @Override
    public int insert(Student student) {
        return this.insert(student.getId(), student.getName(), student.getAddress());
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM student WHERE id=(?)";
        return this.jdbcTemplate.update(query, id);
    }

    @Override
    public int delete(Student student) {
        return this.delete(student.getId());
    }
}
