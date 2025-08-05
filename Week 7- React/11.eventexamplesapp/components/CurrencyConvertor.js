import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    const conversionRate = 0.011; // 1 INR = 0.011 Euro (example rate)
    setEuro((rupees * conversionRate).toFixed(2));
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>Rupees: </label>
        <input
          type="number"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
        />
        <button type="submit">Convert</button>
      </form>
      {euro !== null && <p>Converted Euro: €{euro}</p>}
    </div>
  );
}

export default CurrencyConvertor;
