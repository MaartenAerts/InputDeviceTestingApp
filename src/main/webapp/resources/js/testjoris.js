/// <reference path="../typings/react/react.d.ts" />
///<reference path="../typings/react-dom/react-dom.d.ts"/>
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
define(["require", "exports", 'react', 'react-with-addons', 'react-dom'], function (require, exports, React, ReactAddons, ReactDom) {
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
    var Form = React.createClass({
        mixins: [ReactAddons.addons.LinkedStateMixin],
        getInitialState: function () {
            return { text: "test" };
        },
        render: function () {
            return React.createElement("div", null, React.createElement("input", {"type": "text", "valueLink": this.linkState("text")}), this.state.text);
        }
    });
    ReactDom.render(React.createElement(Form, null), document.getElementById("hier"));
    ReactDom.render(React.createElement(HelloMessage, {"name": "John"}), document.getElementById('example'));
});
//# sourceMappingURL=testjoris.js.map