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

<div class="${errorMsg!=null ? "hide" : "show"}">
    Transfer Successful
</div>
<a href="/cust-dash/home"><button>Back</button></a>
</body>
</html>