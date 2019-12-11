package com.kozinets.employee.controller;

import com.kozinets.employee.db.DepartmentDB;
import com.kozinets.employee.model.Department;
import com.kozinets.employee.model.Employee;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Department> departments = null;

        try {
            departments = departmentDB.getAllDepartments();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("departments", departments);
        getServletContext().getRequestDispatcher("/departmentsJsp.jsp").forward(request, response);
    }
}
/*
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String[] users = new String[]{"Tom", "Bob", "Sam"};
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
*/