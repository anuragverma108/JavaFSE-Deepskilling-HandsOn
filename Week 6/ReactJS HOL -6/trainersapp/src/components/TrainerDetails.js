import React from 'react';
import { useParams } from 'react-router-dom';
import trainersMock from '../data/TrainersMock';

function TrainerDetails() {
    const { id } = useParams();
    const trainer = trainersMock.find(t => t.trainerId === id);

    if (!trainer) {
        return <div>Trainer not found</div>;
    }

    return (
        <div>
            <h2>Trainers Details</h2>
            <p><strong>{trainer.name} ({trainer.technology})</strong></p>
            <p>{trainer.email}</p>
            <p>{trainer.phone}</p>
            <ul>
                {trainer.skills.map((skill, index) => (
                    <li key={index}>{skill}</li>
                ))}
            </ul>
        </div>
    );
}

export default TrainerDetails;