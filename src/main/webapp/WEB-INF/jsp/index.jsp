<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login and Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
            max-width: 600px;
            margin: 0 auto;
        }

        .container fieldset {
            border: 1px solid #ccc;
            padding: 20px;
        }

        /* Style for gender radio buttons */
        .gender-input {
            display: flex;
            align-items: center;
        }
    </style>
</head>
<body>
<div class="container">
    <!-- Login Fieldset -->
    <fieldset>
        <legend>Login</legend>
        <form action="login" method="post">
            <label for="loginUsername">Username:</label>
            <input type="text" id="loginUsername" name="loginUsername" required><br>
            <label for="loginPassword">Password:</label>
            <input type="password" id="loginPassword" name="loginPassword" required><br>
            <button type="submit">Login</button>
        </form>
    </fieldset>

    <!-- Registration Fieldset -->
    <fieldset>
        <legend>Register</legend>
        <form action="register" method="post">

            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required pattern="^[A-Z][a-z]{1,19}$"><br>

            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required pattern="^[A-Z][a-z]{2,19}$"><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required pattern="(?=.*[A-Z])(?=.*[\W_]).{8,}$"><br>

            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required pattern="(?=.*[A-Z])(?=.*[\W_]).{8,}$"><br>

            <label for="phone">Phone Number:</label>
            <input type="tel" id="phone" name="phone" required><br>

            <div class="gender-input">
                <span>Gender:</span>
                <label for="male">Male</label>
                <input type="radio" id="male" name="gender" value="M">
                <label for="female">Female</label>
                <input type="radio" id="female" name="gender" value="F">
            </div>
            <button type="submit">Register</button>

        </form>
        ${errors}
    </fieldset>
</div>
</body>
</html>
