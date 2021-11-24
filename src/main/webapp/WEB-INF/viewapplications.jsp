<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        .loanviewTable{
            margin-left: auto;
            margin-right: auto;
        }
        td{
            text-align:center;
        }
    </style>
</head>

<body>
<div>Welcome, ${sessionScope.username }
    <a href="user">Home</a>
    <a href="${pageContext.request.contextPath }/logout">Logout</a>
</div>
<h3>Applied Loan Status</h3>
<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>
<table class="loanviewTable">
    <tr>
        <th>Loan Id</th>
        <th>  Name</th>
        <th>  Age</th>
        <th>  Salary</th>
        <th>Loan Type</th>
        <th>Loan Status</th>
    </tr>
    <c:forEach items="${loans}" var="loan">
        <tr>
            <td>${loan.loanId} </td>
            <td>${loan.firstName}e</td>
            <td>${loan.age}</td>
            <td>${loan.salary}</td>
            <td>${loan.loanType}</td>
            <td>${loan.loanStatus}</td>
        </tr> <br>
    </c:forEach>

</table>

</body>
</html>