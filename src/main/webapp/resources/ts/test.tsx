/// <reference path="../typings/react/react.d.ts" />
///<reference path="../typings/react-dom/react-dom.d.ts"/>

import * as React from 'react'
import * as ReactDom from 'react-dom'
import 'testjoris'

var aantalCirkels = 10;
var xCircleArray = new Array();
var yCircleArray = new Array();
var IdArray = new Array();

var radiusBigCircle = 240; //Math.min(this.props.width, this.props.height) / 2.5;
var radius = radiusBigCircle/10;

var id = 1;
var idVolgende = 1;

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

        var strokeWidthBigCircle = radiusBigCircle / 50;
        var cxBigCircle = this.props.width / 2;
        var cyBigCircle = this.props.height / 2;

        var graden = 360/aantalCirkels;

        var tellerVoorHelft = 0;
        var tellerNaHelft = 0;
        var circleID = 0;


        for(var i = 1; i <= aantalCirkels;i++) {
            let radian = (graden * (i - 1)) * (Math.PI / 180);
            xCircleArray[i] = radiusBigCircle * Math.cos(radian) + cxBigCircle;
            yCircleArray[i] = radiusBigCircle * Math.sin(radian) + cyBigCircle;

            if (i <= ((aantalCirkels + 1) / 2)) {
                circleID = tellerVoorHelft + 1;
                tellerVoorHelft += 2;
            } else {
                circleID = tellerNaHelft + 2;
                tellerNaHelft += 2;
            }
            IdArray[i] = circleID;
        }

        //onMouseMove={this.handleMouseMove.bind(this)}
        return  <svg ref="svg" {...this.props} onMouseDown={this.handleMouseClick.bind(this)}>

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
        if (id==1){
            return <circle id={id} cx={cx} cy={cy} r={radius} fill="green" stroke="black" strokeWidth={strokewidth} />;

        }
        return <circle id={id} cx={cx} cy={cy} r={radius} fill="red" stroke="black" strokeWidth={strokewidth} />;
    }

    handleMouseClick(e){


        //kijken of de test voltooid is
        id = parseInt(e.target.id)
        if(id == aantalCirkels){

            alert('De test is gedaan!')
        }

        //aangeklikte bol geel kleuren
        //volgende aan te klikken bol groen kleuren
        //kijken of je op de juiste bol klikt, anders is dit een fout
        if (id == idVolgende) {
            e.target.setAttribute('fill','yellow');
            document.getElementById((id + 1).toString()).setAttribute('fill', 'green');
            idVolgende++;
        } else if (id < idVolgende) {
            alert('Eerder aangeklikte cirkel!')
        } else if (id > idVolgende) {
            alert('Klik eerst op de groene cirkel, deze is te vroeg!')
        }

    }
}


ReactDom.render(
    <Test width="900" height="600" />,
    document.getElementById('canvas_for_test')
);






