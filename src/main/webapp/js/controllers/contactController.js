
cms.controller('ContactController', function($scope, $http,$window,restServices) {
	
	$scope.action = "";
	
	$scope.errorMessage = "";
	
	$scope.message = "";
	
	$scope.contactDto = {};
	
	$scope.getContactList = function() {
		$scope.errorMessage = "";
		restServices.getContactList(function(data){
			if(!data.error){
				$scope.errorMessage = "";
				$scope.userDto = data.payload;
			}
		});
	};
	
	$scope.addContact= function(action, email)
	{
		$scope.contactDto = {};
		$scope.contactDto.userEmail = email;
		$scope.action = action;
	}
	
	$scope.saveContact= function()
	{
		
		if($scope.contactDto.firstName == null || $scope.contactDto.firstName == "")
			$scope.errorMessage = "Please enter the first name";
		else if($scope.contactDto.lastName == null || $scope.contactDto.lastName == "")
			$scope.errorMessage = "Please enter the last name";
		else if($scope.contactDto.mobile == null)
			$scope.errorMessage = "Please enter a valid mobile number";
		else if($scope.contactDto.email == null || $scope.contactDto.email == "")
			$scope.errorMessage = "Please enter email";
		else
			{
			     restServices.checkContactExists($scope.contactDto, function(data) {
			    	 if(!data.error)
			    	 {
			    		 $('#addContactModal').modal('hide');
			    		 $scope.errorMessage = "";
			    		 restServices.saveContact($scope.contactDto, function(data){
			    				if(!data.error)
			    				{	
			    					$scope.contactDto = {};
			    					$scope.getContactList();
			    				}
			    			});
			    	}
			    	 else
			    		 {
			    		   $scope.errorMessage = data.statusMessage;
			    		 }
			     });
			}
	};
	
	
	
	
	$scope.editContact= function(action, userEmail, contactEmail)
	{
		$scope.contactDto.userEmail = userEmail;
		$scope.contactDto.email = contactEmail;
		$scope.action = action;
		restServices.findContactDetails($scope.contactDto, function(data){
			 if(!data.error){
				 $scope.contactDto = data.payload;
			 }
		});
	}
	
	
	$scope.removeContact = function(userEmail, contactId)
	{
		$scope.contactDto.userEmail = userEmail;
		$scope.contactDto.id = contactId;
		restServices.removeContact($scope.contactDto, function(data){
			if(!data.error)
			{
					$scope.getContactList();
			}
			else
				{
				$scope.message = data.statusMessage;
				}
		});
		
	};
	
});	

