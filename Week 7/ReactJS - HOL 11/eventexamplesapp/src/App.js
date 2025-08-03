import React, { useState } from 'react';
import './App.css';
import CurrencyConvertor from './components/CurrencyConvertor';

function App() {
  const [counter, setCounter] = useState(0);

  // Increment handler with multiple methods
  const handleIncrement = () => {
    incrementCounter();
    sayHello();
  };

  const incrementCounter = () => {
    setCounter(prevCounter => prevCounter + 1);
  };

  const sayHello = () => {
    console.log("Hello! The counter was incremented.");
  };

  // Decrement handler
  const handleDecrement = () => {
    setCounter(prevCounter => prevCounter - 1);
  };

  // Welcome message handler
  const sayWelcome = (message) => {
    alert(`${message} to our app!`);
  };

  // Click event handler
  const handleClick = (e) => {
    alert("I was clicked");
  };

  return (
    <div className="App">
      <h1>Event Examples</h1>
      
      <div className="counter-section">
        <h2>Counter: {counter}</h2>
        <button onClick={handleIncrement}>Increment</button>
        <button onClick={handleDecrement}>Decrement</button>
      </div>

      <div className="message-section">
        <button onClick={() => sayWelcome("Welcome")}>Say Welcome</button>
        <button onClick={handleClick}>Click on me</button>
      </div>

      <hr />
      
      <CurrencyConvertor />
    </div>
  );
}

export default App;