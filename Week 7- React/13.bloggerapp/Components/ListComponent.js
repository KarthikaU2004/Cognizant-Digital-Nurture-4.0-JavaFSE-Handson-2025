import React from 'react';

function ListComponent() {
  const topics = ['React', 'Node.js', 'MongoDB'];

  return (
    <div>
      <h3>📋 Topics</h3>
      <ul>
        {topics.map((topic, index) => (
          <li key={index}>{topic}</li> // key is important for performance
        ))}
      </ul>
    </div>
  );
}

export default ListComponent;
