import React from 'react';

function SyntheticEvent() {
  const handleClick = (event) => {
    alert("I was clicked!");
    console.log("SyntheticEvent object:", event);
  };

  return (
    <div style={{ marginBottom: '30px' }}>
      <button onClick={handleClick}>Click Me (Synthetic Event)</button>
    </div>
  );
}

export default SyntheticEvent;
