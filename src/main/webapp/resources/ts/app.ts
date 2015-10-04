
 /// <reference path="../typings/react/react.d.ts"/>
 /// <reference path="../typings/requirejs/require.d.ts"/>


 require(
     [
         'react',
         'jquery'
     ],
     (React, $) => {
         'use strict';

     }
 );

 import React= require('react');


 function lol() { prompt("lol")}
 class Greeter {
     constructor(public greeting: string) { }
     greet() {
         return "<h1>" + this.greeting + "</h1>";
     }
 };

 var greeter = new Greeter("Hello, world!")

 document.body.innerHTML = greeter.greet()

 React.render(
     React.createElement('h1', null, 'Hello, world!'),
     document.getElementById('example')
 );



