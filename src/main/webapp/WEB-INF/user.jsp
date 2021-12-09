<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">

    <title> Nova Bank | User Page</title>

    <style>
        h3{
            font-family: Calibri;
            font-size: 30pt;
            font-style: normal;
            font-weight: bold;

            color:#D63301;

            text-align: center;
            text-decoration: underline
        }
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

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
             color: #2fd601;
             background-color: #d9ffba;
             background-image: url('https://i.imgur.com/GnyDvKN.png');
         }
        .hide {
            display: none;
        }

    </style>
</head>
<body>

<h3> Nova Bank</h3>
<%

    

    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

    if(session.getAttribute("username")==null||session.getAttribute("role")!="user")


    {
        response.sendRedirect("/login");
    }

%>


<div class="${successMsg==null ? "hide" : "successMsg"}">
    ${successMsg}
</div>



Welcome, ${sessionScope.username }
<br>

<a href="${pageContext.request.contextPath }/logout">Logout</a>

<a href="cust-dash/home"><h4>Profile Page</h4></a><br>
<a href="depositHome"><h4>Deposit Page</h4></a><br>
<a href="chequebookHome"><h4>Cheque Book Home</h4></a><br>
<a href="cardHome"><h4>Manage Cards</h4></a><br>
<a href="loanApplication"><h4>Apply for Loan</h4></a><br>
<a href="loanEligibility"><h4>Check Loan Eligibility</h4></a><br>
<a href="viewallApplication"><h4>View my Loan Applications</h4></a><br>
<a href="ccServices"><h4>Credit Card Services</h4></a><br>

</body>
</html>