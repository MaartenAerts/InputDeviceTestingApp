/// <reference path="../typings/react/react.d.ts" />
///<reference path="../typings/react-dom/react-dom.d.ts"/>
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", 'react', 'react-with-addons', 'react-dom'], function (require, exports, React, ReactAddons, ReactDom) {
    var Login = (function (_super) {
        __extends(Login, _super);
        function Login(props) {
            _super.call(this, props);
            this.state =
                {
                    username: '',
                    password: ''
                };
        }
        return Login;
    })(React.Component);
    var LoginForm = React.createClass({
        mixins: [ReactAddons.addons.LinkedStateMixin],
        getInitialState: function () {
            return { username: 'leeeg' };
        },
        render: function () {
            return (React.createElement("div", {"className": "login jumbotron center-block"}, React.createElement("h1", null, "Login"), React.createElement("form", {"role": "form"}, React.createElement("div", {"className": "form-group"}, React.createElement("label", {"htmlFor": "username"}, "Username"), React.createElement("input", {"type": "text", "valueLink": this.linkState('username'), "className": "form-control", "id": "username", "placeholder": "Username"})), React.createElement("div", {"className": "form-group"}, React.createElement("label", {"htmlFor": "password"}, "Password"), React.createElement("input", {"type": "password", "valueLink": this.linkState('password'), "className": "form-control", "id": "password", "ref": "password", "placeholder": "Password"})), React.createElement("button", {"type": "submit", "className": "btn btn-default", "onClick": this.login.bind(this)}, "Submit"))));
        }
    });
    /*
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
    
    */
    ReactDom.render(React.createElement(LoginForm, null), document.getElementById("hier"));
});
/*
class HelloMessage extends React.Component<HelloWorldProps, {}>
{
    render()
    {
        return (
            <h2>i like to eat</h2>
        );
    }
}


ReactDom.render
(
    <HelloMessage name="John" />,
    document.getElementById('example')

)
*/ 
//# sourceMappingURL=testjoris.js.map