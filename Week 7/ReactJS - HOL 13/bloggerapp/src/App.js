import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

const App = () => {
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);
  const [showCourses, setShowCourses] = useState(true);

  // Method 4: Using element variables for conditional rendering
  const toggleButtons = (
    <div>
      <button onClick={() => setShowBooks(!showBooks)}>
        Toggle Books
      </button>
      <button onClick={() => setShowBlogs(!showBlogs)}>
        Toggle Blogs
      </button>
      <button onClick={() => setShowCourses(!showCourses)}>
        Toggle Courses
      </button>
    </div>
  );

  return (
    <div>
      {toggleButtons}
      <div>
        <BookDetails showBooks={showBooks} />
        <BlogDetails showBlogs={showBlogs} />
        <CourseDetails showCourses={showCourses} />
      </div>
    </div>
  );
};

export default App;