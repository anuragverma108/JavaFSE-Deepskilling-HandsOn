import React, { Component } from 'react';

class ComplaintRegister extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ename: '',
            complaint: '',
            NumberHolder: Math.floor(Math.random() * 10000) // Generate random reference number
        };
        
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({ [event.target.name]: event.target.value });
    }

    handleSubmit(event) {
        var msg = 'Thanks ' + this.state.ename + 
                 '\nYour Complaint was Submitted. ID is: ' + this.state.NumberHolder;
        alert(msg);
        event.preventDefault();
    }

    render() {
        return (
            <div style={{ maxWidth: "500px", margin: "auto" }}>
                <h1>Register your complaints here!!!</h1>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <label>Name:</label><br />
                        <input 
                            type="text" 
                            name="ename" 
                            value={this.state.ename} 
                            onChange={this.handleChange} 
                            placeholder="Enter your name"
                        />
                    </div>
                    <div>
                        <label>Complaint:</label><br />
                        <textarea 
                            name="complaint" 
                            value={this.state.complaint} 
                            onChange={this.handleChange} 
                            placeholder="Describe your complaint"
                            rows="4"
                            cols="50"
                        />
                    </div>
                    <br />
                    <input type="submit" value="Submit" />
                </form>
            </div>
        );
    }
}

export default ComplaintRegister;