angular.module('app.services', []).factory('LoginDto', function($resource) {
  return $resource('/login/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).factory('Category', function($resource) {
	  return $resource('/category/:id', { id: '@id' }, {
		    update: {
		      method: 'PUT'
		    }
		  });
}).factory('Employee', function($resource) {
	  return $resource('/employee/pendingReviews/:id', { id: '@id' }, {
		    update: {
		      method: 'PUT'
		    }
		  });
}).factory('FeedbackDto', function($resource) {
	  return $resource('/feedback/:id', { id: '@id' }, {
		    update: {
		      method: 'PUT'
		    }
		  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
