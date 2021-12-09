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
<div>Welcome, ${sessionScope.username }


<a href="${pageContext.request.contextPath }/logout">Logout</a>
</div>
<div><a href="loanApplication">Apply for Loan</a></div>
<div><a href="loanEligibility">Check Loan Eligibility</a></div>
<div><a href="viewallApplication">View my Loan Applications</a></div>
<div><a href="ccServices">Credit Card Services</a></div>



</body>
</html>