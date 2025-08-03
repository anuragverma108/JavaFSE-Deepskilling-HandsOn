import React, { Component } from 'react';

class Getuser extends Component {
    constructor(props) {
        super(props);
        this.state = {
            person: null,
            loading: true
        };
    }

    async componentDidMount() {
        const url = "https://api.randomuser.me/";
        const response = await fetch(url);
        const data = await response.json();
        this.setState({ 
            person: data.results[0],
            loading: false
        });
        console.log(data.results[0]);
    }

    render() {
        if (this.state.loading) {
            return <div>Loading...</div>;
        }

        if (!this.state.person) {
            return <div>No user data found</div>;
        }

        const { title, first, last } = this.state.person.name;
        const { large } = this.state.person.picture;

        return (
            <div className="user-container">
                <h1>{title} {first} {last}</h1>
                <img src={large} alt={`${first} ${last}`} />
            </div>
        );
    }
}

export default Getuser;