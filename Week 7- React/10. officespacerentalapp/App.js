import React from 'react';
import './App.css';

function App() {
  const officeList = [
    {
      name: "Sky Tower",
      rent: 55000,
      address: "Chennai, TN",
      image: "https://via.placeholder.com/300x150?text=Sky+Tower"
    },
    {
      name: "Ocean View",
      rent: 72000,
      address: "Mumbai, MH",
      image: "https://via.placeholder.com/300x150?text=Ocean+View"
    },
    {
      name: "Tech Park",
      rent: 60000,
      address: "Bangalore, KA",
      image: "https://via.placeholder.com/300x150?text=Tech+Park"
    }
  ];

  return (
    <div className="App">
      <h1>🏢 Office Space Rental</h1>
      {officeList.map((office, index) => (
        <div key={index} style={{ border: '1px solid #ddd', margin: '10px', padding: '10px' }}>
          <h2>{office.name}</h2>
          <img src={office.image} alt={office.name} style={{ width: '300px' }} />
          <p><strong>Address:</strong> {office.address}</p>
          <p>
            <strong>Rent:</strong>{' '}
            <span style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
              ₹{office.rent}
            </span>
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;
