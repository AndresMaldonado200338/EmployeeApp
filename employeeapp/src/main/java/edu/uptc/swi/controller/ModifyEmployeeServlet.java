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

    public ModifyEmployeeServlet() {
        super();
    }

    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la lista de empleados del contexto de la aplicación
        ArrayList<Employee> employeeList = (ArrayList<Employee>) getServletContext().getAttribute("employeeList");

        if (employeeList == null) {
            resp.sendRedirect("index.jsp?error=No employees found");
            return;
        }

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
        ArrayList<Employee> employeeList = (ArrayList<Employee>) getServletContext().getAttribute("employeeList");

        if (employeeList == null) {
            resp.sendRedirect("index.jsp?error=No employees found");
            return;
        }

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

                System.out.println("Lista de empleados después de la modificación:");
                for (Employee employee : employeeList) {
                    System.out.println(employee);
                }
                
            } else {
                req.getSession().setAttribute("oper", "error");
            }
        } else {
            req.getSession().setAttribute("oper", "error");
        }
        resp.sendRedirect("./");
    }
}