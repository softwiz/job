(function (ctx) {
    ctx.doc = ctx.document;

    ctx.isNullOrWhiteSpace = function (str) {
        return str === undefined || str === null || str.match(/^ *$/) !== null || str.match(/^　*$/) !== null;
    };

    ctx.contains = function (str, targetStr) {
        if (!str)
            return false;
        return -1 !== str.indexOf(targetStr, 0);
    };


    ctx.Common = (function () {

    	var handleAjaxError = function (data, errorAlert, errorCallback) {

            if (errorAlert) {
                if (typeof data.message === "undefined") {
                    alert('エラーです。共通エラーメッセージ必要');
                } else {
                   	alert(data.message);
                }
            }
            if (errorCallback) {
                errorCallback(data);
            }
        };

        var ajaxComplete = function (completeCallback) {

            if (completeCallback)
                completeCallback();
        };

        return {

            asyncConnect: function (arg) {
                var asyncConnectCore = function () {

                    $.ajax({
                        type: arg.type,
                        url: arg.url,
                        data: arg.data,
                        dataType: "json",///取得するデータの形により変わる。text/json..など
                        contentType: "application/x-www-form-urlencoded",
                        success: function (response, xhr) {
                        	arg.success(response);
                            if (arg.complete)
                                arg.complete();
                        },
                        error: function (type, xhr) {
                        	arg.error(type, xhr);
                            if (arg.complete)
                                arg.complete();
                        },
                        timeout: arg.timeout ? arg.timeout : 15000,
                    });
                };
                asyncConnectCore();
            },

            get: function (url, data) {
                location.href = Common.buildGetRequestUrl(url, data);
            },

            asyncGet: function (url, callback, options) {
                /// <summary>非同期GETリクエストでJSONを取得します</summary>
                /// <param name="url" type="Object">URL</param>
                /// <param name="callback" type="Object">成功時のコールバック</param>
                /// <param name="errorAlert" type="Number" optional="true">(optional)汎用のエラーアラート表示(デフォルト:true)</param>
                /// <param name="errorCallback" type="Object" optional="true">(optional)失敗時のコールバック関数(デフォルト:無し)</param>

                if (!options)
                    options = {};
                var errorAlert = options.errorAlert == false ? false : true;
                var errorCallback = options.errorCallback ? options.errorCallback : null;
                var completeCallback = options.complete ? options.complete : null;

                this.asyncConnect({
                    type: "GET",
                    url: url,
                    data: {},
                    success: function (response) {
                    	//通常、応答データのhasErrorフラグでエラー判定する
                        if (response.hasError) {
                            handleAjaxError(response, errorAlert, errorCallback);
                        } else if (callback) {
                            callback(response);
                        }
                    },
                    error: function (type, xhr) {
                        //可能なら本文をパースし、パースエラーは封殺
                        var jsonResponse = {};
                        try {

                            jsonResponse = JSON.parse(xhr.response);
                        } catch (e) {
                        	console.log(e);
                        }
                        jsonResponse.hasError = true;
                        callback = null;
                        //共通エラー処理
                        handleAjaxError(jsonResponse, errorAlert, errorCallback);
                    },
                    complete: function () {
                        ajaxComplete(completeCallback);
                    },
                });
            },

            asyncPost: function (url, data, callback, options) {
                /// <summary>非同期POSTリクエストでJSONを取得します</summary>
                /// <param name="url" type="Object">URL</param>
                /// <param name="data" type="Object">Formデータ</param>
                /// <param name="callback" type="Object">成功時のコールバック</param>
                /// <param name="errorAlert" type="number">(optional)汎用のエラーアラート表示(デフォルト:true)</param>
                /// <param name="errorCallback" type="Object">(optional)失敗時のコールバック。引数オブジェクトは必ず hasError:true を持ちます。(デフォルト:無し)</param>

                if (!options)
                    options = {};
                var errorAlert = options.errorAlert == false ? false : true;
                var errorCallback = options.errorCallback ? options.errorCallback : null;
                var completeCallback = options.complete ? options.complete : null;

                this.asyncConnect({
                    type: "POST",
                    url: url,
                    data: data,
                    success: function (response) {
                        //通常、応答データのhasErrorフラグでエラー判定する
                        if (response.hasError) {
                            handleAjaxError(response, errorAlert, errorCallback);
                        } else if (callback) {
                            callback(response);
                        }
                    },
                    error: function (type, xhr) {
                    	alert(xhr);
                        //可能なら本文をパースし、パースエラーは封殺
                        var jsonResponse = {};
                        try {
                            jsonResponse = JSON.parse(xhr.response);
                        } catch (e) {
                        }
                        jsonResponse.hasError = true;
                        callback = null;

                        //共通エラー処理
                        handleAjaxError(jsonResponse, errorAlert, errorCallback);
                    },
                    complete: function () {
                        ajaxComplete(completeCallback);
                    },
                });
            },

            post: function (url, data, options) {
                if (!options)
                    options = {};
                var errorAlert = options.errorAlert == false ? false : true;
                var errorCallback = options.errorCallback ? options.errorCallback : null;
                var useTokenTag = options.useTokenTag == false ? false : true;

                var csrfUrl = "";//csrfURL必要

                if (!data)
                    data = {};

                var csrfSuccessCallback = function () {
                    var form = document.createElement("form");
                    form.setAttribute("action", url);
                    form.setAttribute("method", "POST");
                    form.style.display = "none";
                    document.body.appendChild(form);

                    for (var name in data) {
                        var input = document.createElement("input");
                        input.setAttribute("type", "hidden");
                        input.setAttribute("name", name);
                        input.setAttribute("value", data[name]);
                        form.appendChild(input);
                    }

                    form.submit();
                };

                if (options.ignoreCsrf) {
                    csrfSuccessCallback();
                    return;
                }

                if (useTokenTag) {

                    var token = document.getElementById("csrf_token");
                    if (token) {
                        data.csrfToken = token.attributes['data-token'].value;
                        csrfSuccessCallback();
                        return;
                    }
                }

                this.asyncConnect({
                    type: "POST",
                    url: csrfUrl,
                    success: function (response) {
                        //通常、応答データのhasErrorフラグでエラー判定する
                        if (response.hasError) {
                            handleAjaxError(response, errorAlert, errorCallback);
                            ajaxComplete(null);
                        } else {
                            if (data && response.token) {
                                data.csrfToken = response.token;
                            }

                            csrfSuccessCallback();
                        }
                    },
                    error: function (type, xhr) {
                        //可能なら本文をパースし、パースエラーは封殺
                        var jsonResponse = {};
                        try {
                            jsonResponse = JSON.parse(xhr.response);
                        } catch (e) {
                        }
                        jsonResponse.hasError = true;

                        handleAjaxError(jsonResponse, errorAlert, errorCallback);
                        ajaxComplete(null, loading);
                    },
                });
            },

            buildGetRequestUrl: function (url, data) {
                /// <summary>GETリクエスト用のURLを作成する</summary>
                /// <param name="url" type="Object">URL</param>
                /// <param name="data" type="Object">Getデータ</param>
                if (data == null) return url;

                var params = [];
                Object.keys(data).forEach(function (key) {
                    params[params.length] = key + "=" + data[key];
                });

                return url + "?" +  params.join("&");
            }
        };
    })();

})(this);