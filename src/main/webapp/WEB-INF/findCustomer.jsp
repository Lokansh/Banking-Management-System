<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Dashboard</title>

    <style>
        h4{
            font-family: Calibri;
            font-size: 30pt;
            font-style: normal;
            
            color:#6b5b95;
            text-align: center;
            cursor: pointer;
			
        }
        
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

        .loginTable{
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
        .pr{
        	padding-right:2em;
        }
        .selected{
        	font-weight: bold;
            text-decoration: underline
        }
    </style>
</head>

<h4><span class="pr"><a href="/emp-dash/details">Employee Dashboard</a></span>


<span class="pr selected">Customer Details</span>


<span> <a href="/emp-dash/requests">Requests</a></span></h4>


<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>

<div>
<form method="post" action="${pageContext.request.contextPath }/emp-dash/cust-details/data">

    <table border="0" >
        <tr>
            <td>Customer ID</td>
            <td><input type="text" name="customerId"></td>
        </tr>
        
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Search"></td>
        </tr>
    </table>
</form>
</div>



</body>
</html>