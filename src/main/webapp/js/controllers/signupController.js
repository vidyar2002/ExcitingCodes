var signupCtrl = cms.controller('SignupController', function($scope, $http,$modal,restServices) {
	
	$scope.confirmationSection = false;
	$scope.userDto = {};
	
	$scope.signup = function() {
		
		if($scope.userDto.firstName == null)
			$scope.errorMessage = "Please enter your first name";
		else if($scope.userDto.lastName == null)
			$scope.errorMessage = "Please enter your last name";
		else if($scope.userDto.email == null)
			$scope.errorMessage = "Please enter your email id";
		else
			{
				
			restServices.checkEmailExists($scope.userDto.email, function(data) {
			
			if(data.error)
			{
				$scope.errorMessage = "User already registered with same email id";
			} 
			else
			{
				if($scope.userDto.password == null)
					$scope.errorMessage = "Please enter password";
				else if($scope.confirmPassword == null)
					$scope.errorMessage = "Please re-type password to confirm";
				else if($scope.userDto.password != $scope.confirmPassword)
					$scope.errorMessage = "Passwords do not match";
				else
					{
						$scope.errorMessage = "";
					restServices.addUser($scope.userDto, function(data) {
						  
						  if(data.statusMessage == "Duplicate")
						  {
							  $scope.confirmationSection = false;
							  $scope.errorMessage = "User already registered with same email id";
						  }
						  else{
							  $scope.confirmationSection = true;
						  }
						  
						  
					  });
					}
				
			}
		});
	}
	};
	
}); 
	
