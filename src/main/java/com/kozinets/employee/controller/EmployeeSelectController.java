package com.kozinets.employee.controller;

import com.kozinets.employee.db.DepartmentDB;
import com.kozinets.employee.db.EmployeesDB;
import com.kozinets.employee.model.Department;
import com.kozinets.employee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/empl/select")
public class EmployeeSelectController extends HttpServlet {
    private EmployeesDB employeesDB = new EmployeesDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Employee> employees = null;
        ArrayList<String> attributes = (ArrayList<String>) request.getAttributeNames();

        if(attributes.size() > 0){
            long departmentId = (long)request.getAttribute("departmentId");
            if(departmentId > 0) {
                try {
                    employees = employeesDB.getAllEmployees();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/employeeSelectJsp.jsp").forward(request, response);
    }
}