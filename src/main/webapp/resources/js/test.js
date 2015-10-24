/// <reference path="../typings/react/react.d.ts" />
///<reference path="../typings/react-dom/react-dom.d.ts"/>
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", 'react', 'react-dom', 'testjoris'], function (require, exports, React, ReactDom) {
    var aantalCirkels = 10;
    var xCircleArray = new Array();
    var yCircleArray = new Array();
    var IdArray = new Array();
    var radiusBigCircle = 240; //Math.min(this.props.width, this.props.height) / 2.5;
    var radius = radiusBigCircle / 10;
    var id = 1;
    var idVolgende = 1;
    var startTime = 0;
    var endTime = 0;
    var timeSeconds = 0;
    var errorArray = new Array();
    var opTeHalenCirkelId = 0;
    var xWaardeGeklikt = 0;
    var yWaardeGeklikt = 0;
    var xWaardeVerschil = 0;
    var yWaardeVerschil = 0;
    var errorWaarde = 0;
    var standardDeviation = 0;
    var aantalErrors = 0;
    var Test = (function (_super) {
        __extends(Test, _super);
        function Test(props) {
            _super.call(this, props);
            this.state = {
                x: 0,
                y: 0
            };
        }
        Test.prototype.render = function () {
            var strokeWidthBigCircle = radiusBigCircle / 50;
            var cxBigCircle = this.props.width / 2;
            var cyBigCircle = this.props.height / 2;
            var graden = 360 / aantalCirkels;
            var tellerVoorHelft = 0;
            var tellerNaHelft = 0;
            var circleID = 0;
            for (var i = 1; i <= aantalCirkels; i++) {
                var radian = (graden * (i - 1)) * (Math.PI / 180);
                xCircleArray[i] = radiusBigCircle * Math.cos(radian) + cxBigCircle;
                yCircleArray[i] = radiusBigCircle * Math.sin(radian) + cyBigCircle;
                if (i <= ((aantalCirkels + 1) / 2)) {
                    circleID = tellerVoorHelft + 1;
                    tellerVoorHelft += 2;
                }
                else {
                    circleID = tellerNaHelft + 2;
                    tellerNaHelft += 2;
                }
                IdArray[i] = circleID;
            }
            //onMouseMove={this.handleMouseMove.bind(this)}
            return React.createElement("svg", React.__spread({"ref": "svg"}, this.props, {"onMouseDown": this.handleMouseClick.bind(this)}), this.renderBigCircle(cxBigCircle, cyBigCircle, radiusBigCircle, strokeWidthBigCircle), this.renderCircle(IdArray[1], xCircleArray[1], yCircleArray[1], radius, strokeWidthBigCircle), this.renderCircle(IdArray[2], xCircleArray[2], yCircleArray[2], radius, strokeWidthBigCircle), this.renderCircle(IdArray[3], xCircleArray[3], yCircleArray[3], radius, strokeWidthBigCircle), this.renderCircle(IdArray[4], xCircleArray[4], yCircleArray[4], radius, strokeWidthBigCircle), this.renderCircle(IdArray[5], xCircleArray[5], yCircleArray[5], radius, strokeWidthBigCircle), this.renderCircle(IdArray[6], xCircleArray[6], yCircleArray[6], radius, strokeWidthBigCircle), this.renderCircle(IdArray[7], xCircleArray[7], yCircleArray[7], radius, strokeWidthBigCircle), this.renderCircle(IdArray[8], xCircleArray[8], yCircleArray[8], radius, strokeWidthBigCircle), this.renderCircle(IdArray[9], xCircleArray[9], yCircleArray[9], radius, strokeWidthBigCircle), this.renderCircle(IdArray[10], xCircleArray[10], yCircleArray[10], radius, strokeWidthBigCircle), this.renderCircle(IdArray[11], xCircleArray[11], yCircleArray[11], radius, strokeWidthBigCircle), this.renderCircle(IdArray[12], xCircleArray[12], yCircleArray[12], radius, strokeWidthBigCircle), this.renderCircle(IdArray[13], xCircleArray[13], yCircleArray[13], radius, strokeWidthBigCircle), this.renderCircle(IdArray[14], xCircleArray[14], yCircleArray[14], radius, strokeWidthBigCircle), this.renderCircle(IdArray[15], xCircleArray[15], yCircleArray[15], radius, strokeWidthBigCircle), this.renderCircle(IdArray[16], xCircleArray[16], yCircleArray[16], radius, strokeWidthBigCircle), this.renderCircle(IdArray[17], xCircleArray[17], yCircleArray[17], radius, strokeWidthBigCircle), this.renderCircle(IdArray[18], xCircleArray[18], yCircleArray[18], radius, strokeWidthBigCircle), this.renderCircle(IdArray[19], xCircleArray[19], yCircleArray[19], radius, strokeWidthBigCircle), this.renderCircle(IdArray[20], xCircleArray[20], yCircleArray[20], radius, strokeWidthBigCircle), this.renderCircle(IdArray[21], xCircleArray[21], yCircleArray[21], radius, strokeWidthBigCircle), this.renderCircle(IdArray[22], xCircleArray[22], yCircleArray[22], radius, strokeWidthBigCircle), this.renderCircle(IdArray[23], xCircleArray[23], yCircleArray[23], radius, strokeWidthBigCircle), this.renderCircle(IdArray[24], xCircleArray[24], yCircleArray[24], radius, strokeWidthBigCircle), this.renderCircle(IdArray[25], xCircleArray[25], yCircleArray[25], radius, strokeWidthBigCircle));
        };
        Test.prototype.renderBigCircle = function (cxBigCircle, cyBigCircle, radiusBigCircle, strokewidthBigCircle) {
            return React.createElement("circle", {"cx": cxBigCircle, "cy": cyBigCircle, r: radiusBigCircle - 10, "fill": "#ccffff", "stroke": "black", "strokeWidth": "1"});
        };
        Test.prototype.renderCircle = function (id, cx, cy, radius, strokewidth) {
            if (id == 1) {
                return React.createElement("circle", {"id": id, "cx": cx, "cy": cy, r: radius, "fill": "green", "stroke": "black", "strokeWidth": strokewidth});
            }
            return React.createElement("circle", {"id": id, "cx": cx, "cy": cy, r: radius, "fill": "red", "stroke": "black", "strokeWidth": strokewidth});
        };
        Test.prototype.berekenVerschilCoördinaten = function (e) {
            // met pythagoras waarde dat ernaast geklikt is berekenen
            // coördinaten waar geklikt is ophalen
            xWaardeGeklikt = e.pageX;
            yWaardeGeklikt = e.pageY;
            // juiste circleID ophalen om de positie van de juiste cirkel op te halen, want de cirkels worden anders gegenereerd dan ze ID's krijgen
            // omgekeerd denken, waar is IdArray = 2? => gefoefel door die ID's
            for (var i = 1; i <= IdArray.length; i++) {
                if (IdArray[i] == idVolgende) {
                    opTeHalenCirkelId = i;
                }
            }
            // pythagoras
            xWaardeVerschil = (Math.abs(xCircleArray[opTeHalenCirkelId] - xWaardeGeklikt)) - (radius / 2);
            yWaardeVerschil = (Math.abs(yCircleArray[opTeHalenCirkelId] - yWaardeGeklikt)) - (radius / 2);
            errorWaarde = Math.sqrt(Math.pow(xWaardeVerschil, 2) + Math.pow(yWaardeVerschil, 2));
            errorArray[idVolgende] = errorWaarde;
        };
        Test.prototype.berekenEindResultatenTest = function () {
            // test afsluiten en alles berekenen
            endTime = Date.now();
            timeSeconds = (endTime - startTime) / 1000;
            alert('De test werd afgelegd op ' + timeSeconds + ' seconden');
            //  alert('Lengte errorArray: ' + errorArray.length.toString());
            alert('errorArray waarden: ' + errorArray[1] + "," + errorArray[2] + "," + errorArray[3] + "," + errorArray[4] + "," + errorArray[5] + "," + errorArray[6] + "," + errorArray[7] + "," + errorArray[8] + "," + errorArray[9] + "," + errorArray[10]);
            //standard deviation berekenen
            var sum = 0;
            var average = 0;
            var verschil = 0;
            var variantieTemp = 0;
            var variantie = 0;
            // errorArray.length -1 omdat de lengte altijd +1 meer is omdat die van 0 telt, en wij steken er van plaats 1 pas iets in
            for (var i = 1; i <= errorArray.length - 1; i++) {
                sum += parseInt(errorArray[i]);
            }
            average = sum / (errorArray.length - 1);
            for (var j = 1; j <= errorArray.length - 1; j++) {
                verschil = parseInt(errorArray[j]) - average;
                variantieTemp += Math.pow(verschil, 2);
            }
            variantie = variantieTemp / (errorArray.length - 1);
            standardDeviation = Math.sqrt(variantie);
            alert('Standaardafwijking: ' + standardDeviation); // OP TE LOSSEN: de laatste cirkel aanklikken zit er precies altijd iets naast, waardoor er altijd een standaardafwijking is..
            var we = 4.133 * standardDeviation;
            alert('We: ' + we);
            if (we != 0) {
                var ide = Math.log2((radiusBigCircle - radius) / we);
            }
            else {
                var ide = Math.log2((radiusBigCircle - radius) / 1);
            }
            alert('Ide: ' + ide);
            var throughput = ide / timeSeconds;
            alert('Throughput: ' + throughput + "bits/s\n Aantal Errors: " + aantalErrors);
        };
        Test.prototype.handleMouseClick = function (e) {
            /*          TEST WAARBIJ JE OP ALLE CIRKELS MOET GEKLIKT HEBBEN VOORALEER DE TEST STOPT
            //kijken of de test voltooid is
            id = parseInt(e.target.id)
            if (id == 1) {
                startTime = Date.now();
                alert('Test is gestart')
            }
            if(id == aantalCirkels){
                endTime = Date.now();
                timeSeconds = (endTime-startTime)/1000;
                alert('De test werd afgelegd op ' + timeSeconds + ' seconden')
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
            } */
            id = parseInt(e.target.id);
            if (idVolgende == 1) {
                startTime = Date.now();
                alert('Test is gestart');
            }
            // || idVolgende == aantalCirkels dient voor als je fout klikt bij de laatste cirkel, dat de test toch wordt afgesloten
            if ((id == aantalCirkels && idVolgende == aantalCirkels) || idVolgende == aantalCirkels) {
                //werd er op de laatste niet geklikt?
                if (id != aantalCirkels) {
                    aantalErrors++;
                }
                this.berekenVerschilCoördinaten(e);
                //gefoefel ivm de errorwaarde van de laatste cirkel
                // deze kreeg ander altijd een waarde, ookal werd er op geklikt
                if (id == aantalCirkels) {
                    errorArray[id] = 0;
                }
                this.berekenEindResultatenTest();
            }
            // deze if staat laatst omdat ander bij het aanklikken van de laatste bol de test niet wordt afgesloten
            //kijken of je op de juiste bol klikt, anders is dit een fout
            if (id == idVolgende) {
                e.target.setAttribute('fill', 'yellow');
                //volgende aan te klikken bol groen kleuren
                document.getElementById((id + 1).toString()).setAttribute('fill', 'green');
                //errorArray vullen met 0, want er is juist geklikt
                errorArray[id] = 0;
            }
            else if (idVolgende != aantalCirkels) {
                alert('Fout geklikt');
                // de niet aangeklikte bol terug rood kleuren
                document.getElementById((idVolgende).toString()).setAttribute('fill', 'red');
                // volgende aan te klikken bol groen kleuren
                document.getElementById((idVolgende + 1).toString()).setAttribute('fill', 'green');
                this.berekenVerschilCoördinaten(e);
                aantalErrors++;
            }
            idVolgende++;
            // id wegdoen om volgende klik te detecteren of een cirkel is geklikt of niet
            id = null;
        };
        return Test;
    })(React.Component);
    ReactDom.render(React.createElement(Test, {"width": "900", "height": "600"}), document.getElementById('canvas_for_test'));
});
//# sourceMappingURL=test.js.map