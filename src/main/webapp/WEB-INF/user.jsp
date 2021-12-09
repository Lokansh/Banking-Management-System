<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title> Nova Bank | User Page</title>
    <style>
        h3{
            font-family: Calibri;
            font-size: 30pt;
            font-style: normal;
            font-weight: bold;
            color:#D63301;
            text-align: center;
            text-decoration: underline
        }
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}
    </style>
</head>
<body>

<h3> Nova Bank</h3>
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

    if(session.getAttribute("username")==null||session.getAttribute("role")!="user")
    {
        response.sendRedirect("/login");
    }

%>

Welcome, ${sessionScope.username }
<br>

<a href="${pageContext.request.contextPath }/logout">Logout</a>

<a href="cust-dash/home"><h4>Profile Page</h4></a><br>
<a href="depositHome"><h4>Deposit Page</h4></a><br>
<a href="chequebookHome"><h4>Cheque Book Home</h4></a><br>
<a href="loanapp"><h4>Loan Application</h4></a><br>
<a href="cardHome"><h4>Manage Cards</h4></a><br>
<a href="ccServicesHome"><h4>Credit Card</h4></a><br>
</body>
</html>