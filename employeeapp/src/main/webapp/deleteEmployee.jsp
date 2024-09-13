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
        <a href="index.jsp">Crear empleado</a>
        <a href="#">Modificar empleado</a>
        <a href="deleteEmployee.jsp">Borrar Empleado</a>
        </div>

        <div class="content">
            <h1> DELETE EMPLOYEE</h1>
            <h2> Hola, por favor ingrese el id del empleado que desea borrar</h2>
            <form action="DeleteEmployee" method="get">
                <label for="employeeId">Ingrese el ID:</label>
                <input type="text" id="employeeId" name="employeeId" required>
                <button type="submit">Borrar empleado</button>
            </form>
        </div>
        <div class="footer">
            <p>Footer</p>
        </div>

    </body>

    </html>