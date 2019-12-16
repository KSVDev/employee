package com.kozinets.employee.controller;

import com.kozinets.employee.db.EmployeeDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/empl/insert")
public class EmployeeInsertController extends HttpServlet {
    private EmployeeDB employeesDB = new EmployeeDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeDB employeesDB = new EmployeeDB();

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

        response.sendRedirect( "/empl/select?departmentId=" + newEmployeeDepartment);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long employeeId = Long.parseLong(request.getParameter("employeeId"));
        long departmentId = 0;
        try {
            departmentId = employeesDB.getDepartmentId(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("departmentId", departmentId);
        request.getRequestDispatcher("/employeeInsertJsp.jsp").forward(request, response);
    }
}