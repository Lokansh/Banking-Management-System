<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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

        .salaryMsg{
            border: 1px solid;
            margin: 10px 0px;
            padding: 15px 10px 15px 50px;
            background-repeat: no-repeat;
            background-position: 10px center;
            color:#6b5b95;
            background-color: #FFFFFF;
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
<body>

<h3> Nova Bank</h3>


<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

    if(session.getAttribute("username")==null||session.getAttribute("role")!="admin")
    {
        response.sendRedirect("/adminlogin");
    }

%>
Welcome, ${sessionScope.username }
<br>
<a href="${pageContext.request.contextPath }/adminlogout">Logout</a>
<br>

<div class="${isSalary==null ? "hide" : "salaryMsg"}">
   Employee ${employeeName} is being paid a salary of ${salary} CAD per week.
</div>

<form:form  method="post" action="${pageContext.request.contextPath }/salary">

    <table border="0" class="signupTable" >
        <tr>
            <td>Check Salary of EmployeeID</td>
            <td><input type="text" name="employeeName"></td><br>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Find Salary"></td>
        </tr>
    </table>
</form:form>

</body>
</html>