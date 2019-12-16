package com.kozinets.employee.controller;

import com.kozinets.employee.db.EmployeesDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/empl/delete")
public class EmployeeDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeesDB employeesDB = new EmployeesDB();
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

        response.sendRedirect("/empl/select?flagDepartment=" + departmentId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long employeeId = Long.parseLong(request.getParameter("employeeId"));
        request.setAttribute("employeeId", employeeId);
        request.getRequestDispatcher("/employeeDeleteJsp.jsp").forward(request, response);
    }
}