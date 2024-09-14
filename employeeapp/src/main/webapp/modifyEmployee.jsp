<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="edu.uptc.swi.model.Employee" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modificar empleado</title>
    <link href="./css/empStyle.css" rel="stylesheet" type="text/css">
</head>

<body>
    <div class="topnav">
        <a href="./">Crear empleado</a>
        <a href="modifyEmployee.jsp">Modificar empleado</a>
        <a href="deleteEmployee.jsp">Borrar Empleado</a>
    </div>

    <div class="content">
        <h1> EMPLOYEE APP</h1>
        <h2> Modificar empleado </h2>

        <% 
            // Verificamos si el ID fue proporcionado
            Employee employee = (Employee) request.getAttribute("employee");
            if (employee == null) {
        %>
            <form action="ModifyEmployee" method="get">
                <table cellspacing="3" cellpadding="3" border="1">
                    <tr>
                        <td align="right">Ingrese el ID del empleado:</td>
                        <td><input type="text" name="id"></td>
                    </tr>
                </table>
                <input type="submit" value="Buscar empleado">
            </form>

        <% 
            } else {
        %>
            <form action="ModifyEmployee" method="post">
                <input type="hidden" name="id" value="<%= employee.getId() %>">
                <table cellspacing="3" cellpadding="3" border="1">
                    <tr>
                        <td align="right">ID Empleado: </td>
                        <td><%= employee.getId() %></td>
                    </tr>
                    <tr>
                        <td align="right">Nombre Empleado: </td>
                        <td><input type="text" name="name" value="<%= employee.getName() %>"></td>
                    </tr>
                    <tr>
                        <td align="right">Email Empleado: </td>
                        <td><input type="text" name="email" value="<%= employee.getEmail() %>"></td>
                    </tr>
                    <tr>
                        <td align="right">Telefono Empleado: </td>
                        <td><input type="text" name="phone" value="<%= employee.getPhone() %>"></td>
                    </tr>
                </table>
                <input type="submit" value="Actualizar">
            </form>
        <% 
            }
        %>

        <% 
        String oper = String.valueOf(request.getSession().getAttribute("oper"));
        if ("success".equals(oper)) {
        %>
            <h2>Empleado modificado exitosamente!</h2>
        <% 
        } else if ("error".equals(oper)) {
        %>
            <h2>Error al modificar el empleado.</h2>
        <% 
        }
        request.getSession().removeAttribute("oper");
        %>
    </div>

    <div class="footer">
        <p>Footer</p>
    </div>
</body>

</html>
