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
}]).controller('FeedbackChartController', ['$scope', '$http', '$stateParams', 
	function($scope, $http, $stateParams) {
	var gaugeOptions = {
		    chart: {
		        type: 'solidgauge'
		    },

		    title: null,

		    pane: {
		        center: ['50%', '85%'],
		        size: '140%',
		        startAngle: -90,
		        endAngle: 90,
		        background: {
		            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
		            innerRadius: '60%',
		            outerRadius: '100%',
		            shape: 'arc'
		        }
		    },

		    tooltip: {
		        enabled: false
		    },

		    // the value axis
		    yAxis: {
		        stops: [
		            [0.1, '#DF5353'], // green
		            [0.5, '#DDDF0D'], // yellow
		            [0.9, '#55BF3B'] // red
		        ],
		        lineWidth: 0,
		        minorTickInterval: null,
		        tickAmount: 2,
		        title: {
		            y: -70
		        },
		        labels: {
		            y: 16
		        }
		    },

		    plotOptions: {
		        solidgauge: {
		            dataLabels: {
		                y: 5,
		                borderWidth: 0,
		                useHTML: true
		            }
		        }
		    }
		};
	$http.get("/feedback", {params:{"id": $stateParams.id}})
    						.then(function (response) { 
    							$scope.teamChart = false;
    							$scope.feedback = response.data;
    							$scope.currentUsername = $stateParams.username;
    							for (var i = 0; i < $scope.feedback.ratings.length; i++){
    						        var obj = $scope.feedback.ratings[i];
    						        var chartRpm = Highcharts.chart(String(obj.category.id), Highcharts.merge(gaugeOptions, {
    						    	    yAxis: {
    						    	        min: 0,
    						    	        max: 5,
    						    	        title: {
    						    	            text: obj.category.name
    						    	        }
    						    	    },

    						    	    series: [{
    						    	        name: obj.category.name,
    						    	        data: [obj.score],
    						    	        dataLabels: {
    						    	            format: '<div style="text-align:center"><span style="font-size:25px;color:' +
    						    	                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y:.1f}</span><br/>'+'</div>'
    						    	        },
    						    	        tooltip: {
    						    	            valueSuffix: ' score'
    						    	        }
    						    	    }]

    						    	}));
    						    }
    						});
}]).controller('TeamFeedbackChartController', ['$scope', '$http', '$stateParams', 
	function($scope, $http, $stateParams) {
	var categories = ['Technical Expertise', 'Analytical Thinking', 'Work Quality', 'Autonomy', 'Learning and Adaptability',
		'Time Management', 'Communication Skills', 'Team Work'];
	$http.get("/employee/teamFeedbacks", {params:{"username": $stateParams.username}})
    						.then(function (response) { 
    							$scope.teamChart = true;
    							$scope.teamFeedbacks = response.data;
    							$scope.currentUsername = $stateParams.username;
    							Highcharts.chart('container', {

    							    title: {
    							        text: 'Feedback given by team'
    							    },

    							    yAxis: {
    							        title: {
    							            text: 'Score'
    							        },
    						        	min: 0,
    						        	max: 6
    							    },
    							    legend: {
    							        layout: 'vertical',
    							        align: 'right',
    							        verticalAlign: 'middle'
    							    },

    							    xAxis: {
    							        categories: categories
    							    },

    							    series: $scope.teamFeedbacks

    							});
    						})
}]);
