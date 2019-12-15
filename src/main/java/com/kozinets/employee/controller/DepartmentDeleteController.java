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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDB departmentDB = new DepartmentDB();
        long flagDepartment = Long.parseLong(request.getParameter("flagDepartment"));
        try {
            departmentDB.deleteDepartment(flagDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/depart/select");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long flagDepartment = Long.parseLong(request.getParameter("flagDepartment"));
        request.setAttribute("flagDepartment", flagDepartment);
        request.getRequestDispatcher("/departmentDeleteJsp.jsp").forward(request, response);
    }
}