package com.kozinets.employee;

import com.kozinets.employee.controller.EmployeesController;
import com.kozinets.employee.db.ConnectionGetter;
import com.kozinets.employee.entities.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeStart {
    public static void main(String[] args) throws SQLException {
        ConnectionGetter connectionGetter = new ConnectionGetter();
        Connection connection = connectionGetter.getConnection();
        EmployeesController employeesController = new EmployeesController(connectionGetter);
        //ArrayList<Employee> allEmployees = employeesController.getAllEmployees();
        ArrayList<Employee> allEmployees = employeesController.getAllEmployees();
        for (Employee employee : allEmployees){
            System.out.print(employee.getId() + " | ");
            System.out.print(employee.getName() + " | ");
            System.out.print(employee.getSurname() + " | ");
            System.out.print(employee.getEmail() + " | ");
            System.out.print(employee.getBirthday() + " | ");
            System.out.print(employee.getSalary() + " | ");
            System.out.println(employee.getDepartment().getName());

        }
        Employee employee = employeesController.getEmployeeById(4);
        System.out.println("");
        System.out.println("");
        System.out.println("Empolyee by id:");
        System.out.print(employee.getId() + " | ");
        System.out.print(employee.getName() + " | ");
        System.out.print(employee.getSurname() + " | ");
        System.out.print(employee.getEmail() + " | ");
        System.out.print(employee.getBirthday() + " | ");
        System.out.print(employee.getSalary() + " | ");
        System.out.println(employee.getDepartment().getName());
    }
}