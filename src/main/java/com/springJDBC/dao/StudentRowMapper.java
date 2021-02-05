package com.springJDBC.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
    }
}
