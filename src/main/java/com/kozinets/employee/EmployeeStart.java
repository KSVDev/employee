package com.kozinets.employee;

import com.kozinets.employee.db.DepartmentDB;
import com.kozinets.employee.db.EmployeeDB;
import com.kozinets.employee.db.ConnectionGetter;
import com.kozinets.employee.model.Department;
import com.kozinets.employee.model.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeStart {
    public static void main(String[] args) throws SQLException {
        ConnectionGetter connectionGetter = new ConnectionGetter();
        Connection connection = connectionGetter.getConnection();
        EmployeeDB employeesCDB = new EmployeeDB();
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
/*
        EmployeeDB employeesDB = new EmployeeDB();
        String name = "Руслан";
        String surname = "Бароев";
        long department = 18;
        String email = "ruslan@gmail.com";
        String birthday = "1993-2-17";
        int salary = 1000;

        employeesDB.insertEmployee(name, surname, department, email, birthday, salary);

 */
        EmployeeDB employeesDB = new EmployeeDB();
        long employeeId = 40;
        Employee employee2 = null;
        try {
            employee2 = employeesDB.getEmployeeById(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String name = employee2.getName();
        String surname = employee2.getSurname();
        long departmentId = employee2.getDepartment().getId();
        String email = employee2.getEmail();

        Date birthday =  employee2.getBirthday();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String birthdayStr = dateFormat.format(birthday);

        int salary = employee2.getSalary();
        System.out.println(employeeId);


        System.out.println(name);
        System.out.println(surname);
        System.out.println(departmentId);
        System.out.println(email);
        System.out.println(birthday);
        System.out.println(salary);
    }
}