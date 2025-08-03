import React from 'react';
import ListofPlayers from './components/ListofPlayers';
import Scorebelow70 from './components/Scorebelow70';
import { OddPlayers, EvenPlayers, ListofIndianPlayers } from './components/IndianPlayers';

function App() {
    
    const flag = false; 

    const players = [
        { name: "Mr. Jack", score: 50 },
        { name: "Mr. Michael", score: 70 },
        { name: "Mr. John", score: 40 },
        { name: "Mr. Ann", score: 61 },
        { name: "Mr. Elisabeth", score: 61 },
        { name: "Mr. Sachin", score: 95 },
        { name: "Mr. Dhoni", score: 100 },
        { name: "Mr. Virat", score: 84 },
        { name: "Mr. Jadeja", score: 64 },
        { name: "Mr. Raina", score: 75 },
        { name: "Mr. Rohit", score: 80 }
    ];

    const IndianTeam = [
        { id: 1, name: "Sachin" },
        { id: 2, name: "Dhoni" },
        { id: 3, name: "Virat" },
        { id: 4, name: "Rohit" },
        { id: 5, name: "Yuvaraj" },
        { id: 6, name: "Raina" }
    ];

    if (flag === true) {
        return (
            <div>
                <h1>List of Players</h1>
                <ListofPlayers players={players} />
                <h1>List of Players having Scores Less than 70</h1>
                <Scorebelow70 players={players} />
            </div>
        );
    } else {
        return (
            <div>
                <h1>Indian Team</h1>
                <h1>Odd Players</h1>
                <OddPlayers players={IndianTeam} />
                <h1>Even Players</h1>
                <EvenPlayers players={IndianTeam} />
                
                <hr/>
                <div>
                    <h1>List of Indian Players Merged:</h1>
                    <ListofIndianPlayers IndianPlayers={IndianTeam} />
                </div>
            </div>
        );
    }
}

export default App;