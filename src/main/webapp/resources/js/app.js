/// <reference path="../typings/react/react.d.ts"/>
/// <reference path="../typings/requirejs/require.d.ts"/>
define(["require", "exports", 'react'], function (require, exports, React) {
    require([
        'react',
        'jquery'
    ], function (React, $) {
        'use strict';
    });


    function lol() { prompt("lol"); }
    var Greeter = (function () {
        function Greeter(greeting) {
            this.greeting = greeting;
        }
        Greeter.prototype.greet = function () {
            return "<h1>" + this.greeting + "</h1>";
        };
        return Greeter;
    })();
    ;
    var greeter = new Greeter("Hello, world!");
    document.body.innerHTML = greeter.greet();
    React.render(React.createElement('h1', null, 'Hello, world!'), document.getElementById('example'));
});
//# sourceMappingURL=app.js.map