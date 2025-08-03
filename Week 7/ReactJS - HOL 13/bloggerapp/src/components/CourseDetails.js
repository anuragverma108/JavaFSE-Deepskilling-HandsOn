import React from 'react';
import { courses } from '../data';

// Method 3: Using separate function for conditional rendering
const CourseDetails = ({ showCourses }) => {
  const renderCourses = () => {
    if (!showCourses) return null;
    
    return (
      <ul>
        {courses.map((course) => (
          <div key={course.id}>
            <h3>{course.cname}</h3>
            <p>Date: {course.date}</p>
          </div>
        ))}
      </ul>
    );
  };

  return (
    <div className="mystyle1">
      <h1>Course Details</h1>
      {renderCourses()}
    </div>
  );
};

export default CourseDetails;