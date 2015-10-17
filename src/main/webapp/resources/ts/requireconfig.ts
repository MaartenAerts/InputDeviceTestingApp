/// <reference path="../typings/requirejs/require.d.ts"/>
///<amd-dependency path="../bower_components/react/react" />
///<amd dependency path="../bower_components/react/react-with-addons" />
///<amd dependency path="../bower_components/react-dom/react-dom" />
///<amd-dependency path="test" />
///<amd-dependency path="testjoris" />


require.config({

    baseUrl: '../../resources/js',

    paths: {
        //main libraries
        jquery: '../bower_components/jquery/jquery',
        react: '../bower_components/react/react',
        test: '../js/test',
        testjoris: '../js/testjoris',
        reactaddons: '../bower_components/react/react-with-addons',
        reactdom: '../bower_components/react-dom/react-dom'
    },

    shim: {
        jquery: {
            exports: '$'
        },
        react: {
            exports: 'React'
        },
        test: {
            exports: 'test'
        },
        testjoris: {
            exports: 'testjoris'
        },
        reactaddons: {
            exports: 'reactaddons'
        },
        reactdom: {
            exports: 'reactdom'
        }
    },

});


require(['test'], function (test) {
    //test is now loaded.
});
require(['testjoris'], function (testjoris) {
    //test is now loaded.
});