package com.kozinets.employee.controller;

import com.kozinets.employee.db.DepartmentDB;
import com.kozinets.employee.db.EmployeesDB;
import com.kozinets.employee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;

@WebServlet("/empl/insert")
public class EmployeeInsertController extends HttpServlet {
    private EmployeesDB employeesDB = new EmployeesDB();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeesDB employeesDB = new EmployeesDB();

        String newEmployeeName = request.getParameter("NewEmployeeName");
        String newEmployeeSurname = request.getParameter("NewEmployeeSurname");
        long newEmployeeDepartment = Long.parseLong(request.getParameter("NewEmployeeDepartment"));
        String newEmployeeDepartment2 = request.getParameter("NewEmployeeDepartment");
        String newEmployeeEmail = request.getParameter("NewEmployeeEmail");
        String newEmployeeBirthday = request.getParameter("NewEmployeeBirthday");
        int newEmployeeSalary = Integer.parseInt(request.getParameter("NewEmployeeSalary"));

        try {
            employeesDB.insertEmployee(newEmployeeName, newEmployeeSurname, newEmployeeDepartment, newEmployeeEmail, newEmployeeBirthday, newEmployeeSalary);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect( "/empl/select?flagDepartment=" + newEmployeeDepartment);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/employeeInsertJsp.jsp").forward(request, response);
    }
}