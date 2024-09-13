package edu.uptc.swi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import edu.uptc.swi.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ModifyEmployee")
public class ModifyEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public ModifyEmployeeServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        employeeList.add(new Employee("1", "Juan Perez", "juan.p@gmail.com", "123456789"));
        employeeList.add(new Employee("2", "Carla Suarez", "jcarla.s@gmail.com", "987654321"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Optional<Employee> employeeOpt = employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
            if (employeeOpt.isPresent()) {
                req.setAttribute("employee", employeeOpt.get());
                req.getRequestDispatcher("/modifyEmployee.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("index.jsp?error=Employee not found");
            }
        } else {
            resp.sendRedirect("index.jsp?error=No employee ID provided");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        if (id != null) {
            Optional<Employee> employeeOpt = employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
            if (employeeOpt.isPresent()) {
                Employee emp = employeeOpt.get();
                emp.setName(name);
                emp.setEmail(email);
                emp.setPhone(phone);
                req.getSession().setAttribute("oper", "success");
            } else {
                req.getSession().setAttribute("oper", "error");
            }
        } else {
            req.getSession().setAttribute("oper", "error");
        }
        resp.sendRedirect("index.jsp");
    }
}
