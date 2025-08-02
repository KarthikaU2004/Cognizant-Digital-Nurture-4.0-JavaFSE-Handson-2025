import React from 'react';

function Post({ id, title }) {
  return (
    <div style={styles.card}>
      <h3>{id}</h3>
      <p>{title}</p>
    </div>
  );
}

const styles = {
  card: {
    border: "1px solid #ddd",
    padding: "20px",
    margin: "10px",
    borderRadius: "8px",
    textAlign: "center",
    width: "30%",
  },
};

export default Post;
