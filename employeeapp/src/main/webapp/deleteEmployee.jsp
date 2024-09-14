<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
        <link href="./css/empStyle.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <div class="topnav">
            <a href="./">Crear empleado</a>
            <a href="modifyEmployee.jsp">Modificar empleado</a>
            <a href="deleteEmployee.jsp">Borrar Empleado</a>
        </div>

        <div class="content">
            <h1>DELETE EMPLOYEE</h1>
            <h2>Hola, por favor ingrese el ID del empleado que desea borrar</h2>

            <form action="DeleteEmployee" method="get">
                <label for="employeeId">Ingrese el ID:</label>
                <input type="text" id="employeeId" name="employeeId" required>
                <button type="submit">Borrar empleado</button>
            </form>

            <% String oper=(String) request.getSession().getAttribute("oper"); if ("delete_success".equals(oper)) { %>
                <h2>Empleado eliminado exitosamente!</h3>
                    <% } else if ("employee_not_found".equals(oper)) { %>
                        <h2>Empleado no encontrado. Intente de nuevo.</h3>
                            <% } %>
        </div>

        <div class="footer">
            <p>Footer</p>
        </div>

    </body>

    </html>