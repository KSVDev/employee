package com.kozinets.employee.controller;

import com.kozinets.employee.db.EmployeeDB;
import com.kozinets.employee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/empl/select")
public class EmployeeSelectController extends HttpServlet {
    private EmployeeDB employeesDB = new EmployeeDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long departmentId = Long.parseLong(request.getParameter("flagDepartment"));

        ArrayList<Employee> employees = null;

        if (departmentId > 0) {
            try {
                employees = employeesDB.getEmployeesByDepart(departmentId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/employeeSelectJsp.jsp").forward(request, response);
    }
}