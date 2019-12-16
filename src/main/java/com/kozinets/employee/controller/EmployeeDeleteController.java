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

@WebServlet("/empl/delete")
public class EmployeeDeleteController extends HttpServlet {
    private EmployeeDB employees = new EmployeeDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDB employeesDB = new EmployeeDB();
        long employeeId = Long.parseLong(request.getParameter("employeeId"));
        long departmentId = 0;
        try {
            departmentId = employeesDB.getDepartmentId(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            employeesDB.deleteEmployee(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/empl/select?departmentId=" + departmentId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long employeeId = Long.parseLong(request.getParameter("employeeId"));
        Employee employee = null;
        try {
            employee = employees.getEmployeeById(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String employeeName = employee.getName();
        request.setAttribute("employeeId", employeeId);
        request.setAttribute("employeeName", employeeName);
        request.getRequestDispatcher("/employeeDeleteJsp.jsp").forward(request, response);
    }
}