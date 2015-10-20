

/// <reference path="../typings/react/react.d.ts" />
/// <reference path="../typings/requirejs/require.d.ts" />
///<amd-dependency path="../bower_components/requirejs/require" />

import React = require('react')

class Test extends React.Component {
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

        let radius = radiusBigCircle/10;

        let aantalCirkels = 25;
        let graden = 360/aantalCirkels;
        let xCircleArray = new Array();
        let yCircleArray = new Array();

        let teller = 0;
        let circleID = 0;

        for(var i = 1; i <= aantalCirkels;i++) {
            let radian = (graden*(i-1))*(Math.PI/180);
            xCircleArray[i] = radiusBigCircle * Math.cos(radian);
            yCircleArray[i] = radiusBigCircle * Math.sin(radian);

            circleID = (teller+1) + i;
            teller++;
        }
/*
        // degrees naar radians omzetten
        let graden2 = 36;
        let radian2 = graden2 * (Math.PI/180);
        let moveX2 = radiusBigCircle * Math.cos(radian2);         //cirkel 2
        let moveY2 = radiusBigCircle * Math.sin(radian2);         //cirkel 2

        let graden3 = 72;
        let radian3 = graden3 * (Math.PI/180);
        let moveX3 = radiusBigCircle * Math.cos(radian3);         //cirkel 3
        let moveY3 = radiusBigCircle * Math.sin(radian3);         //cirkel 3

        let moveX4 = radiusBigCircle * Math.cos((graden3+36) * (Math.PI/180))           //cirkel 4
        let moveY4 = radiusBigCircle * Math.sin((graden3+36) * (Math.PI/180))           //cirkel 4

        let moveX5 = radiusBigCircle * Math.cos((graden3+72) * (Math.PI/180))           //cirkel 5
        let moveY5 = radiusBigCircle * Math.sin((graden3+72) * (Math.PI/180))           //cirkel 5

        let moveX6 = radiusBigCircle * Math.cos((graden3+108) * (Math.PI/180))           //cirkel 6
        let moveY6 = radiusBigCircle * Math.sin((graden3+108) * (Math.PI/180))           //cirkel 6

        let moveX7 = radiusBigCircle * Math.cos((graden3+144) * (Math.PI/180))           //cirkel 7
        let moveY7 = radiusBigCircle * Math.sin((graden3+144) * (Math.PI/180))           //cirkel 7

        let moveX8 = radiusBigCircle * Math.cos((graden3+180) * (Math.PI/180))           //cirkel 8
        let moveY8 = radiusBigCircle * Math.sin((graden3+180) * (Math.PI/180))           //cirkel 8

        let moveX9 = radiusBigCircle * Math.cos((graden3+216) * (Math.PI/180))           //cirkel 9
        let moveY9 = radiusBigCircle * Math.sin((graden3+216) * (Math.PI/180))           //cirkel 9

        let moveX10 = radiusBigCircle * Math.cos((graden3+252) * (Math.PI/180))           //cirkel 10
        let moveY10 = radiusBigCircle * Math.sin((graden3+252) * (Math.PI/180))           //cirkel 10
*/

        /*
        * {this.renderCircle(cxBigCircle + radiusBigCircle,cyBigCircle,radius,strokeWidthBigCircle)}
         {this.renderCircle(moveX2 + cxBigCircle,moveY2 + cyBigCircle,radius,strokeWidthBigCircle)}
         {this.renderCircle(moveX3 + cxBigCircle,moveY3 + cyBigCircle,radius,strokeWidthBigCircle)}
         {this.renderCircle(moveX4 + cxBigCircle,moveY4 + cyBigCircle,radius,strokeWidthBigCircle)}
         {this.renderCircle(moveX5 + cxBigCircle,moveY5 + cyBigCircle,radius,strokeWidthBigCircle)}
         {this.renderCircle(moveX6 + cxBigCircle,moveY6 + cyBigCircle,radius,strokeWidthBigCircle)}
         {this.renderCircle(moveX7 + cxBigCircle,moveY7 + cyBigCircle,radius,strokeWidthBigCircle)}
         {this.renderCircle(moveX8 + cxBigCircle,moveY8 + cyBigCircle,radius,strokeWidthBigCircle)}
         {this.renderCircle(moveX9 + cxBigCircle,moveY9 + cyBigCircle,radius,strokeWidthBigCircle)}
         {this.renderCircle(moveX10 + cxBigCircle,moveY10 + cyBigCircle,radius,strokeWidthBigCircle)}*/

        return <svg ref="svg" {...this.props}>
            {this.renderBigCircle(cxBigCircle,cyBigCircle,radiusBigCircle,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[1] + cxBigCircle, yCircleArray[1] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[2] + cxBigCircle, yCircleArray[2] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[3] + cxBigCircle, yCircleArray[3] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[4] + cxBigCircle, yCircleArray[4] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[5] + cxBigCircle, yCircleArray[5] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[6] + cxBigCircle, yCircleArray[6] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[7] + cxBigCircle, yCircleArray[7] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[8] + cxBigCircle, yCircleArray[8] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[9] + cxBigCircle, yCircleArray[9] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[10] + cxBigCircle, yCircleArray[10] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[11] + cxBigCircle, yCircleArray[11] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[12] + cxBigCircle, yCircleArray[12] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[13] + cxBigCircle, yCircleArray[13] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[14] + cxBigCircle, yCircleArray[14] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[15] + cxBigCircle, yCircleArray[15] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[16] + cxBigCircle, yCircleArray[16] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[17] + cxBigCircle, yCircleArray[17] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[18] + cxBigCircle, yCircleArray[18] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[19] + cxBigCircle, yCircleArray[19] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[20] + cxBigCircle, yCircleArray[20] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[21] + cxBigCircle, yCircleArray[21] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[22] + cxBigCircle, yCircleArray[22] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[23] + cxBigCircle, yCircleArray[23] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[24] + cxBigCircle, yCircleArray[24] + cyBigCircle,radius,strokeWidthBigCircle)}
            {this.renderCircle(xCircleArray[25] + cxBigCircle, yCircleArray[25] + cyBigCircle,radius,strokeWidthBigCircle)}
        </svg>;
    }

    renderBigCircle(cxBigCirle, cyBigCircle, radiusBigCircle, strokewidthBigCircle) {
        return <circle cx={cxBigCirle} cy={cyBigCircle} r={radiusBigCircle-10} fill="#ccffff" stroke="black" strokeWidth={"1"}/>;
    }

    renderCircle(cx, cy, radius, strokewidth) {
        return <circle cx={cx} cy={cy} r={radius} fill="red" stroke="black" strokeWidth={strokewidth}  />;
    }

}

    React.render(
        <Test width="900" height="600" />,
        document.getElementById('canvas_for_test')
    );







