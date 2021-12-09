<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Credit Card</title>
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

<div class="container">Welcome, ${sessionScope.username }
    <a href="ccServices">Home</a>
    <a href="${pageContext.request.contextPath }/logout">Logout</a>
</div>
<h3> My Credit Card Details</h3>
<div class="${successMsg==null ? "hide" : "successMsg"}">
    ${successMsg}
</div>
<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>
<table class="loanviewTable">
    <tr>

        <th>  Card Number</th>
        <th>  Card Type</th>
        <th>  Card Limit</th>
        <th>  Card State</th>

    </tr>
    <c:forEach items="${ccdetails}" var="ccdetail">
    <tr>
        <td>${ccdetail.cardNumber} </td>
        <td>${ccdetail.cardType}</td>
        <td>${ccdetail.cardLimit}</td>
        <td>${ccdetail.cardStatus?"Active":"InActive"}</td>

    </tr> <br>
    </c:forEach>



</body>
</html>