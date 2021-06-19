import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ReferenceList from './ReferenceList';
import ReferenceEdit from "./ReferenceEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/reference' exact={true} component={ReferenceList}/>
            <Route path='/reference/:id' component={ReferenceEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;