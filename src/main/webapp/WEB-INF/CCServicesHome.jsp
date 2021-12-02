<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title> User login</title>
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
            text-decoration: underline
        }
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

        .applyLoanTable{
            margin-left: auto;
            margin-right: auto;
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
        .container{ text-align: center;}
    </style>
</head>
<body>
<div class="${successMsg==null ? "hide" : "successMsg"}">
    ${successMsg}
</div>
<div class="container">Welcome, ${sessionScope.username }
    <a href="user">Home</a>
    <a href="${pageContext.request.contextPath }/logout">Logout</a>
</div>
<h3> Credit Card Services</h3>
<%

    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

    if(session.getAttribute("username")==null)
    {
        response.sendRedirect("/login");
    }

%>

<a href="ccServices">Check my CC Bills</a>
<br>
<a href="ccServices">Check my Credit Score</a>
<br>
<a href="ccServices">Redeem Reward Points</a>
<br>
<a href="ccServices">Apply for Credit Limit Increase</a>
</body>
</html>