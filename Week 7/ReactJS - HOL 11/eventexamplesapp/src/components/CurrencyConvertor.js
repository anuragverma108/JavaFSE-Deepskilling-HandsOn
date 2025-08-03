import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('Euro');
  const [convertedAmount, setConvertedAmount] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    
    if (!amount || isNaN(amount)) {
      alert("Please enter a valid amount");
      return;
    }

    const amountNum = parseFloat(amount);
    let result;
    
    if (currency === 'Euro') {
      // Convert INR to Euro (approximate rate: 1 Euro = 90 INR)
      result = amountNum * 90;
      alert(`Converting to Euro. Amount is ${result}`);
    } else {
      // Convert Euro to INR
      result = amountNum / 90;
      alert(`Converting to INR. Amount is ${result}`);
    }
    
    setConvertedAmount(result);
  };

  return (
    <div className="currency-convertor">
      <h1>Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>
            Amount:
            <input 
              type="number" 
              value={amount} 
              onChange={(e) => setAmount(e.target.value)} 
            />
          </label>
        </div>
        <div>
          <label>
            Currency:
            <select 
              value={currency} 
              onChange={(e) => setCurrency(e.target.value)}
            >
              <option value="Euro">Euro</option>
              <option value="INR">INR</option>
            </select>
          </label>
        </div>
        <button type="submit">Submit</button>
      </form>
      
      {convertedAmount !== null && (
        <div className="result">
          <h3>Converted Amount: {convertedAmount.toFixed(2)} {currency === 'Euro' ? 'INR' : 'Euro'}</h3>
        </div>
      )}
    </div>
  );
};

export default CurrencyConvertor;