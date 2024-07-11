// src/App.js
import React from 'react';
import './App.css';
import CustomerForm from './components/CustomerForm';

function App() {
  const handleFormSubmit = (customerData) => {
    console.log(customerData);

  };

  return (
    <div className="App">
      <h1>Art Store</h1>
      <CustomerForm onSubmit={handleFormSubmit} />
    </div>
  );
}

export default App;
