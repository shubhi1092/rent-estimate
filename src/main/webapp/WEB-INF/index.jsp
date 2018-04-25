<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/styles.css">
    <title>Rent Estimator App</title>
</head>
<body>

<form name="signupform" action="/user/" method="POST" style="border:1px solid #ccc">
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="firstName"><b>First Name</b></label>
        <input type="text" placeholder="First Name" name="firstName" required><br>

        <label for="lastName"><b>Last Name</b></label>
        <input type="text" placeholder="Last Name" name="lastName" required><br>

        <label for="emailAddress"><b>Email Address</b></label>
        <input type="text" placeholder="Email Address" name="emailAddress" required><br>

        <label for="phoneNumber"><b>Phone Number</b></label>
        <input type="text" placeholder="Phone Number" name="phoneNumber" required><br>

        <label for="address"><b>Address</b></label>
        <input type="text" placeholder="Adress" name="address" required><br>

        <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

        <div class="clearfix">
            <button type="button" class="cancelbtn">Cancel</button>
            <button type="submit" class="signupbtn">Sign Up</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="/resources/scripts/script.js"></script>
</body>
</html>