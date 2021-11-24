<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Loan Application</title>

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
        h2{
            font-family: Calibri;
            color:#6b5b95;
            text-align: center;
            text-decoration: underline
        }
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

        .applyLoanTable{
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
    </style>

</head>
<body>

<div>Welcome, ${sessionScope.username }
    <a href="user">Home</a>
    <a href="${pageContext.request.contextPath }/logout">Logout</a>
</div>
<div class="${successMsg==null ? "hide" : "successMsg"}">
    ${successMsg}
</div>
<div class="${errorMsg==null ? "hide" : "errorMsg"}">
    ${errorMsg}
</div>
<h2>Loan Application</h2>
<form:errors path="loan.*"/>
<form:form  method="post" action="${pageContext.request.contextPath }/loanApplication">

    <table border="0" class="applyLoanTable" >


        <tr>
            <td>First Name</td>
            <td>
                <input type="text" name="firstName">
            </td>
        </tr>

        <tr>
            <td>Last Name</td>
            <td>
                <input type="text" name="lastName">
            </td>
        </tr>

        <tr>
            <td>Address Line 1</td>
            <td>
                <input type="text" name="address1">
            </td>
        </tr>

        <tr>
            <td>Address Line 2</td>
            <td>
                <input type="text" name="address2">
            </td>
        </tr>

        <tr>
            <td>City</td>
            <td>
                <input type="text" name="city">
            </td>
        </tr>

        <tr>
            <td>ZipCode</td>
            <td>
                <input type="text" name="zipCode">
            </td>
        </tr>

        <tr>
            <td>Contact Number</td>
            <td>
                <input type="text" name="contactNumber">
            </td>
        </tr>

        <tr>
            <td>Email Address</td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>

        <tr>
            <td>SIN number</td>
            <td>
                <input type="number" name="sin">
            </td>
        </tr>

        <tr>
            <td>Age</td>
            <td>
                <input type="text" name="age">
            </td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input type="text" name="salary"></td>
        </tr>
        <tr>
            <td>Amount Required</td>
            <td><input type="text" name="loanamount"></td>
        </tr>
        <tr>
            <td>Loan Type</td>
            <td><select name="loanType">
                <option value="">Loan Type</option>
                <option value="EducationLoan">Education Loan</option>
                <option value="VehicleLoan">Vehicle Loan</option>
                <option value="PersonalLoan">Personal Loan</option>
                <option value="HomeLoan">Home Loan</option>
                <option value="AgriculturalLoan">Agricultural Loan</option>
                <option value="LoanAgainstInsurancePolicies">Loan Against Insurance Policies</option>
                <option value="LoanAgainstBankFDs">Loan Against Bank FDs</option>
                <option value="LoanAgainstMutualFundsOrShares">Loan Against Mutual Funds Or Shares</option>

            </select></td>

            <td><a href="loantypes">Know type of loans we offer</a></td>
        </tr>


        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>