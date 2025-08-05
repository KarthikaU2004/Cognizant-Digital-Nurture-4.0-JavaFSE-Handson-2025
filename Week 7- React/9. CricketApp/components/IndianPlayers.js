import React from 'react';

const IndianPlayers = () => {
  const teamPlayers = ['Rohit', 'Kohli', 'Gill', 'Rahul', 'Iyer', 'Pant'];

  const oddPlayers = teamPlayers.filter((_, i) => i % 2 === 0);
  const evenPlayers = teamPlayers.filter((_, i) => i % 2 !== 0);

  const T20 = ['Hardik', 'Surya', 'DK'];
  const Ranji = ['Shaw', 'Jaiswal', 'Sarfaraz'];
  const mergedPlayers = [...T20, ...Ranji];

  return (
    <div>
      <h2>Odd Players</h2>
      <ul>
        {oddPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Even Players</h2>
      <ul>
        {evenPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Merged Players (T20 + Ranji)</h2>
      <ul>
        {mergedPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;
