import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import TrainersList from './components/TrainerList';
import TrainerDetails from './components/TrainerDetails';

function App() {
    return (
        <Router>
            <div>
                <h1>My Academy Trainers App</h1>
                <nav>
                    <Link to="/">Home</Link> | <Link to="/trainers">Show Trainers</Link>
                </nav>
                
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/trainers" element={<TrainersList />} />
                    <Route path="/trainers/:id" element={<TrainerDetails />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;