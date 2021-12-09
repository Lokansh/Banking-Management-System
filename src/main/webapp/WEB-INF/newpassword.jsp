<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Forget Password</title>

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
        h4{
            font-family: Calibri;
            font-style: normal;
            font-weight: bold;
            text-align: center
        }
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

        .signupTable{
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
        .hide {
            display: none;
        }
    </style>

</head>

<%

    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    if(session.getAttribute("new_password")==null)
    {
        response.sendRedirect("/forget");
    }

%>

<body>

<h3>Welcome to Nova Bank</h3>

<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>
<h3>New Password</h3>
<form:errors path="newpassword.*"/>
<form:form  method="post" action="${pageContext.request.contextPath }/newpassword">

    <table border="0" class="signupTable" >

        <tr>
            <td>New Password</td>
            <td><input type="password" name="password"></td><br>
        </tr>

        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>