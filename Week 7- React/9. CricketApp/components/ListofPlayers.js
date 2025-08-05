import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Rohit', score: 80 },
    { name: 'Kohli', score: 65 },
    { name: 'Gill', score: 90 },
    { name: 'Rahul', score: 45 },
    { name: 'Iyer', score: 75 },
    { name: 'Pant', score: 30 },
    { name: 'Jadeja', score: 50 },
    { name: 'Bumrah', score: 85 },
    { name: 'Shami', score: 40 },
    { name: 'Siraj', score: 70 },
    { name: 'Kuldeep', score: 60 }
  ];

  const filteredPlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h2>Players with score below 70</h2>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
