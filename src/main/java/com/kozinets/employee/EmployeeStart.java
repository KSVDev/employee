package com.kozinets.employee;

import com.kozinets.employee.db.DepartmentDB;
import com.kozinets.employee.db.EmployeesDB;
import com.kozinets.employee.db.ConnectionGetter;
import com.kozinets.employee.model.Department;
import com.kozinets.employee.model.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeStart {
    public static void main(String[] args) throws SQLException {
        ConnectionGetter connectionGetter = new ConnectionGetter();
        Connection connection = connectionGetter.getConnection();
        EmployeesDB employeesCDB = new EmployeesDB();
        DepartmentDB departmentDB = new DepartmentDB();
        ArrayList<Employee> allEmployees = employeesCDB.getAllEmployees();


        for (Employee employee : allEmployees){
            System.out.print(employee.getId() + " | ");
            System.out.print(employee.getName() + " | ");
            System.out.print(employee.getSurname() + " | ");
            System.out.print(employee.getEmail() + " | ");
            System.out.print(employee.getBirthday() + " | ");
            System.out.print(employee.getSalary() + " | ");
            System.out.println(employee.getDepartment().getName());

        }
        Employee employee = employeesCDB.getEmployeeById(4);

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


        //Departments
        ArrayList<Department> allDepartments = departmentDB.getAllDepartments();
        System.out.println("");
        System.out.println("");
        System.out.println("Departments:");
        for (Department department : allDepartments){
            System.out.print(department.getId() + " | ");
            System.out.println(department.getName());

        }

        EmployeesDB employeesDB = new EmployeesDB();
        String name = "Аслан";
        String surname = "Рахман";
        long department = 18;
        String email = "aslan@gmail.com";
        String birthday = "1993-2-17";
        int salary = 1000;

        employeesDB.insertEmployee(name, surname, department, email, birthday, salary);
    }
}