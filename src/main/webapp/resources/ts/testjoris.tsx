/// <reference path="../typings/react/react.d.ts" />
/// <reference path="../typings/requirejs/require.d.ts" />
///<amd-dependency path="../bower_components/requirejs/require" />

import React = require('react')
import ReactAddons = require('reactaddons')

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

var Form =React.createClass({
    mixins: [ReactAddons.addons.LinkedStateMixin],

    getInitialState:function()
    {return{text: "test"};
    },

    render: function()
    {

        return<div>
            <input type="text" valueLink={this.linkState("text")}/>
            {this.state.text}
        </div>
    }
});

React.render
(
    <Form/>,document.getElementById("hier")

);


React.render
(
    <HelloMessage name="John" />,
    document.getElementById('example')

);