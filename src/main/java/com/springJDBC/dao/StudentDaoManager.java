package com.springJDBC.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoManager implements StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    public StudentDaoManager(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public int insert(int studentId, String studentName, String studentAddress) {
        String query = "INSERT INTO student (id, name, address) VALUES(?,?,?)";
        return this.jdbcTemplate.update(query, studentId, studentName, studentAddress);
    }

    @Override
    public int insert(Student student) {
        return this.insert(student.getId(), student.getName(), student.getAddress());
    }

    @Override
    public int delete(int studentId) {
        String query = "DELETE FROM student WHERE id=?";
        return this.jdbcTemplate.update(query, studentId);
    }

    @Override
    public int delete(Student student) {
        return this.delete(student.getId());
    }

    @Override
    public int update(int studentId, String studentName, String studentAddress) {
        String query = "UPDATE student SET name=?, address=? WHERE ID=?;";
        return this.jdbcTemplate.update(query, studentName, studentAddress, studentId);
    }

    @Override
    public int update(Student student) {
        return this.update(student.getId(), student.getName(), student.getAddress());
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "SELECT * FROM student where ID=?;";
        StudentRowMapper rowMapper = new StudentRowMapper();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "SELECT * FROM student;";
        StudentRowMapper rowMapper = new StudentRowMapper();
        return this.jdbcTemplate.query(query, rowMapper);
    }
}