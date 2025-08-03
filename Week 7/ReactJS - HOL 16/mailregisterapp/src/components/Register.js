import React, { Component } from 'react';

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: ''
      }
    };
  }

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        errors.fullName = 
          value.length < 5 
            ? 'Full Name must be at least 5 characters long!' 
            : '';
        break;
      case 'email':
        const validEmailRegex = 
          RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()\[\]\.,;:\s@\"]+\.)+[^<>()\[\]\.,;:\s@\"]{2,})$/i);
        errors.email = 
          validEmailRegex.test(value) 
            ? '' 
            : 'Email is not valid!';
        break;
      case 'password':
        errors.password = 
          value.length < 8 
            ? 'Password must be at least 8 characters long!' 
            : '';
        break;
      default:
        break;
    }

    this.setState({ errors, [name]: value });
  }

  validateForm = (errors) => {
    let valid = true;
    Object.values(errors).forEach(
      (val) => val.length > 0 && (valid = false)
    );
    return valid;
  }

  handleSubmit = (event) => {
    event.preventDefault();
    if (this.validateForm(this.state.errors)) {
      alert(`Registration Successful! ${this.state.fullName}`);


    } else {
      if (this.state.errors.fullName !== '') {
        alert(this.state.errors.fullName);
      }
      if (this.state.errors.email !== '') {
        alert(this.state.errors.email);
      }
      if (this.state.errors.password !== '') {
        alert(this.state.errors.password);
      }
    }
  }

  render() {
    const { errors } = this.state;
    return (
      <div className="register-form">
        <h1>Register Here!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name:</label>
            <input 
              type="text" 
              name="fullName" 
              value={this.state.fullName}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label>Email:</label>
            <input 
              type="text" 
              name="email" 
              value={this.state.email}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label>Password:</label>
            <input 
              type="password" 
              name="password" 
              value={this.state.password}
              onChange={this.handleChange}
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default Register;