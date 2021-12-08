<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Credit Card</title>
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
        .incrLimit{
            margin-left: auto;
            margin-right: auto;
        }
        td{
            text-align:center;
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
        .viewTable{
            margin-left: auto;
            margin-right: auto;
        }
        .container{text-align: center;}
    </style>
</head>
<body>

<div class="container">Welcome, ${sessionScope.username }
    <a href="ccServices">Home</a>
    <a href="${pageContext.request.contextPath }/logout">Logout</a>
</div>
<h3> My Credit Limit</h3>

<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>
<table class="viewTable">
    <tr>

        <td>
            <a href="checkCCLimit">Check My Credit Card Limit</a>
        </td>
    </tr>
    <tr>
        <td>
           <a href="applyCCLimit">Request to increase Credit Card Limit</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="fetchCCLimitRequest"> Check Credit Limit Increase Requests</a>
        </td>
    </tr>
    <tr>
        <div class="${CreditCardLimit==null ? "hide" : "successMsg"}">
               Your Credit Limit is ${CreditCardLimit}
        </div>
    </tr>
</table>
<div class="${Request==null ? "hide" : "successMsg"}">
    Your Request have been successfully Submited
</div>
<form:form method="post" action="${pageContext.request.contextPath }/applyCCLimit" >
    <table class="${ApplyLimitIncr==null ? "hide" : "incrLimit"}">

        <tr>
            <th>
                Enter Your current Salary:
            </th>
            <th>
                <input type="text" name="salary">
            </th>
        </tr>
        <tr>
            <td>

            </td>
            <td>
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>
</form:form>

<%--<h5 class="${reqList==null ? "hide" : "reqList"}">Credit Card Limit Increase Request</h5>--%>
<%--<table class="${reqList==null ? "hide" : "reqList"}">--%>
<%--    <tr>--%>
<%--        <td>--%>
<%--            Request Id--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            New Salary--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            Old Salary--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            Current CC limit--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            Status--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>--%>
<%--            <a href="applyCCLimit"> Apply to increase my Credit Card Limit</a>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <div class="${CreditCardLimit==null ? "hide" : "successMsg"}">--%>
<%--            Your Credit Limit is ${CreditCardLimit}--%>
<%--        </div>--%>
<%--    </tr>--%>
<%--</table>--%>

</body>
</html>