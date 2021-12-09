<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Limit Modify</title>
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
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}
        .hide {
            display: none;
        }
        .incrLimit{
            margin-left: auto;
            margin-right: auto;
        }
        .modifyLimit{
            margin-left: auto;
            margin-right: auto;
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
        .container{text-align: center;}
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

<h2>Card Limit Modify</h2>

<div class="${Request==null ? "hide" : "successMsg"}">
    Your request have been successfully processed and limit has been changed to ${Request}.
</div>
<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>

<table class="modifyLimit">
    <tr>
        <td>
            <a href="checkLimit">Check Card Limit</a>
        </td>
    </tr>
    <tr>
        <div class="${CreditCardLimit==null ? "hide" : "successMsg"}">
            Your Card Limit is ${CreditCardLimit}
        </div>
    </tr>
    <tr>
        <td>
            <a href="changeLimit">Modify Limit</a>
        </td>
    </tr>
</table>

<form method="post" action="${pageContext.request.contextPath }/changeLimit" >
    <table class="${ChangeLimit==null ? "hide" : "incrLimit"}">
        <tr>
            <td>Username - </td>
            <td><output name="username">${sessionScope.username }</output></td>
        </tr>
        <tr>
            <td>Card Number - </td>
            <td><input type="text" name="cardNumber" placeholder="Enter Value"></td>
        </tr>
        <tr>
            <td>New Limit - </td>
            <td><input type="text" name="newLimit" placeholder="Enter Value"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>

</body>
</html>