var app=angular.module("myApp",['ngRoute',,'ngCookies']);
     app.run(function($cookies,$http,$scope){
	$scope.mcookie=$cookies.get("emailId");
	$scope.pcookie=$cookies.get("password");
	 $http.post('/vaildate',$scope.mcookie,$scope.pcookie).then(successCallback,errorCallback);
});
