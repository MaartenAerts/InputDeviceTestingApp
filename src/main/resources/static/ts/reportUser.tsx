
/*var boxplotDiv = document.getElementById('boxplotDifficulty');
var boxplotDifficulty = {
    x: [1,7,10,13],
type: 'box',
    name: 'box_1'
};

var layout = {
    title: 'Boxplot of difficulty'
}

Plotly.newPlot('boxplotDiv', boxplotDifficulty,layout);*/

var trace1 = {
    x: [1, 2, 3, 4, 4, 4, 8, 9, 10],
    type: 'box',
    name: 'Set 1'
};

var trace2 = {
    x: [2, 3, 3, 3, 3, 5, 6, 6, 7],
    type: 'box',
    name: 'Set 2'
};

var data = [trace1, trace2];

var layout = {
    title: 'Horizontal Box Plot'
};

Plotly.newPlot('boxplotDifficulty', data, layout);