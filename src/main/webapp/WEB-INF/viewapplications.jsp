<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Applied loans</title>
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
        .errorMsg{
            border: 1px solid;
            margin: 10px 0px;
            padding: 15px 10px 15px 50px;
            background-repeat: no-repeat;
            background-position: 10px center;
            color: #D63301;
            background-color: #FFCCBA;
            background-image: url('https://i.imgur.com/GnyDvKN.png');
        }
        .successMsg{
            border: 1px solid;
            margin: 10px 0px;
            padding: 15px 10px 15px 50px;
            background-repeat: no-repeat;
            background-position: 10px center;
            color: #08d601;
            background-color: #d3ffba;
        }
        .hide {
            display: none;
        }
        .container{text-align: center;}
    </style>
</head>

<body>
<div>Welcome, ${sessionScope.username }
    <a href="user">Home</a>
    <a href="${pageContext.request.contextPath }/logout">Logout</a>
</div>
<div class="${successMsg==null ? "hide" : "successMsg"}">
    ${successMsg}
</div>
<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>
<h3>Applied Loan Status</h3>

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
            <td>${loan.firstName}</td>
            <td>${loan.age}</td>
            <td>${loan.salary}</td>
            <td>${loan.loanType}</td>
            <td>${loan.loanStatus?"APPROVED":"PENDING"}</td>

        </tr> <br>
    </c:forEach>

</table>

</body>
</html>