import React from 'react';

function SayWelcome() {
  const greet = (msg) => {
    alert(`Message: ${msg}`);
  };

  return (
    <div style={{ marginBottom: '30px' }}>
      <button onClick={() => greet("Welcome!")}>Say Welcome</button>
    </div>
  );
}

export default SayWelcome;
