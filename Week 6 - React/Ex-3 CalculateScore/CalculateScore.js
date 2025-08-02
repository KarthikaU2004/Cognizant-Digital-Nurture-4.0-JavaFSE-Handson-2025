import React, { useState } from 'react';
import './../Stylesheets/mystyle.css';  // Ensure correct import of CSS

const CalculateScore = ({ name, school, total, goal }) => {
  const [averageScore, setAverageScore] = useState(null);

  // Function to calculate average score
  const calculateAverage = () => {
    const average = (goal / total) * 100;
    setAverageScore(average);
  };

  return (
    <div className="student-details">
      <h2>Student Details:</h2>
      <p><span className="label">Name: </span><span className="value">{name}</span></p>
      <p><span className="label">School: </span><span className="value">{school}</span></p>
      <p><span className="label">Total Marks: </span><span className="value">{total} Marks</span></p>
      <p><span className="label">Score: </span><span className="value">{goal}</span></p>

      <button onClick={calculateAverage}>Calculate Average Score</button>
      {averageScore !== null && <p><span className="label">Average Score: </span><span className="value">{averageScore.toFixed(2)}%</span></p>}
    </div>
  );
};

export default CalculateScore;
