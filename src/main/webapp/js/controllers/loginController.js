cms.controller('LoginController', function($scope, $http,$window,restServices) {
	$scope.userDto = {};
	$scope.login = function()
	{
		//alert("before calling rest");
		//var url = "/rest/login/authenticateUser?email="+$scope.userDto.email+"&password="+$scope.userDto.password;
		//$http.get(url).success($scope.userDto, function (data) {
		restServices.authenticateUser($scope.userDto, function(data) {
			//alert("after calling rest");
			if(!data.error)
				{
				   $scope.userDto = data.payload;
				   $window.location.href="home";
				} 
			else
				{
				  $scope.errorMessage = "Authentication failed. Please try again."
				}
		});
	};
});
	
