package com.kozinets.employee.db;

import com.kozinets.employee.model.Department;
import com.kozinets.employee.model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDB {
    ConnectionGetter connectionGetter = new ConnectionGetter();
    Connection connection = connectionGetter.getConnection();

    public ArrayList<Employee> getAllEmployees() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
        ArrayList<Employee> employeeList = getEmployeeList(resultSet);
        return employeeList;
    }

    public ArrayList<Employee> getEmployeesByDepart(long id) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM employees Where department = " + id;
        ResultSet resultSet = statement.executeQuery(sql);
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
        while (resultSet.next()) {
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

    public void updateEmployee(long id, String name, String surname, long department, String email, String birthday, int salary) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "UPDATE employees SET"
                + " name = '" + name + "',"
                + " surname = '" + surname + "',"
                + " department = " + department + ","
                + " email = '" + email + "',"
                + " birthday = CONVERT('" + birthday + "', DATE),"
                + " salary = " + salary
                + " Where id = " + id;
        int result = statement.executeUpdate(sql);
    }

    public void insertEmployee(String name, String surname, long department, String email, String birthday, int salary) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO employees (name, surname, department, email, birthday, salary) VALUES ("
                + "'" + name + "',"
                + "'" + surname + "',"
                + department + ","
                + "'" + email + "',"
                + "CONVERT('" + birthday + "', DATE),"
                + salary
                + ")";
        int result = statement.executeUpdate(sql);
    }

    public void deleteEmployee(long id) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM employees WHERE id = " + id;
        int result = statement.executeUpdate(sql);
    }

    public long getDepartmentId(long employeeId) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT department FROM employees Where id = " + employeeId;
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        return resultSet.getLong("department");
    }
}
