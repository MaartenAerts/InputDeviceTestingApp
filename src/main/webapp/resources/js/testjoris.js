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
    /*
    
    //test
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
    var HelloMessage = (function (_super) {
        __extends(HelloMessage, _super);
        function HelloMessage() {
            _super.apply(this, arguments);
        }
        HelloMessage.prototype.render = function () {
            return (React.createElement("h2", null, "i like to eat"));
        };
        return HelloMessage;
    })(React.Component);
    ReactDom.render(React.createElement(HelloMessage, {"name": "John"}), document.getElementById('example'));
    var Form = React.createClass({
        mixins: [ReactAddons.addons.LinkedStateMixin],
        getInitialState: function () {
            return { text: "test" };
        },
        render: function () {
            return (React.createElement("div", {"className": "login jumbotron center-block"}, React.createElement("h1", null, "Login"), React.createElement("form", {"role": "form"}, React.createElement("div", {"className": "form-group"}, React.createElement("label", {"htmlFor": "username"}, "Username"), React.createElement("input", {"type": "text", "valueLink": this.linkState("text"), "className": "form-control", "id": "username", "placeholder": "Username"})), React.createElement("div", {"className": "form-group"}, React.createElement("label", {"htmlFor": "password"}, "Password"), React.createElement("input", {"type": "text", "valueLink": this.linkState("text"), "className": "form-control", "id": "password", "ref": "password", "placeholder": "Password"})))));
        }
    });
    ReactDom.render(React.createElement(Form, null), document.getElementById("user"));
    var Button = (function (_super) {
        __extends(Button, _super);
        function Button() {
            _super.apply(this, arguments);
        }
        Button.prototype.render = function () {
            return (React.createElement("button", {"type": "submit", "className": "btn btn-default"}, "Submit"));
        };
        return Button;
    })(React.Component);
    ReactDom.render(React.createElement(Button, {"name": "John"}), document.getElementById('hier'));
});
//# sourceMappingURL=testjoris.js.map