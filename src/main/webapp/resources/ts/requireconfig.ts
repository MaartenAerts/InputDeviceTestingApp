/// <reference path="../typings/requirejs/require.d.ts"/>
///<amd-dependency path="../bower_components/react/react" />
///<amd-dependency path="test" />
///<amd-dependency path="testjoris" />


require.config({

    baseUrl: '../../resources/js',

    paths: {
        //main libraries
        jquery: '../bower_components/jquery/jquery',
        react: '../bower_components/react/react',
        test: '../js/test',

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
        reactwithaddons: {
            exports: 'reactwithaddons'
        }
    },

});


require(['test'], function (test) {
    //test is now loaded.
});
require(['testjoris'], function (testjoris) {
    //test is now loaded.
});