import React from 'react';
import logo from './logo512.png';
import Link from 'react-router';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <Link to="/countries">Start Country Filter</Link>
        <p>This is my first React app.. go easy on me.</p>
      </header>
    </div>
  );
}

export default App;
