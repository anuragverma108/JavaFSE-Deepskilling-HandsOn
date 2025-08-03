import React, { Component } from 'react';

class CountPeople extends Component {
  constructor() {
    super();
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  updateEntry() {
    this.setState((prevState) => {
      return { entrycount: prevState.entrycount + 1 };
    });
  }

  updateExit() {
    this.setState((prevState) => {
      return { exitcount: prevState.exitcount + 1 };
    });
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <button 
          onClick={() => this.updateEntry()} 
          style={{ margin: '10px', padding: '10px 20px' }}
        >
          Login
        </button>
        <span> | {this.state.entrycount} People Entered!!!</span>
        
        <br /><br />
        
        <button 
          onClick={() => this.updateExit()} 
          style={{ margin: '10px', padding: '10px 20px' }}
        >
          Exit
        </button>
        <span> | {this.state.exitcount} People Left!!!</span>
      </div>
    );
  }
}

export default CountPeople;