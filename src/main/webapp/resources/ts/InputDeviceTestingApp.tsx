/// <reference path="../typings/react/react.d.ts" />
///<reference path="../typings/react-dom/react-dom.d.ts"/>
///<reference path="../typings/reflux.d.ts"/>

'use strict';

import * as React from 'react'
import * as ReactAddons from 'react-with-addons'
import * as ReactDom from 'react-dom'
import * as Reflux from 'reflux'
import * as ReactRouter from 'react-router'



var InputDeviceTestingActions = Reflux.createActions([
    "toggleItem",
    "toggleAllItems",
    "addItem",
    "removeItem",
    "clearCompleted",
    "editItem"
]);



var routes = (
    <ReactRouter.Route handler={TodoApp}>
        <ReactRouter.Route name="All" path="/" handler={TodoMain} />
        <ReactRouter.Route name="Completed" path="/completed" handler={TodoMain} />
        <ReactRouter.Route name="Active" path="/active" handler={TodoMain} />
    </ReactRouter.Route>
);

ReactRouter.run(routes, function(Handler) {
    React.render(<Handler/>, document.getElementById('todoapp'));
});




// Renders the full application
// RouteHandler will always be TodoMain, but with different 'showing' prop (all/completed/active)
var DeviceTestingApp = React.createClass({
    // this will cause setState({list:updatedlist}) whenever the store does trigger(updatedlist)
    mixins: [Reflux.connect(inputDeviceTestingStore,"list")],
    getInitialState: function() {
        return {
            list: []
        };
    },
    render: function() {
        return (
            <div>
                <TodoHeader />
                <ReactRouter.RouteHandler list={this.state.list} />
                <TodoFooter list={this.state.list} />
            </div>
        );
    }
});