/// <reference path="../typings/react/react.d.ts" />
/// <reference path="../typings/requirejs/require.d.ts" />


///<amd-dependency path="../bower_components/requirejs/require" />

import React = require('react')


declare var mountNode: any;

interface HelloWorldProps extends React.Props<any> {
    name: string;
}
class HelloMessage extends React.Component<HelloWorldProps, {}> {
    render() {
        return <div>Hello {this.props.name}</div>;
    }
}

React.render(<HelloMessage name="John" />,    document.getElementById('example'));


