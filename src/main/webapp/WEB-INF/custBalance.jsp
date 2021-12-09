<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer Dashboard</title>

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

<h4><span class="pr">Balance</span></h4>


<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>

<div>
ID   :    ${sessionScope.custSearchId }
</div>

<div>
Account   :    ${sessionScope.account }
</div>

<div>
Balance   :    CAD ${sessionScope.balance }
</div>


<div>
<a href="/cust-dash/home"><button>Back</button></a>
</div>
</body>
</html>