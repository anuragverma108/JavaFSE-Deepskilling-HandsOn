import React, { useState } from 'react';
import './App.css';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  // Sample flight data
  const flights = [
    { id: 1, flightNumber: 'AA123', departure: 'New York', arrival: 'London', time: '10:00 AM', price: '$450' },
    { id: 2, flightNumber: 'BA456', departure: 'London', arrival: 'Paris', time: '2:30 PM', price: '$200' },
    { id: 3, flightNumber: 'DL789', departure: 'Los Angeles', arrival: 'Tokyo', time: '9:15 PM', price: '$850' }
  ];

  return (
    <div className="App">
      <header className="app-header">
        <h1>Ticket Booking App</h1>
        {isLoggedIn ? (
          <div className="user-header">
            <button onClick={handleLogout} className="logout-button">Logout</button>
            <h2>Welcome Back, User!</h2>
            <p>You can now book your flight tickets.</p>
          </div>
        ) : (
          <div className="guest-header">
            <h2>Welcome, Guest!</h2>
            <p>You can browse flight details here, but booking requires login.</p>
            <button onClick={handleLogin} className="login-button">Login</button>
          </div>
        )}
      </header>

      <div className="flight-container">
        <h3>Available Flights</h3>
        <div className="flight-list">
          {flights.map(flight => (
            <div key={flight.id} className="flight-card">
              <div className="flight-info">
                <span className="flight-number">{flight.flightNumber}</span>
                <span className="flight-route">{flight.departure} → {flight.arrival}</span>
                <span className="flight-time">Departure: {flight.time}</span>
                {isLoggedIn && <span className="flight-price">Price: {flight.price}</span>}
              </div>
              {isLoggedIn && (
                <button className="book-button">Book Now</button>
              )}
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;