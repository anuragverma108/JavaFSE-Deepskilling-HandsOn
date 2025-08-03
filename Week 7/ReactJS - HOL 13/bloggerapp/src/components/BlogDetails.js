import React from 'react';
import { blogs } from '../data';

// Method 2: Using ternary operator for conditional rendering
const BlogDetails = ({ showBlogs }) => {
  return (
    <div className="v1">
      <h1>Blog Details</h1>
      {showBlogs ? (
        <ul>
          {blogs.map((blog) => (
            <div key={blog.id}>
              <h3>{blog.title}</h3>
              <p>Author: {blog.author}</p>
              <p>{blog.content}</p>
            </div>
          ))}
        </ul>
      ) : (
        <p>Blogs are currently hidden</p>
      )}
    </div>
  );
};

export default BlogDetails;