<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>CARDS</title>
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
    </style>
</head>
<body>

<h3>Nova Bank</h3>

<form method="post" action="${pageContext.request.contextPath }/applyCard">

    <table border="0" class="applyCard" >
        <tr>
            <td>Username</td>
            <td><output name="accountNumber">accountNumber</output></td>
        </tr>
        <tr>
            <td>Card Type</td>
            <td><input type="checkbox" name="cardType"></td><br>
            <td><a href="forget">Forget Password?</a></td>
        </tr>

        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Login"></td>
        </tr>
    </table>
</form>

</body>
</html>