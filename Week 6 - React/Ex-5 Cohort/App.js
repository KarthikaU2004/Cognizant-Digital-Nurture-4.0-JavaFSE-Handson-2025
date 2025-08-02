import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  const cohorts = [
    {
      name: 'INTADMDF10 - .NET FSD',
      started: '22-Feb-2022',
      status: 'Scheduled',
      coach: 'Aathma',
      trainer: 'Jojo Jose',
    },
    {
      name: 'ADM21JF014 - Java FSD',
      started: '10-Sep-2021',
      status: 'Ongoing',
      coach: 'Apoorv',
      trainer: 'Elisa Smith',
    },
    {
      name: 'CDBJF21025 - Java FSD',
      started: '24-Dec-2021',
      status: 'Ongoing',
      coach: 'Aathma',
      trainer: 'John Doe',
    },
  ];

  return (
    <div style={{ padding: '20px' }}>
      <h2>Cohorts Details</h2>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;