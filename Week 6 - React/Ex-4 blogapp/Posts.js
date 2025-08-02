import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  // Fetching posts from API
  loadPosts = async () => {
    try {
      const res = await fetch('https://jsonplaceholder.typicode.com/posts');
      const data = await res.json();
      this.setState({ posts: data });
    } catch (error) {
      throw new Error("Failed to load posts");
    }
  };

  // Lifecycle hook – runs once after component mounts
  componentDidMount() {
    this.loadPosts();
  }

  // Lifecycle hook – catches errors
  componentDidCatch(error, info) {
    this.setState({ hasError: true });
    alert("An error occurred while loading posts.");
    console.error(error, info);
  }

  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong!</h2>;
    }

    return (
      <div style={{ padding: "20px" }}>
        <h1 style={{ textAlign: "center" }}>
          📚 Blog Posts
        </h1>
        <div style={{
          display: "flex",
          flexWrap: "wrap",
          justifyContent: "center"
        }}>
          {this.state.posts.slice(0, 18).map((post) => (
            <Post key={post.id} id={post.id} title={post.title} />
          ))}
        </div>
      </div>
    );
  }
}

export default Posts;
