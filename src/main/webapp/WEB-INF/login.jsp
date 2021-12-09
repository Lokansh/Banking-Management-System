<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Sign In | NovaBank </title>

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
        h4{
            font-family: Calibri;
            font-size: 15pt;
            font-style: normal;
            font-weight: bold;
            color:#6b5b95;
            text-align: center;
            text-decoration: underline
        }
        h5{
            font-family: Calibri;
            font-size: 10pt;
            font-style: normal;
            color:#6b5b95;
            text-align: center;
            text-decoration: underline
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
        a{
            text-align: center;
            margin: 0 auto;
            display: block;
        }

    </style>
</head>
<%

    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    if(session.getAttribute("username")!=null && session.getAttribute("role")=="user")
    {
        response.sendRedirect("/user");
    }
    else if(session.getAttribute("username")!=null && session.getAttribute("role")=="admin"){
        response.sendRedirect("/admin");
    }
    else if(session.getAttribute("username")!=null && session.getAttribute("role")=="employee"){
        response.sendRedirect("/employeeDashboard");
    }

%>


<h3>Welcome to Nova Bank</h3>
<h4>User Login Page</h4>

<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>


<form method="post" action="${pageContext.request.contextPath }/login">

    <table border="0" class="loginTable" >
        <tr>
            <td>Username</td>
            <td><input type="text" name="userLoginID"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td><br>
            <td><a href="forget">Forget Password?</a></td>
        </tr>

        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Login"></td>
        </tr>
    </table>
</form>
<h4>First Time User</h4>

<a href="signup">Register</a><br>

</body>
</html>