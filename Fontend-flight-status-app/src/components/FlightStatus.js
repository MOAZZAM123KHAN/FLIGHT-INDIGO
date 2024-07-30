import React, { useState, useEffect } from 'react';

const FlightStatus = () => {
  const [flightData, setFlightData] = useState([]);

  useEffect(() => {
    // Fetch mock data
    fetch('/mock-data/flights.json')
      .then((response) => response.json())
      .then((data) => setFlightData(data))
      .catch((error) => console.error('Error fetching flight data:', error));
  }, []);

  return (
    <div>
      <h2>Flight Status</h2>
      <ul>
        {flightData.map((flight, index) => (
          <li key={index}>
            Flight {flight.flightNumber}: {flight.status} (Gate: {flight.gate})
          </li>
        ))}
      </ul>
    </div>
  );
};

export default FlightStatus;
