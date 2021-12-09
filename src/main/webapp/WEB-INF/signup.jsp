<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Sign up</title>

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
<body>

<h3>Welcome to Nova Bank</h3>

<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>

<a href="home"><h4>Home Page</h4></a><br>

<form:errors path="userInfo.*"/>
<form:form  method="post" action="${pageContext.request.contextPath }/signup">

    <table border="0" class="signupTable" >

        <tr>
            <td>cutomerID</td>
            <td>
                <input type="text" name="customer.CustomerID">
            </td>
        </tr>
        <tr>
            <td>First Name</td>
            <td>
                <input type="text" name="customer.firstName">
            </td>
        </tr>

        <tr>
            <td>Last Name</td>
            <td>
                <input type="text" name="customer.lastName">
            </td>
        </tr>

        <tr>
            <td>Address Line 1</td>
            <td>
                <input type="text" name="customer.address1">
            </td>
        </tr>

        <tr>
            <td>Address Line 2</td>
            <td>
                <input type="text" name="customer.address2">
            </td>
        </tr>

        <tr>
            <td>City</td>
            <td>
                <input type="text" name="customer.City">
            </td>
        </tr>

        <tr>
            <td>ZipCode</td>
            <td>
                <input type="text" name="customer.zipCode">
            </td>
        </tr>

        <tr>
            <td>Contact Number</td>
            <td>
                <input type="text" name="customer.contactNumber">
            </td>
        </tr>

        <tr>
            <td>Email Address</td>
            <td>
                <input type="text" name="customer.email">
            </td>
        </tr>

        <tr>
            <td>SIN number</td>
            <td>
                <input type="number" name="customer.sin">
            </td>
        </tr>

        <tr>
            <td>Username</td>
            <td>
                <input type="text" name="userLogin.UserLoginID">
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="userLogin.password"></td>
        </tr>

        <tr>
            <td>USerID</td>
            <td><input type="text" name="securityAnswer.userLoginID"></td>
        </tr>

        <tr>
            <td>Security Question</td>
            <td><input type="number" name="securityAnswer.questionID"></td>
        </tr>

        <tr>
            <td>Security Answer</td>
            <td><input type="text" name="securityAnswer.questionAnswer"></td>
        </tr>

        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="signup"></td>
        </tr>
    </table>
</form:form>
</body>
</html>