import React from 'react';

export const OddPlayers = ({ players }) => {
    return (
        <ul>
            {players.filter(player => player.id % 2 !== 0).map(player => (
                <li key={player.id}>{player.name}{player.id}</li>
            ))}
        </ul>
    );
};

export const EvenPlayers = ({ players }) => {
    return (
        <ul>
            {players.filter(player => player.id % 2 === 0).map(player => (
                <li key={player.id}>{player.name}{player.id}</li>
            ))}
        </ul>
    );
};


export const ListofIndianPlayers = ({ IndianPlayers }) => {

    const mergedPlayers = [
        "First Player",
        "Second Player", 
        "Third Player",
        "Fourth Player",
        "Fifth Player",
        "Sixth Player"
    ];

    return (
        <ul>
            {mergedPlayers.map((player, index) => (
                <li key={index}>Mr. {player}</li>
            ))}
        </ul>
    );
};