package com.kozinets.employee.controller;

import com.kozinets.employee.db.DepartmentDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/depart/update")
public class DepartmentUpdateController extends HttpServlet {
    private DepartmentDB departmentDB = new DepartmentDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long flagDepartment = Long.parseLong(request.getParameter("flagDepartment"));
        String newName = request.getParameter("NewDepartmentName");
        try {
            departmentDB.updateDepartment(flagDepartment, newName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/depart/select");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long flagDepartment = Long.parseLong(request.getParameter("flagDepartment"));
        request.setAttribute("flagDepartment", flagDepartment);
        request.getRequestDispatcher("/departmentUpdateJsp.jsp").forward(request, response);
    }
}