package com.kozinets.employee.db;

import com.kozinets.employee.model.Department;

import java.sql.*;
import java.util.ArrayList;

public class DepartmentDB {
    ConnectionGetter connectionGetter = new ConnectionGetter();
    Connection connection = connectionGetter.getConnection();

    public ArrayList<Department> getAllDepartments() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");
        ArrayList<Department> departmentList = getDepartmentList(resultSet);
        return departmentList;
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

    public void updateDepartment(long id, String name) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "UPDATE departments SET name = '" + name + "' Where id = " + id;
        //ResultSet resultSet = statement.executeQuery(sql);
        int resultSet = statement.executeUpdate(sql);
    }

    public ArrayList<Department> getDepartmentList(ResultSet resultSet) throws SQLException {
        ArrayList<Department> departmentList = new ArrayList<Department>();
        while(resultSet.next()){
            Department department = new Department();
            department.setId(resultSet.getLong("id"));
            department.setName(resultSet.getString("name"));
            departmentList.add(department);
        }
        return departmentList;
    }
}