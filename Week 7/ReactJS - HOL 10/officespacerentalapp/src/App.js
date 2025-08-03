import React from 'react';
import './App.css';

function App() {
  // Office space data
  const officeSpaces = [
    { Name: "DBS", Rent: 50000, Address: "Chennai", image: "office1.jpg" },
    { Name: "Tech Park", Rent: 75000, Address: "Bangalore", image: "office2.jpg" },
    { Name: "Business Center", Rent: 45000, Address: "Mumbai", image: "office3.jpg" },
    { Name: "Innovation Hub", Rent: 65000, Address: "Hyderabad", image: "office4.jpg" }
  ];

  // Function to determine rent color
  const getRentColor = (rent) => {
    return rent <= 60000 ? 'textRed' : 'textGreen';
  };

  return (
    <div className="App">
      <h1>Office Space at Affordable Range</h1>
      
      {officeSpaces.map((office, index) => (
        <div key={index} className="office-card">
          <img 
            src={office.image} 
            width="25%" 
            height="25%" 
            alt={`Office Space ${index + 1}`} 
          />
          <h2>Name: {office.Name}</h2>
          <h3 className={getRentColor(office.Rent)}>Rent: Rs. {office.Rent}</h3>
          <h3>Address: {office.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;