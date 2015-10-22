/// <reference path="../typings/react/react.d.ts" />
///<reference path="../typings/react-dom/react-dom.d.ts"/>

import * as React from 'react'
import * as ReactDom from 'react-dom'
import 'testjoris'
class Test extends React.Component<propke,stateje>
{
    constructor(props) {
        super(props);

        this.state = {
            x: 0,
            y: 0
        }
    }

    render() {
        let radiusBigCircle = Math.min(this.props.width, this.props.height) / 2.5;
        let strokeWidthBigCircle = radiusBigCircle / 50;
        let cxBigCircle = this.props.width / 2;
        let cyBigCircle = this.props.height / 2;

        /*   var circles = new Array();
         var circle = function(id, x, y, radius) {
         this.left = x - radius;
         this.top = y - radius;
         this.right = x + radius;
         this.bottom = y + radius;
         };*/

        let radius = radiusBigCircle/10;

        let aantalCirkels = 15;
        let graden = 360/aantalCirkels;
        let xCircleArray = new Array();
        let yCircleArray = new Array();

        let tellerVoorHelft = 0;
        let tellerNaHelft = 0;
        let circleID = 0;
        let IdArray = new Array();

        for(var i = 1; i <= aantalCirkels;i++) {
            let radian = (graden * (i - 1)) * (Math.PI / 180);
            xCircleArray[i] = radiusBigCircle * Math.cos(radian) + cxBigCircle;
            yCircleArray[i] = radiusBigCircle * Math.sin(radian) + cyBigCircle;
            // let xCircle = radiusBigCircle * Math.cos(radian) + cxBigCircle;
            // let yCircle = radiusBigCircle * Math.sin(radian) + cyBigCircle;

            if (i <= ((aantalCirkels + 1) / 2)) {
                circleID = tellerVoorHelft + 1;
                tellerVoorHelft += 2;
            } else {
                circleID = tellerNaHelft + 2;
                tellerNaHelft += 2;
            }
            IdArray[i] = circleID;

            /*     var circle = new circle(circleID,xCircle,yCircle,radius);
             circles.push(circle);
             circles[i].Id = circleID;
             }

             {this.renderCircle(circles[1].id, circles[1].x, circles[1].y,radius,strokeWidthBigCircle)}
             */
        }

        var clickedX = event.pageX;
        var clickedY = event.pageY;

        for (var i = 1; i < 15+1; i++) {
            if (clickedX < xCircleArray[i]+radius){ //&& clickedX > xCircleArray[i]-radius && clickedY > yCircleArray[i]-radius && clickedY < yCircleArray[i]+radius) {
                alert ('clicked number ' + (i));
            }
        }

        return <svg ref="svg" {...this.props} onMouseMove={this.handleMouseMove.bind(this)}>
            {this.renderBigCircle(cxBigCircle,cyBigCircle,radiusBigCircle,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[1], xCircleArray[1], yCircleArray[1],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[2], xCircleArray[2], yCircleArray[2],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[3], xCircleArray[3], yCircleArray[3],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[4], xCircleArray[4], yCircleArray[4],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[5], xCircleArray[5], yCircleArray[5],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[6], xCircleArray[6], yCircleArray[6],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[7], xCircleArray[7], yCircleArray[7],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[8], xCircleArray[8], yCircleArray[8],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[9], xCircleArray[9], yCircleArray[9],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[10], xCircleArray[10], yCircleArray[10],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[11], xCircleArray[11], yCircleArray[11],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[12], xCircleArray[12], yCircleArray[12],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[13], xCircleArray[13], yCircleArray[13],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[14], xCircleArray[14], yCircleArray[14],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[15], xCircleArray[15], yCircleArray[15],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[16], xCircleArray[16], yCircleArray[16],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[17], xCircleArray[17], yCircleArray[17],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[18], xCircleArray[18], yCircleArray[18],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[19], xCircleArray[19], yCircleArray[19],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[20], xCircleArray[20], yCircleArray[20],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[21], xCircleArray[21], yCircleArray[21],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[22], xCircleArray[22], yCircleArray[22],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[23], xCircleArray[23], yCircleArray[23],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[24], xCircleArray[24], yCircleArray[24],radius,strokeWidthBigCircle)}
            {this.renderCircle(IdArray[25], xCircleArray[25], yCircleArray[25],radius,strokeWidthBigCircle)}

        </svg>;
    }

    renderBigCircle(cxBigCircle, cyBigCircle, radiusBigCircle, strokewidthBigCircle) {
        return <circle cx={cxBigCircle} cy={cyBigCircle} r={radiusBigCircle-10} fill="#ccffff" stroke="black" strokeWidth={"1"}/>;
    }

    renderCircle(id, cx, cy, radius, strokewidth) {
        /*var circle = function() {
         this.left = cx - radius;
         this.top =  cy - radius;
         this.right = cx + radius;
         this.bottom = cy + radius;
         }*/
        //  circles.push(circle());
        return <circle id={id} cx={cx} cy={cy} r={radius} fill="red" stroke="black" strokeWidth={strokewidth} />;
    }

    /*updateCircle(id, cx,cy,radius, strokewidth, color) {
     return <circle id={id} cx={cx} cy={cy} r={radius} fill={color} stroke="black" strokeWidth={strokewidth} />;
     }*/


    handleMouseMove (event) {
        // let svg = React.findDOMNode(this.refs.svg);
        //   let rect = svg.getBoundingClientRect();
        /* this.setState({
         x: event.clientX,
         y: event.clientY
         });*/



        /*    let clickedX, clickedY;
         onclick(function(e){
         clickedX = this.state.x;
         clickedY = this.state.y;
         });*/
    }

}
ReactDom.render(
    <Test width="900" height="600" />,
    document.getElementById('canvas_for_test')


);






