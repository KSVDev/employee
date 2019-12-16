package com.kozinets.employee.controller;

import com.kozinets.employee.db.DepartmentDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/depart/delete")
public class DepartmentDeleteController extends HttpServlet {
    private DepartmentDB departmentDB = new DepartmentDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDB departmentDB = new DepartmentDB();
        long departmentId = Long.parseLong(request.getParameter("departmentId"));
        try {
            departmentDB.deleteDepartment(departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/depart/select");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long departmentId = Long.parseLong(request.getParameter("departmentId"));
        String departmentName = null;
        try {
            departmentName = departmentDB.getDepartmentById(departmentId).getName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("departmentName", departmentName);
        request.setAttribute("departmentId", departmentId);
        request.getRequestDispatcher("/departmentDeleteJsp.jsp").forward(request, response);
    }
}