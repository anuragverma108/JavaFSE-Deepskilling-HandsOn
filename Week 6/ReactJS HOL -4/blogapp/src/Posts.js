import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts = async () => {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts');
      if (!response.ok) throw new Error('Failed to fetch posts');
      const data = await response.json();

      const postObjects = data.map(p => new Post(p.userId, p.id, p.title, p.body));
      this.setState({ posts: postObjects });
    } catch (err) {
      this.setState({ error: err.message });
      throw err;
    }
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert("An error occurred: " + error);
  }

  render() {
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.length > 0 ? (
          this.state.posts.map(post => (
            <div key={post.id}>
              <h3>{post.title}</h3>
              <p>{post.body}</p>
              <hr />
            </div>
          ))
        ) : (
          <p>Loading posts...</p>
        )}
      </div>
    );
  }
}

export default Posts;
