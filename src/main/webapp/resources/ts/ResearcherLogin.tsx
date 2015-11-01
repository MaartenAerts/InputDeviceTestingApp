/// <reference path="../typings/react/react.d.ts" />
///<reference path="../typings/react-dom/react-dom.d.ts"/>

import * as React from 'react'
import * as ReactAddons from 'react-with-addons'
import * as ReactDom from 'react-dom'

declare var mountNode: any;
interface HelloWorldProps extends React.Props<any>
{
    name: string;
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

ReactDom.render
(
    <Form/>,document.getElementById("hier")

);


ReactDom.render
(
    <HelloMessage name="John" />,
    document.getElementById('example')

);
