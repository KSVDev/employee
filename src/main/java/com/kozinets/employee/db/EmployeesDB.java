package com.kozinets.employee.db;

import com.kozinets.employee.model.Department;
import com.kozinets.employee.model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeesDB {
    ConnectionGetter connectionGetter = new ConnectionGetter();
    Connection connection = connectionGetter.getConnection();

    public ArrayList<Employee> getAllEmployees() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
        ArrayList<Employee> employeeList = getEmployeeList(resultSet);
        return employeeList;
    }

    private Department getDepartmentById(long id) throws SQLException {
        DepartmentDB departmentController = new DepartmentDB();
        Department department = departmentController.getDepartmentById(id);
        return department;
    }

    public Employee getEmployeeById(long id) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM employees Where id = " + id;
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.first();
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setName(resultSet.getString("name"));
        employee.setSurname(resultSet.getString("surname"));
        employee.setEmail(resultSet.getString("email"));
        employee.setBirthday(resultSet.getDate("birthday"));
        employee.setSalary(resultSet.getInt("salary"));
        employee.setDepartment(getDepartmentById(resultSet.getLong("department")));
        return employee;
    }

    public ArrayList<Employee> getEmployeeList(ResultSet resultSet) throws SQLException {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        while(resultSet.next()){
            Employee employee = new Employee();
            employee.setId(resultSet.getLong("id"));
            employee.setName(resultSet.getString("name"));
            employee.setSurname(resultSet.getString("surname"));
            employee.setEmail(resultSet.getString("email"));
            employee.setBirthday(resultSet.getDate("birthday"));
            employee.setSalary(resultSet.getInt("salary"));
            employee.setDepartment(getDepartmentById(resultSet.getLong("department")));
            employeeList.add(employee);
        }
        return employeeList;
    }
}
