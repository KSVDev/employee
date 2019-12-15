package com.kozinets.employee.controller;

import com.kozinets.employee.db.DepartmentDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/depart/insert")
public class DepartmentInsertController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDB departmentDB = new DepartmentDB();
        String newDepartmentName = request.getParameter("NewDepartmentName");
        try {
            departmentDB.insertDepartment(newDepartmentName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/depart/select");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/departmentInsertJsp.jsp").forward(request, response);
    }
}