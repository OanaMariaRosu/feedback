angular.module('app.controllers', []).controller('LoginController', function($scope, $state, popupService, $window, LoginDto) {
  $scope.loginDto = new LoginDto();
  
  $scope.login = function(loginDto) { 
	  var name = $scope.loginDto.userName
	  $scope.loginDto.$save(function() {
	      $state.go('pendingFeedback', { username: name }); 
	    });
	  };
}).controller('CategoriesListController', function($scope, $stateParams, Category) {
	$scope.categories = Category.query(); 
}).controller('FeedbackController', function($scope, $state, $stateParams, Category, FeedbackDto) {
	$scope.feedbackDto = new FeedbackDto();
	$scope.feedbackDto.fromUsername = $stateParams.fromUsername;
	$scope.feedbackDto.toUsername = $stateParams.toUsername;
	$scope.categories = Category.query(); 
	$scope.feedbackDto.scores = [];
	$scope.feedbackDto.comments = [];
	$scope.submitFeedback = function() { 
			console.log($scope.feedbackDto.fromUsername);
			//ar trebui sa fie completate toate casutele inainte de a da submit?
			//proceseaza arrayurile
			$scope.feedbackDto.$save(function() {
			      $state.go('pendingFeedback', { username: $stateParams.fromUsername }); 
			    });
		  };
}).controller('PendingFeedbackController', ['$scope', '$http', '$stateParams', 
	function($scope, $http, $stateParams, Employee) {
	$http.get("/employee/pendingReviews", {params:{"username": $stateParams.username}})
    						.then(function (response) { 
    							$scope.employees = response.data;
    							$scope.currentUsername = $stateParams.username;
    						})
}]).controller('FeedbackReceivedController', ['$scope', '$http', '$stateParams', 
	function($scope, $http, $stateParams) {
	$http.get("/employee/receivedReviews", {params:{"username": $stateParams.username}})
    						.then(function (response) { 
    							$scope.feedbacks = response.data;
    							$scope.currentUsername = $stateParams.username;
    						})
}]).controller('FeedbackGivenController', ['$scope', '$http', '$stateParams', 
	function($scope, $http, $stateParams) {
	$http.get("/employee/givenReviews", {params:{"username": $stateParams.username}})
    						.then(function (response) { 
    							$scope.feedbacks = response.data;
    							$scope.currentUsername = $stateParams.username;
    						})
}]).controller('ViewFeedbackController', ['$scope', '$http', '$stateParams', 
	function($scope, $http, $stateParams) {
	$http.get("/feedback", {params:{"id": $stateParams.id}})
    						.then(function (response) { 
    							$scope.feedback = response.data;
    							$scope.currentUsername = $stateParams.username;
    						})
}]);
