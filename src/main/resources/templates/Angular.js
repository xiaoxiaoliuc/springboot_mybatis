var app = angular.module("myApp",[]);
app.controller("myCtrl",function ($scope) {
    $scope.firstName="John";
    $scope.lastName="Doe";
});
var bpp = angular.module("bApp",[]);
bpp.directive("myDemo",function () {
    return{
        restrict:"C",
        template:"<h1>My &nbsp;  Demo</h1>"
    };
});