angular.module('myApp').factory('RestApi', function ($http, $log) {
    var global_error_handler;

    var RestApi = {
        get: get,
        post: post,
        set_error_handler: set_error_handler,
        post_json: post_json,
    };

    function get(url, params) {
        if (!params) {
            params = {};
        }
        var promise = $http({
            method: 'GET',
            url: url,
            params: params
        });
        if (global_error_handler) {
            promise.catch(global_error_handler);
        }
        return promise;
    }
    
    function post(url, params) {
    	$http.defaults.headers.post['Content-Type'] = 'application/json; charset=utf-8';
    	if (!params) {
            params = {};
        }
        var promise = $http({
            method: 'POST',
            url: url,
            data: JSON.stringify(params),
        });
        if (global_error_handler) {
            promise.catch(global_error_handler);
        }
        return promise;
    }

    function post_json(url, params){
        $http.defaults.headers.post['Content-Type'] = 'application/json; charset=utf-8';
        if(!params){
            params = {};
        }
        var promise = $http({
            method: 'POST',
            url: url,
            data: params,
        });
        if(global_error_handler){
            promise.catch(global_error_handler);
        }
        return promise;
    }
    
    function set_error_handler(f) {
        global_error_handler = f;
    }
    return RestApi;
});