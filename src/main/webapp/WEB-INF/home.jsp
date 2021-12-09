<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home page</title>
    <style>
        h3{
            font-family: Calibri;
            font-size: 30pt;
            font-style: normal;
            font-weight: bold;
            color:#6b5b95;
            text-align: center;
            text-decoration: underline
        }
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}
    </style>
</head>
<%

    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    if(session.getAttribute("username")!=null)
    {
        response.sendRedirect("/user");
    }

%>
<body>

<h3>Welcome to Nova Bank</h3>
<a href="signup"><h4>Sign Up</h4></a><br>
<a href="login"><h4>Login</h4></a><br>
<a href="employeelogin"><h4>Employee Login</h4></a><br>
<a href="adminlogin"><h4>Admin Login</h4></a>

</body>
</html>