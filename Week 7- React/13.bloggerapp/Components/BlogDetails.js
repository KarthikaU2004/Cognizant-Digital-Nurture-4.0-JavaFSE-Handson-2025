
import React from "react";

const BlogDetails = ({ blogs }) => {
  return (
    <div className="section">
      <h1>Blog Details</h1>
      {blogs.map((blog, index) => (
        <div key={index}>
          <h3>{blog.title}</h3>
          <h5>{blog.author}</h5>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
};

export default BlogDetails;