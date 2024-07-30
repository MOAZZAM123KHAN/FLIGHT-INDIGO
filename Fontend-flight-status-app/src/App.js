import React from 'react';
import Header from './components/Header';
import FlightStatus from './components/FlightStatus';
import Notification from './components/Notification';
import './App.css';

function App() {
  return (
    <div className="App">
      <Header />
      <main>
        <FlightStatus />
        <Notification />
      </main>
    </div>
  );
}

export default App;
