var app = angular.module("App", []);
app.controller("Ctrl", function ($scope, $rootScope) {
    $scope.a2 = "allsdfjhsfd";
    $rootScope.a2 = "全局变量";
});
app.controller("Ctrl2", function ($scope, $rootScope) {
    $scope.num = 1;
    $scope.price = 9.99;
    $scope.total = $scope.num * $scope.price ;
});
app.controller("Ctrl3",function ($scope,$location) {
    $scope.citys = ["beijing","nanjing","chongqing"];
    $scope.myUrl =   $location.absUrl();
});
app.controller("Ctrl4",function ($scope,$timeout) {
    $scope.hi = "Hello Word";
    $timeout(function () {
        $scope.hi = "How are you today ? "
    },2000);
})
