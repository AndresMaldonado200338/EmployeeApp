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

    public AddEmployeeServlet() {
        super();
    }

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la lista de empleados del contexto de la aplicación
        ArrayList<Employee> employeeList = (ArrayList<Employee>) getServletContext().getAttribute("employeeList");

        // Si no existe la lista, la creamos y la guardamos en el contexto
        if (employeeList == null) {
            employeeList = new ArrayList<>();
            getServletContext().setAttribute("employeeList", employeeList);
        }

        String id = req.getParameter("emp_id");
        String name = req.getParameter("emp_name");
        String email = req.getParameter("emp_email");
        String phone = req.getParameter("emp_phone");

        Employee emp = new Employee(id, name, email, phone);
        employeeList.add(emp);

        // Guardar la lista actualizada en el contexto
        getServletContext().setAttribute("employeeList", employeeList);

        System.out.println("Lista de empleados:");
        for (Employee e : employeeList) {
            System.out.println(e);
        }

        req.getSession().setAttribute("oper", "success");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
