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

<h4>
	IMPS
</h4>


<div class="${errorMsg==null ? "hide" : "errorMsg"}">${errorMsg}</div>

<form method="post" action="${pageContext.request.contextPath }/cust-dash/transfer">

    <table>
       
        <tr>
            <td>Recipient ID</td>
            <td><input type="text" name="recipient-id"></td>
        </tr>
        <tr>
            <td>Amount</td>
            <td><input type="number" name="amount"></td>
        </tr>
         <tr>
            <td>Method</td>
            <td>
<div><input type="radio" name="methodType" value="imps" checked>IMPS</div>
<div><input type="radio" name="methodType" value="rtgs" >RTGS</div>
<div><input type="radio" name="methodType" value="neft" >NEFT</div>


</td>
        </tr>
       
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>

</body>
</html>