import React from 'react';
import { books } from '../data';

// Method 1: Using && operator for conditional rendering
const BookDetails = ({ showBooks }) => {
  return (
    <div className="st2">
      <h1>Book Details</h1>
      {showBooks && (
        <ul>
          {books.map((book) => (
            <div key={book.id}>
              <h3>{book.bname}</h3>
              <h4>{book.price}</h4>
            </div>
          ))}
        </ul>
      )}
    </div>
  );
};

export default BookDetails;