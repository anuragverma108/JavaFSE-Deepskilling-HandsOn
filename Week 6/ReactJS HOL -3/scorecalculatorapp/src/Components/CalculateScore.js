import React, { useState } from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore() {
  const [name, setName] = useState('');
  const [school, setSchool] = useState('');
  const [total, setTotal] = useState('');
  const [goal, setGoal] = useState('');
  const [average, setAverage] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    const avg = total / goal;
    setAverage(avg.toFixed(2));
  };

  return (
    <div className="score-container">
      <h2>Student Score Calculator</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" placeholder="Name" value={name} onChange={(e) => setName(e.target.value)} required />
        <input type="text" placeholder="School" value={school} onChange={(e) => setSchool(e.target.value)} required />
        <input type="number" placeholder="Total Marks" value={total} onChange={(e) => setTotal(e.target.value)} required />
        <input type="number" placeholder="Number of Subjects" value={goal} onChange={(e) => setGoal(e.target.value)} required />
        <button type="submit">Calculate Average</button>
      </form>

      {average && (
        <div className="result">
          <p><strong>Name:</strong> {name}</p>
          <p><strong>School:</strong> {school}</p>
          <p><strong>Average Score:</strong> {average}</p>
        </div>
      )}
    </div>
  );
}

export default CalculateScore;
