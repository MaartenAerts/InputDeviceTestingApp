/// <reference path="../typings/react/react.d.ts" />
/// <reference path="../typings/requirejs/require.d.ts" />
///<amd-dependency path="../bower_components/requirejs/require" />

import React = require('react')
declare var mountNode: any;
interface HelloWorldProps extends React.Props<any>
{
    name: string;
}


class HelloMessage extends React.Component<HelloWorldProps, {}>
{
    render()
    {
        return (
            <h2>i like to eat</h2>
        );
    }
}

React.render
(
    <HelloMessage name="John" />,
    document.getElementById('user')
);

var Frorm= React.createClass({getInitialState:function()
{return{text: "test"};
},
    render: function()
    {
        return<input type="text" value={this.state.text} onchange={this.handleChange}/>
    },






})