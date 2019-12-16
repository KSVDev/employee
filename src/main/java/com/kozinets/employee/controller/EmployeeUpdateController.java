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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/empl/update")
public class EmployeeUpdateController extends HttpServlet {
    private EmployeeDB employeesDB = new EmployeeDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long employeeId = Long.parseLong(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        String employeeSurname = request.getParameter("employeeSurname");
        long departmentId = Long.parseLong(request.getParameter("departmentId"));
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeBirthday = request.getParameter("employeeBirthday");
        int employeeSalary = Integer.parseInt(request.getParameter("employeeSalary"));
        try {
            employeesDB.updateEmployee(employeeId, employeeName, employeeSurname, departmentId, employeeEmail, employeeBirthday, employeeSalary);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/empl/select?flagDepartment=" + departmentId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long employeeId = Long.parseLong(request.getParameter("employeeId"));
        Employee employee = null;
        try {
            employee = employeesDB.getEmployeeById(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(employee != null){
        String name = employee.getName();
        String surname = employee.getSurname();
        long departmentId = employee.getDepartment().getId();
        String email = employee.getEmail();

        Date birthday =  employee.getBirthday();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthdayStr = dateFormat.format(birthday);

        int salary = employee.getSalary();

        request.setAttribute("employeeId", employeeId);
        request.setAttribute("employeeName", name);
        request.setAttribute("employeeSurname", surname);
        request.setAttribute("departmentId", departmentId);
        request.setAttribute("employeeEmail", email);
        request.setAttribute("employeeBirthday", birthdayStr);
        request.setAttribute("employeeSalary", salary);

        request.getRequestDispatcher("/employeeUpdateJsp.jsp").forward(request, response);
        }
    }
}