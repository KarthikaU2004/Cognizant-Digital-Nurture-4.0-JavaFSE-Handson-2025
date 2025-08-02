import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScore';  // Make sure the path is correct

function App() {
  return (
    <div className="App">
      <CalculateScore 
        name="Steeve"
        school="DNV Public School"
        total={300}
        goal={284}
      />
    </div>
  );
}

export default App;
