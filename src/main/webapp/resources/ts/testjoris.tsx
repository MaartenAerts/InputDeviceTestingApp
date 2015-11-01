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


interface loginState extends React.Props<any>
{
    user: string;
    password: string;
}

class Login extends React.Component<loginState,{}> {

    constructor(props) {
        super(props);

        this.state =
        {
            username: '',
            password: ''
        }
    }

}


/*
var LoginForm = React.createClass({
    mixins: [ReactAddons.addons.LinkedStateMixin],

    getInitialState:function()
    {return{username: 'leeg', password:'leeg'};
    },


    render: function()
    {
        return(
            <div className="login jumbotron center-block">
                <h1>Login</h1>
                <form role="form">
                    <div className="form-group">
                        <label htmlFor="username">Username</label>
                        <input type="text"  valueLink={this.linkState('username')} className="form-control" id="username" placeholder="Username" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input type="password" valueLink={this.linkState('password')} className="form-control" id="password" ref="password" placeholder="Password" />
                    </div>
                    <button type="submit" className="btn btn-default" onClick={this.login.bind(this)}>Submit</button>
                </form>
            </div>
        );
    }

});
*/

class HelloMessage extends React.Component<HelloWorldProps, {}>
{
    render()
    {
        return(
            <h2>i like to eat</h2>
        );
    }
}

ReactDom.render
(
    <HelloMessage name="John" />,
    document.getElementById('example')

);


var Form =React.createClass({
    mixins: [ReactAddons.addons.LinkedStateMixin],

    getInitialState:function()
    {return{text: "test"};
    },

    render: function()
    {
        return(
            <div className="login jumbotron center-block">
                <h1>Login</h1>
                <form role="form">
                    <div className="form-group">
                        <label htmlFor="username">Username</label>
                        <input type="text"   valueLink={this.linkState("text")} className="form-control" id="username" placeholder="Username" />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input type="text"  valueLink={this.linkState("text")} className="form-control" id="password" ref="password" placeholder="Password" />
                    </div>
                </form>
            </div>
        )
    }
});

ReactDom.render
(
    <Form />,document.getElementById("user")
);


class Button extends React.Component<HelloWorldProps, {}>
{
    render()
    {
        return(
            <button type="submit" className="btn btn-default">Submit</button>
        );
    }
}

ReactDom.render
(
    <Button name="John" />,
    document.getElementById('hier')

);




