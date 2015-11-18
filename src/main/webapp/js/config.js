(function() {
	'use strict';
	angular.module('cinq')
	       .config(['$stateProvider','$urlRouterProvider',
	                function ($stateProvider, $urlRouterProvider) {
	    	   			$urlRouterProvider.otherwise( function($injector, $location) {
	    	   				var $state = $injector.get("$state");
	                            $state.go("cinq");
	                        }); 
	                        $stateProvider.state('cinq', {
		                        url: "/cinq",
		                        views : { 
	                                main: {
	                                	templateUrl:"views/home.html"
	                                }
		                        },  
		                        data: {
		                        	pageTitle: 'Say Greet to everyone!'
		                        }
	                        }) 
	                }   
	       ]);
}());