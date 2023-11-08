<!DOCTYPE html>
<html lang="no">
<head>
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
	<title>Participant registration</title>
</head>

<body>
	<h2>Participant registration</h2>
	<p style="color:red;">${registrationViewMessage}</p>
	<form id="registration" action="registration" onsubmit="return validateForm();" method="post">
		<fieldset>
			<label>First name</label>
			<input id="firstname" type="text" name="firstname" value="${registration.firstname}"/>
			
			<label>Last name</label>
			<input id="lastname" type="text" 	name="lastname" value="${registration.lastname}" />
			
			<label>Phone (8 digits)</label>
			<input id="phone" type="text" name="phone" value="${registration.phone}" />
			
			<label>Password</label>
			<input id="password" type="password" name="password" value="${registration.password}"/>
			<label>Repeat password</label>
			<input id="repeatPassword" type="password" name="repeatPassword" value="${registration.repeatPassword}" />
			
			<label>Gender</label> 
			<input type="radio" name="gender" value="Male" value="${registration.gender}" checked/>Male
			<input type="radio" name="gender" value="Female" value="${registration.gender}" />Female
			     
			<br><br><button type="submit">Register</button>
			
			<br><br><a href="login">Already registered? Login here.</a>
		</fieldset>
		<!-- Pretty messy mb -->
		<script type="text/javascript">
		function validateForm() {
			function validateFirstName() {
				const firstnameRegExp = /^[A-ZÆØÅ][A-ZÆØÅa-zæøå\- ]+$/;
				const firstname = document.getElementById("firstname");
				
				if(isEmpty(firstname.value)) {
					firstname.setCustomValidity("First name is required");
					firstname.reportValidity();
					return false;
				}
				if(firstname.value.length < 2 && firstname.value.length > 20) {
					lastname.setCustomValidity("First name must be between 2 and 20 characters");
					firstname.reportValidity();
					return false;
				}
				if(!firstnameRegExp.test(firstname.value)) {
					lastname.setCustomValidity("First name can only contain letters A-å, - and space");
					firstname.reportValidity();
					return false;
				}
				
				firstname.setCustomValidity("");
				firstname.reportValidity();
				return true;
			
			}
			
			function isEmpty(value) {
				return value == null || value == "";
			}
			
			function validateLastName() {
				const lastnameRegExp = /^[A-ZÆØÅ][A-ZÆØÅa-zæøå\-]+$/;
				const lastname = document.getElementById("lastname")
				
				if(isEmpty(lastname.value)) {
					lastname.setCustomValidity("Last name is required");
					lastname.reportValidity();
					return false;
				}
				if(lastname.value.length < 2 && lastname.value.length > 20) {
					lastname.setCustomValidity("Last name must be between 2 and 20 characters");
					lastname.reportValidity();
					return false;
				}
				if(!lastnameRegExp.test(lastname.value)) {
					lastname.setCustomValidity("Last name can only contain letters A-å and -");
					lastname.reportValidity();
					return false;
				}
		
				lastname.setCustomValidity("");
				lastname.reportValidity();
				return true;
			}
			
			function validatePhone() {
				const phoneRegExp = /^\d{8}$/;
				const phone = document.getElementById("phone");
				
				if(isEmpty(phone.value)) {
					phone.setCustomValidity("Phone is required");
					phone.reportValidity();
					return false;
				}
				if(!phoneRegExp.test(phone.value)) {
					phone.setCustomValidity("Phone must be 8 digits");
					phone.reportValidity();
					return false;
				}
				
				phone.setCustomValidity("");
				phone.reportValidity();
				return true;
			}
			
			function validatePassword() {
				const password = document.getElementById("password");
				
				if(isEmpty(password.value)) {
					password.setCustomValidity("Password is required");
					password.reportValidity();
					return false;
				}
				if(password.value.length < 4) {
					password.setCustomValidity("Password must be atleast 4 characters");
					password.reportValidity();
					return false;
				}
				
				password.setCustomValidity("");
				password.reportValidity();
				return true;
			}
			
			function validateRepeatPassword() {
				const repeatPassword = document.getElementById("repeatPassword");
				const password = document.getElementById("password");
				
				if(isEmpty(repeatPassword.value)) {
					repeatPassword.setCustomValidity("Repeat password is required");
					repeatPassword.reportValidity();
					return false;
				}
				if(isEmpty(password.value) || password.value !== repeatPassword.value) {
					repeatPassword.setCustomValidity("Repeat password does not match password");
					repeatPassword.reportValidity();
					return false;
				}
				
				repeatPassword.setCustomValidity("");
				repeatPassword.reportValidity();
				return true;
			}
			
			function validateGender(maleInput, femaleInput) {
				const gender = document.getElementsByName('gender');

				let anyChecked = false;
				
				for(let i = 0, length = gender.length; i < length; i++) {
					if (gender[i].checked) {
						anyChecked = true;
				   		break;
				  	}
				}
				
				for(let i = 0, length = gender.length; i < length; i++) {
					if (anyChecked) {
						gender[i].setCustomValidity("");
						gender[i].reportValidity();
				  	} else {
						gender[i].setCustomValidity("Gender must be either Male or female");
						gender[i].reportValidity()
				  	}
				}

				if(anyChecked) {
					return true;
				}
				
				return false;
			}
			
			valid = validateFirstName() && validateLastName() && validatePhone() && validatePassword() && validateRepeatPassword() && validateGender();
			
			console.log(valid);
			
			return valid;
		}
		</script>
	</form>
	
	
</body>
</html>
