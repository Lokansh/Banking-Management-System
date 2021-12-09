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
	Statement
</h4>


<div class="${errorMsg==null ? "hide" : "errorMsg"}">${errorMsg}</div>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
<tr>
			<td>Request ID</td>
			<td>Amount</td>
			<td>Type</td>
			<td>Sender/Receiver</td>
			<td>Mode</td>
			<td>Time Stamp</td>
		</tr>
	<c:forEach items="${statements}" var="stm">
		<tr>
		<td><c:out value="${stm.getId()}" /></td>
			<td><c:out value="${stm.getAmount()}" /></td>
			<td><c:out value="${stm.getType()}" /></td>
			<td><c:out value="${stm.getFromToAccount()}" /></td>
			<td><c:out value="${stm.getMode()}" /></td>
			<td><c:out value="${stm.getTimeStamp()}" /></td>
		</tr>
	</c:forEach>
</table>
<a href="/cust-dash/home"><button>Back</button></a>
<div></div>
</body>
</html>