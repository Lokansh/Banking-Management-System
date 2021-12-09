<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Dashboard</title>

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

<h4>
	<span class="pr"><a href="/emp-dash/details">Employee
			Dashboard</a></span> <span class="pr"><a href="/emp-dash/cust-details">Customer
			Details</a></span> <span class="selected"> Requests</span>
</h4>


<div class="${errorMsg==null ? "hide" : "errorMsg"}">${errorMsg}</div>


<div>Auto Approved Requests</div>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
	<c:forEach items="${requests}" var="request">
		<tr>
			<td><c:out value="${request.getRequestId()}" /></td>
			<td><c:out value="${request.getCustomerId()}" /></td>
			<td><c:out value="${request.getRequestData()}" /></td>
			<td><c:out value="${request.getStatus()}" /></td>
		</tr>
	</c:forEach>
</table>
<a href="/emp-dash/requests"><button>Back</button></a>
<div></div>
</body>
</html>