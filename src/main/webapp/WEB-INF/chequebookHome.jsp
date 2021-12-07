<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cheque Book</title>
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
        .chequebookHome{
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

<h2>Cheque Book Home</h2>

<table class="chequebookHome">
    <tr>
        <td>
            <a href="${pageContext.request.contextPath }/applyChequebook">Apply for a Cheque Book</a>
            <br><br>
        </td>
    </tr>
</table>

</body>
</html>