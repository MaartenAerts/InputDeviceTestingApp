
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
/*
 //window.addEventListener("load", eventWindowLoaded, false);
 //function eventWindowLoaded() {
     drawCircle();
 //}




 // Cirkel tekenen
function drawCircle() {
    var canvas = (<HTMLCanvasElement>document.getElementById('myCanvas'));
    var context;
    context = canvas.getContext('2d');
    context.beginPath();
    context.fillStyle = 'green';
    context.fill();
    context.arc(95,50,40,0,2*Math.PI);
    context.strokeStyle = '#003300';
    context.stroke();

}

 var context = canvas.getContext('2d');
 var centerX = canvas.clientWidth / 2;
 var centerY = canvas.clientHeight / 2;
 var radius = 70;

 context.beginPath();
 context.arc(centerX,centerY,radius,0,2*Math.PI);
 context.fillStyle = 'green';
 context.fill();
 context.lineWidth= 5;
 context.strokeStyle = '#003300';
 context.stroke();

*/



