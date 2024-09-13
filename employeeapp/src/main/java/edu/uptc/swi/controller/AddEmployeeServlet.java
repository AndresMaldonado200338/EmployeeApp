package edu.uptc.swi.controller;

import java.io.IOException;
import java.util.ArrayList;

import edu.uptc.swi.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployee")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ArrayList<Employee> employeeList = new ArrayList<Employee>();

    public AddEmployeeServlet() {

        super();
    }

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("emp_id");
        String name = req.getParameter("emp_name");
        String email = req.getParameter("emp_email");
        String phone = req.getParameter("emp_phone");
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setEmail(email);
        emp.setPhone(phone);
        employeeList.add(emp);
        req.getSession().setAttribute("oper", "success");
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
