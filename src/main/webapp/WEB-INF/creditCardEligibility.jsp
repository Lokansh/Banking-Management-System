<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Card Eligibility</title>
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
        .successMsg{
            border: 1px solid;
            margin: 10px 0px;
            padding: 15px 10px 15px 50px;
            background-repeat: no-repeat;
            background-position: 10px center;
            color: #08d601;
            background-color: #d3ffba;
        }
        .errorMsg1{
            border: 1px solid;
            margin: 10px 0px;
            padding: 15px 10px 15px 50px;
            background-repeat: no-repeat;
            background-position: 10px center;
            color: #D63301;
            background-color: #FFA500;
            background-image: url('https://i.imgur.com/GnyDvKN.png');
        }
        .errorMsg2{
            border: 1px solid;
            margin: 10px 0px;
            padding: 15px 10px 15px 50px;
            background-repeat: no-repeat;
            background-position: 10px center;
            color: #D63301;
            background-color: #FFCCBA;
            background-image: url('https://i.imgur.com/GnyDvKN.png');
        }
        .cardEligibility{
            margin-left: auto;
            margin-right: auto;
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

<h2>Check Credit Card Eligibility</h2>

<div class="${RequestSuccess==null ? "hide" : "successMsg"}">
    You are eligible for a credit card.
</div>
<div class="${RequestDeny==null ? "hide" : "errorMsg1"}">
    Sorry, you are not eligible for a credit card.
</div>
<div class="${errorMsg==null ? "hide" : "errorMsg2"}">
    ${errorMsg}
</div>

<form method="post" action="${pageContext.request.contextPath }/cardEligibility">

    <table border="0" class="cardEligibility" >
        <tr>
            <td>Username - </td>
            <td><output name="username">${sessionScope.username }</output></td>
        </tr>
        <tr>
            <td>SIN - </td>
            <td><input type="text" name="sin" placeholder="Enter value"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>

</body>
</html>