<script src="js/services/passwordStrength.js"></script>
<!-- ======== @Region: #content ======== -->
<div id="signUpContent" ng-controller="SignupController">
	<div class="container">
		<!-- Sign Up form -->
		<div ng-show="confirmationSection == false">
			<form class="form-login form-wrapper form-medium" role="form" name="activateForm">
				<p class="alert-danger">{{errorMessage}} </p>
				<h3 class="title-divider">
					<span>Sign Up</span>
				</h3> 
				<div class="form-group">
					<label class="sr-only" for="activate-firstName">First Name</label> <input type="text"
						class="form-control" id="firstName" ng-model="userDto.firstName"
						name="firstName" placeholder="First Name" required>
						<span ng-show="activateForm.firstName.$error.required" >Please enter your first name.</span>
				</div>
				<div class="form-group">
					<label class="sr-only" for="activate-lastName">Last Name</label> <input type="text"
						class="form-control" id="lastName" ng-model="userDto.lastName"
						name="lastName" placeholder="Last Name" required>
						<span ng-show="activateForm.lastName.$error.required">Please enter your last name.</span>
				</div>
				<div class="form-group">
					<label class="sr-only" for="activate-lastName">Email</label> <input type="email"
						class="form-control" id="email" ng-model="userDto.email"
						name="lastName" placeholder="Email" required>
						<span ng-show="activateForm.email.$error.required">Please enter your email.</span>
				</div>
				<div class="form-group">
					<label class="sr-only" for="activate-password">Password</label> <input type="password"
						class="form-control" id="password" ng-model="userDto.password"
						name="password"  placeholder="Password"  required>
						<div id="messages"></div>
						<span ng-show="activateForm.password.$error.required">Please enter password.</span>
				</div>
				<div class="form-group">
					<label class="sr-only" for="activate-password">Confirm Password</label> <input type="password"
						class="form-control" id="confirmPassword" ng-model="confirmPassword"
						name="confirmPassword"  placeholder="Confirm Password" required>
						<span ng-show="activateForm.confirmPassword.$error.required">Please re-enter password to confirm.</span>
						
				</div>
				<button class="btn btn-primary" id="idButton" type="button" ng-click="signup()">Sign Up</button>
				| <small>Already registered ? <a href="login">Login here</a>.</small>
			</form>
		</div>
		
		<div ng-show="confirmationSection == true">
		<form class="form-login form-wrapper form-medium" role="form">
				<div class="form-group">
								<h4> Thank you for registering to Contact Management System</h4>
								<p> Please <a href="login">login</a> to proceed. </p>
				</div>
			</form>
		</div>
	</div>
</div>


