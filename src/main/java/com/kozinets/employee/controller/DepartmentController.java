package com.kozinets.employee.controller;

import com.kozinets.employee.entities.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentController {
    Connection connection;

    public DepartmentController(Connection connection){
        this.connection = connection;
    }

    public Department getDepartmentById(long id) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM departments Where id = " + id;
        ResultSet resultSet = statement.executeQuery(sql);
        Department department = new Department();
        resultSet.first();
        department.setId(resultSet.getLong("id"));
        department.setName(resultSet.getString("name"));
        return department;
    }
}
