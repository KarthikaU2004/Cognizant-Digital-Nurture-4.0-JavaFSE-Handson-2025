import React from 'react';
import Counter from './components/Counter';
import SayWelcome from './components/SayWelcome';
import SyntheticEvent from './components/SyntheticEvent';
import CurrencyConvertor from './components/CurrencyConvertor';

function App() {
  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h1>React Event Handling Example</h1>
      <Counter />
      <SayWelcome />
      <SyntheticEvent />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
