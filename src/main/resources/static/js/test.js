/// <reference path="../../../webapp/resources/typings/react/react.d.ts" />
///<reference path="../../../webapp/resources/typings/react-dom/react-dom.d.ts"/>
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", 'react', 'react-dom'], function (require, exports, React, ReactDom) {
    // in te stellen parameters via applicatie
    var aantalCirkels = 7; // enkel oneven toelaten via createTest !!!
    var radiusBigCircle = 240; //Math.min(this.props.width, this.props.height) / 2.5;
    var radius = radiusBigCircle / 7.5;
    var errorMax = 0.5;
    var colorMainCircle = "#ffffff";
    var colorTarget = "red";
    var colorNextTarget = "green";
    var colorClickedTarget = "yellow";
    var colorMissedTarget = "#660000";
    // door te geven parameters naar databank
    var Ae = 0;
    var We = 0;
    var IDe = 0;
    var MT = 0;
    var ER = 0;
    var TP = 0;
    var resultatenArray = new Array();
    var xCircleArray = new Array();
    var yCircleArray = new Array();
    var IdArray = new Array();
    var id = 1;
    var idVolgende = 1;
    var idLaatsteIsEersteCirkel = false;
    var startTime = 0;
    var endTime = 0;
    var timeSeconds = 0;
    var timeGemiddelde = 0;
    var errorArray = new Array();
    var opTeHalenCirkelId = 0;
    var xWaardeGeklikt = 0;
    var yWaardeGeklikt = 0;
    var xWaardeVerschil = 0;
    var yWaardeVerschil = 0;
    var errorWaarde = 0;
    var standardDeviation = 0;
    var opTeHalenCirkelIdVolgende = 0;
    var aantalErrors = 0;
    var xWaardeVerschoven = 0;
    var yWaardeVerschoven = 0;
    var xWaardeVerschovenPlaats = 0;
    var yWaardeVerschovenPlaats = 0;
    var trackingArrayX = new Array();
    var trackingArrayY = new Array();
    var interval;
    var sequentieNummer = 1;
    var sequentieMax = 4;
    var testGedaan = false;
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
            // sequentienummer uit localstorage halen
            sequentieNummer = localStorage.getItem("sequentieNummer");
            //alert("Sequentienummer: " + sequentieNummer);
            if (sequentieNummer == null && testGedaan == false) {
                sequentieNummer = 1;
                alert("Test " + sequentieNummer + " van de " + sequentieMax);
            }
            else if (sequentieNummer < sequentieMax && testGedaan == false) {
                sequentieNummer = localStorage.getItem("sequentieNummer");
                alert("Test " + sequentieNummer + " van de " + sequentieMax);
            }
            else {
                alert("Test " + sequentieNummer + " van de " + sequentieMax);
            }
            for (var i = 1; i <= aantalCirkels; i++) {
                var radian = (graden * (i - 1)) * (Math.PI / 180);
                xCircleArray[i] = (radiusBigCircle * Math.cos(radian) + cxBigCircle);
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
            //onMouseMove={this.trackMousePosition.bind(this)}
            return React.createElement("svg", React.__spread({"ref": "svg", "id": "svgcomponent"}, this.props, {"onMouseDown": this.handleMouseClick.bind(this)}), this.renderBigCircle(cxBigCircle, cyBigCircle, radiusBigCircle), this.renderCircle(IdArray[1], xCircleArray[1], yCircleArray[1], radius), this.renderCircle(IdArray[2], xCircleArray[2], yCircleArray[2], radius), this.renderCircle(IdArray[3], xCircleArray[3], yCircleArray[3], radius), this.renderCircle(IdArray[4], xCircleArray[4], yCircleArray[4], radius), this.renderCircle(IdArray[5], xCircleArray[5], yCircleArray[5], radius), this.renderCircle(IdArray[6], xCircleArray[6], yCircleArray[6], radius), this.renderCircle(IdArray[7], xCircleArray[7], yCircleArray[7], radius), this.renderCircle(IdArray[8], xCircleArray[8], yCircleArray[8], radius), this.renderCircle(IdArray[9], xCircleArray[9], yCircleArray[9], radius), this.renderCircle(IdArray[10], xCircleArray[10], yCircleArray[10], radius), this.renderCircle(IdArray[11], xCircleArray[11], yCircleArray[11], radius), this.renderCircle(IdArray[12], xCircleArray[12], yCircleArray[12], radius), this.renderCircle(IdArray[13], xCircleArray[13], yCircleArray[13], radius), this.renderCircle(IdArray[14], xCircleArray[14], yCircleArray[14], radius), this.renderCircle(IdArray[15], xCircleArray[15], yCircleArray[15], radius), this.renderCircle(IdArray[16], xCircleArray[16], yCircleArray[16], radius), this.renderCircle(IdArray[17], xCircleArray[17], yCircleArray[17], radius), this.renderCircle(IdArray[18], xCircleArray[18], yCircleArray[18], radius), this.renderCircle(IdArray[19], xCircleArray[19], yCircleArray[19], radius), this.renderCircle(IdArray[20], xCircleArray[20], yCircleArray[20], radius), this.renderCircle(IdArray[21], xCircleArray[21], yCircleArray[21], radius), this.renderCircle(IdArray[22], xCircleArray[22], yCircleArray[22], radius), this.renderCircle(IdArray[23], xCircleArray[23], yCircleArray[23], radius), this.renderCircle(IdArray[24], xCircleArray[24], yCircleArray[24], radius), this.renderCircle(IdArray[25], xCircleArray[25], yCircleArray[25], radius));
        };
        Test.prototype.renderBigCircle = function (cxBigCircle, cyBigCircle, radiusBigCircle) {
            return React.createElement("circle", {"cx": cxBigCircle, "cy": cyBigCircle, r: radiusBigCircle - 10, "fill": colorMainCircle});
        };
        Test.prototype.renderCircle = function (id, cx, cy, radius) {
            if (id == 1) {
                return React.createElement("circle", {"id": id, "cx": cx, "cy": cy, r: radius, "fill": colorNextTarget, "stroke": "black", "strokeWidth": "2"});
            }
            if (id <= aantalCirkels) {
                return React.createElement("circle", {"id": id, "cx": cx, "cy": cy, r: radius, "fill": colorTarget, "stroke": "black", "strokeWidth": "2"});
            }
        };
        Test.prototype.berekenVerschilCoördinaten = function (e) {
            //alert('verschil!')
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
            // + screen.width/2 omdat de test gecentreerd staat op de pagina
            // + 450 omdat de positie van het canvas (=width(900)/2) anders niet overeen komt
            // + 115.5 omdat dit de totale grootte is van alle elementen van de page-header (42px + 42px + 9.5px + 1px + 21px)al => veranderd naar 125 na testen
            xWaardeVerschil = (Math.abs((screen.width / 2 + xCircleArray[opTeHalenCirkelId]) - (xWaardeGeklikt + 450)) - (radius));
            yWaardeVerschil = (Math.abs(125 + yCircleArray[opTeHalenCirkelId] - yWaardeGeklikt)) - (radius);
            errorWaarde = Math.sqrt(Math.pow(xWaardeVerschil, 2) + Math.pow(yWaardeVerschil, 2));
            errorArray[idVolgende] = errorWaarde;
            //alert(errorWaarde)
            //    alert("x-waarde te klikken: " + (xCircleArray[opTeHalenCirkelId]) + ", geklikt: " + (xWaardeGeklikt-screen.width/2) + "\ny-waarde te klikken: " + yCircleArray[opTeHalenCirkelId] + ", geklikt: " + yWaardeGeklikt);
            //alert(xCircleArray[opTeHalenCirkelId] +"\n"+ screen.width +"\n"+ xWaardeGeklikt +"\n"+ xWaardeVerschil);
            //alert(yCircleArray[opTeHalenCirkelId] + "\n" + yWaardeGeklikt + "\n" + yWaardeVerschil);
        };
        Test.prototype.berekenEindResultatenTest = function () {
            // test afsluiten en alles berekenen
            endTime = Date.now();
            // alles rond Mousetracking
            window.clearInterval(interval);
            //this.showPathPixels();
            timeSeconds = (endTime - startTime) / 1000;
            //alert('De test werd afgelegd op ' + timeSeconds + ' seconden')
            timeGemiddelde = timeSeconds / aantalCirkels;
            //alert('Dus time per trial: ' + timeGemiddelde)
            //  alert('Lengte errorArray: ' + errorArray.length.toString());
            //alert('errorArray waarden: ' + errorArray[1] + "," + errorArray[2] + "," + errorArray[3] + "," + errorArray[4] + "," + errorArray[5] + "," + errorArray[6] + "," + errorArray[7])
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
            //alert('Standaardafwijking: ' + standardDeviation);      // OP TE LOSSEN: de laatste cirkel aanklikken zit er precies altijd iets naast, waardoor er altijd een standaardafwijking is..
            var we = 4.133 * standardDeviation;
            //alert(standardDeviation);
            //alert('We: ' + we);
            var ae = 0;
            var xAfstand = 0;
            var yAfstand = 0;
            var afTeLeggenAfstand = 0;
            //lus om afstanden(amplitude) tussen de cirkels te berekenen
            for (var k = 1; k <= errorArray.length - 2; k++) {
                for (var l = 1; l <= IdArray.length - 1; l++) {
                    if (IdArray[l] == k) {
                        opTeHalenCirkelId = l;
                    }
                    else if (IdArray[l] == (k + 1)) {
                        opTeHalenCirkelIdVolgende = l;
                    }
                }
                //pythagoras om de afstanden tussen 2 cirkels te berekenen
                xAfstand = Math.abs(xCircleArray[opTeHalenCirkelIdVolgende] - xCircleArray[opTeHalenCirkelId]);
                yAfstand = Math.abs(yCircleArray[opTeHalenCirkelIdVolgende] - yCircleArray[opTeHalenCirkelId]);
                afTeLeggenAfstand += Math.sqrt((Math.pow(xAfstand, 2)) + Math.pow(yAfstand, 2)) - radius;
            }
            ae = afTeLeggenAfstand / (aantalCirkels);
            var ide = 0;
            if (we != 0) {
                ide = Math.log(ae / we) / Math.LN2;
            }
            else {
                ide = Math.log(ae / 1) / Math.LN2;
            }
            //alert('Ide: ' + ae);
            var throughput = ide / timeGemiddelde;
            //alert('Throughput: ' + throughput + " bits/s\n Aantal Errors: " + aantalErrors);
            // resultaten tonen op het einde van de test
            this.toonResultaten(ae, we, ide, throughput);
            // sequentienummer behouden na page refresh
            if (sequentieNummer < sequentieMax && testGedaan == false) {
                sequentieNummer++;
                localStorage.setItem("sequentieNummer", sequentieNummer.toString());
                window.location.reload();
            }
            else {
                //localStorage.setItem("sequentieNummer", null);
                localStorage.clear();
                testGedaan = true;
                alert("Bedankt voor de test! De data werd goed ontvangen!");
            }
        };
        Test.prototype.saveToTempLocalStorage = function (trial, a, w, ae, we, ide, aantalErrors, mt, er, tp) {
            resultatenArray.push(trial, a, w, ae, we, ide, aantalErrors, mt, er, tp);
            //alert(resultatenArray.length.toString());
            localStorage.setItem("trial_" + sequentieNummer, trial);
            localStorage.setItem("a_" + sequentieNummer, a);
            localStorage.setItem("w_" + sequentieNummer, w);
            localStorage.setItem("ae_" + sequentieNummer, ae);
            localStorage.setItem("we_" + sequentieNummer, we);
            localStorage.setItem("ide_" + sequentieNummer, ide);
            localStorage.setItem("aantalErrors_" + sequentieNummer, aantalErrors);
            localStorage.setItem("mt_" + sequentieNummer, mt);
            localStorage.setItem("er_" + sequentieNummer, er);
            localStorage.setItem("tp_" + sequentieNummer, tp);
            //alert("AantalErrors: " + localStorage.getItem("aantalErrors_1"));
            /*trial = document.getElementById('trial');
            a = document.getElementById('a');
            w = document.getElementById('w');
            ae = document.getElementById('ae');
            we = document.getElementById('we');
            ide = document.getElementById('ide');
            aantalErrors = document.getElementById('error');
            mt = document.getElementById('mt');
            er = document.getElementById('er');
            tp = document.getElementById('tp');
            document.forms['testResultForm'].submit();*/
        };
        Test.prototype.toonResultaten = function (ae, we, ide, throughput) {
            Ae = Math.round(ae * 100) / 100;
            We = Math.round(we * 100) / 100;
            IDe = Math.round(ide * 100) / 100;
            MT = Math.round((timeGemiddelde * 1000) * 10) / 10;
            ER = (aantalErrors / aantalCirkels) * 100;
            TP = Math.round(throughput * 10) / 10;
            //resultaten eerst naar de databank schrijven
            this.saveToTempLocalStorage(aantalCirkels, radiusBigCircle, radius, Ae, We, IDe, aantalErrors, MT, ER, TP);
            alert('TASK CONDITIONS:\n     ' +
                'Trials = ' + aantalCirkels + '\n     A = ' + radiusBigCircle + '\n     W = ' + radius +
                '\nMOVEMENT BEHAVIOUR:\n     Ae = ' + Ae
                + '\n     We = ' + We + '\n     IDe = ' + IDe + '\n     Errors = ' + aantalErrors +
                '\nPARTICIPANT PERFORMANCE:\n     MT  = ' + MT + ' ms/trial\n     ER = ' + ER + ' %\n     TP = ' + TP + ' bits/s');
            //  this.dbData(aantalCirkels,radiusBigCircle,radius,Ae,We,IDe,aantalErrors,MT,ER,TP);
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
                if (idLaatsteIsEersteCirkel == false) {
                    startTime = Date.now();
                    // vanaf de 1ste cirkel ticker starten
                    this.startTickerMousePosition(e);
                }
            }
            // || idVolgende == aantalCirkels dient voor als je fout klikt bij de laatste cirkel, dat de test toch wordt afgesloten
            if ((id == aantalCirkels && idVolgende == aantalCirkels) || idVolgende == aantalCirkels || (idVolgende == 1 && idLaatsteIsEersteCirkel == true) || (id == 1 && idLaatsteIsEersteCirkel == true)) {
                //werd er op de laatste niet geklikt?
                if (id != aantalCirkels && idLaatsteIsEersteCirkel == false) {
                    aantalErrors++;
                }
                //alert('is da van hier?')
                if (id != idVolgende) {
                    this.berekenVerschilCoördinaten(e);
                }
                //gefoefel ivm de errorwaarde van de laatste cirkel
                // deze kreeg ander altijd een waarde, ookal werd er op geklikt
                if (id == aantalCirkels) {
                    errorArray[id] = 0;
                }
                if (idLaatsteIsEersteCirkel == true) {
                    if (errorMax >= (aantalErrors / aantalCirkels)) {
                        //   alert('resultaten worden weer berekend!');
                        this.berekenEindResultatenTest();
                    }
                    else {
                        alert('Je errorpercentage bedraagt ' + (aantalErrors / aantalCirkels * 100) + '%, maximum toegelaten is ' + errorMax * 100 + '%!\nOpnieuw!');
                        window.location.reload();
                    }
                }
                // logica om terug te keren bij de eerste cirkel als laatste aan te klikken
                if (idLaatsteIsEersteCirkel == false) {
                    idVolgende = 1;
                    idLaatsteIsEersteCirkel = true;
                }
            }
            // deze if staat laatst omdat ander bij het aanklikken van de laatste bol de test niet wordt afgesloten
            //kijken of je op de juiste bol klikt, anders is dit een fout
            if (id == idVolgende) {
                e.target.setAttribute('fill', colorClickedTarget);
                if (idLaatsteIsEersteCirkel == false) {
                    //volgende aan te klikken bol groen kleuren
                    document.getElementById((id + 1).toString()).setAttribute('fill', colorNextTarget);
                    //errorArray vullen met 0, want er is juist geklikt
                    errorArray[id] = 0;
                }
                else if (idLaatsteIsEersteCirkel == true) {
                    //laatste positie in de errorArray (die de eerste cirkel als laatste weer aanklikt) op 0 zetten
                    // alert('hier')
                    errorArray[aantalCirkels + 1] = 0;
                }
            }
            else if (idVolgende != aantalCirkels && idLaatsteIsEersteCirkel == false) {
                //alert ('Fout geklikt')
                // de niet aangeklikte bol terug rood kleuren
                document.getElementById((idVolgende).toString()).setAttribute('fill', colorMissedTarget);
                // volgende aan te klikken bol groen kleuren
                document.getElementById((idVolgende + 1).toString()).setAttribute('fill', colorNextTarget);
                this.berekenVerschilCoördinaten(e);
                aantalErrors++;
            }
            else if (idVolgende != aantalCirkels && idLaatsteIsEersteCirkel == true) {
                if (id == aantalCirkels) {
                    document.getElementById((aantalCirkels).toString()).setAttribute('fill', colorClickedTarget);
                }
                else if (id != aantalCirkels && idVolgende == 1) {
                    document.getElementById((aantalCirkels).toString()).setAttribute('fill', colorMissedTarget);
                    aantalErrors++;
                }
                document.getElementById((idVolgende).toString()).setAttribute('fill', colorNextTarget);
            }
            if (idLaatsteIsEersteCirkel == false) {
                idVolgende++;
                // id wegdoen om volgende klik te detecteren of een cirkel is geklikt of niet
                id = null;
            }
        };
        Test.prototype.startTickerMousePosition = function (e) {
            interval = window.setInterval(function () {
                xWaardeVerschoven = e.pageX;
                yWaardeVerschoven = e.pageY;
                trackingArrayX[xWaardeVerschovenPlaats] = xWaardeVerschoven;
                trackingArrayY[yWaardeVerschovenPlaats] = yWaardeVerschoven;
                xWaardeVerschovenPlaats++;
                yWaardeVerschovenPlaats++;
            }, 10);
        };
        return Test;
    })(React.Component);
    ReactDom.render(React.createElement(Test, {"width": "900", "height": "600"}), document.getElementById('canvas_for_test'));
});
//# sourceMappingURL=test.js.map