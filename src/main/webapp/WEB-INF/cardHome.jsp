<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cards</title>
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
        h2{
            font-family: Calibri;
            color:#6b5b95;
            text-align: center;
        }
        .cardHome{
            margin-left: auto;
            margin-right: auto;
        }
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}
    </style>
</head>
<body>

<h3>Nova Bank</h3>
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    if(session.getAttribute("username")==null)
    {
        response.sendRedirect("/user");
    }
%>
<div class="container">Welcome, ${sessionScope.username }
    <a href="user">Home</a>
    <a href="${pageContext.request.contextPath }/logout">Logout</a>
</div>

<h2>Cards Home</h2>

<table class="cardHome">
    <tr>
        <td>
            <a href="${pageContext.request.contextPath }/applyCard">Apply for a Card</a>
            <br><br>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${pageContext.request.contextPath }/blockCard">Block Card</a>
            <br><br>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${pageContext.request.contextPath }/resetPin">Set/Reset Pin</a>
            <br><br>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${pageContext.request.contextPath }/cardEligibility">Check Credit Card Eligibility</a>
            <br><br>
        </td>
    </tr>
    <tr>
        <td>
            <a href="${pageContext.request.contextPath }/modifyLimit">Modify Limit</a>
            <br><br>
        </td>
    </tr>
</table>

</body>
</html>