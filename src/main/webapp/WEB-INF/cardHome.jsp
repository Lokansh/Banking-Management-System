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

<a href="${pageContext.request.contextPath }/logout">Apply for a Card</a>
<br><br>
<a href="${pageContext.request.contextPath }/logout">Block Card</a>
<br><br>
<a href="${pageContext.request.contextPath }/logout">Set/Reset Pin</a>
<br><br>
<a href="${pageContext.request.contextPath }/logout">Reset Pin</a>
<br><br>
<a href="${pageContext.request.contextPath }/logout">Modify Limit</a>

</body>
</html>