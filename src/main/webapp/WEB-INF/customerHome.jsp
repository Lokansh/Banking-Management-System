<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Dashboard</title>

<style>
h4 {
	font-family: Calibri;
	font-size: 30pt;
	font-style: normal;
	color: #6b5b95;
	text-align: center;
	cursor: pointer;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

.loginTable {
	margin-left: auto;
	margin-right: auto;
}

.errorMsg {
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

.pr {
	padding-right: 2em;
}

.selected {
	font-weight: bold;
	text-decoration: underline
}
</style>
</head>
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    if(session.getAttribute("username")==null)
    {
        response.sendRedirect("/user");
    }
%>
<h3>
	Welcome to Nova Bank
</h3>


<div class="${errorMsg==null ? "hide" : "errorMsg"}">${errorMsg}</div>

<h3></h3>
<div>

<a href="/cust-dash/balance"><h4>View Balance</h4></a>
<a href="/cust-dash/details"><h4>View details</h4></a>
<a href="/cust-dash/statement"><h4>View Statement</h4></a>
<a href="/cust-dash/transfer-home"><h4>Transfer Funds</h4></a>

</div>
</body>
</html>