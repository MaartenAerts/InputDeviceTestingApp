/// <reference path="../typings/requirejs/require.d.ts"/>

require.config({

    baseUrl: 'js/',

    paths: {
        //main libraries
        jquery: '../bower_components/jquery/jquery',
        react: '../bower_components/react/react',


    },

    shim: {
        jquery: {
            exports: '$'
        },
        react: {
            exports: 'React'
        }
    }
});
