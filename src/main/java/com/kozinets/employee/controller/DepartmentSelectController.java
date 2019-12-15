package com.kozinets.employee.controller;

import com.kozinets.employee.db.DepartmentDB;
import com.kozinets.employee.model.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/depart/select")
public class DepartmentSelectController extends HttpServlet {
    private DepartmentDB departmentDB = new DepartmentDB();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Department> departments = null;

        try {
            departments = departmentDB.getAllDepartments();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("departments", departments);
        request.getRequestDispatcher("/departmentSelectJsp.jsp").forward(request, response);
    }
}