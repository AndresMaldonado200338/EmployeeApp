package edu.uptc.swi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.uptc.swi.model.Employee;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteEmployeeServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la lista de empleados del contexto de la aplicación
        ServletContext context = getServletContext();
        ArrayList<Employee> employeeList = (ArrayList<Employee>) context.getAttribute("employeeList");

        if (employeeList == null) {
            employeeList = new ArrayList<>();
            context.setAttribute("employeeList", employeeList);
        }

        String id = req.getParameter("employeeId");
        boolean found = false;

        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId().equals(id)) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            req.getSession().setAttribute("oper", "delete_success");
            System.out.println("Lista de empleados después de eliminar:");
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        } else {
            req.getSession().setAttribute("oper", "employee_not_found");
        }
        resp.sendRedirect("./");
    }
}
