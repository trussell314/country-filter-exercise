import React from 'react';
import logo from './logo512.png';
import { BrowserRouter as Router, Link, Switch, Route } from 'react-router-dom';
import CountryFilter from './CountryFilter'
import './App.css';

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/">
            <header className="App-header">
              <img src={logo} className="App-logo" alt="logo" />
              <Link to="/countryFilter">Start Country Filter</Link>
              <p>This is my first React app... go easy on me</p>
            </header>
          </Route>
          <Route path="/countryFilter">
            <CountryFilter />
          </Route>
        </Switch>
      </Router>
      
      <div>
      
      </div>
    </div>
  );
}

export default App;
