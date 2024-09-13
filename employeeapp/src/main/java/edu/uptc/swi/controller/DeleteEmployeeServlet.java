package edu.uptc.swi.controller;

import java.io.IOException;
import java.util.ArrayList;

import edu.uptc.swi.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    AddEmployeeServlet addEmployeeServlet = new AddEmployeeServlet();
    ArrayList<Employee> employeeList = addEmployeeServlet.getEmployeeList();

    public DeleteEmployeeServlet() {
        super();
    }

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("employeeId");
        boolean found = false;
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                employeeList.remove(emp);
                found = true;
                addEmployeeServlet.setEmployeeList(employeeList);
                break;
            }
        }

        if (found) {
            req.getSession().setAttribute("oper", "delete_success");
        } else {
            req.getSession().setAttribute("oper", "employee_not_found");
        }
    }
}
