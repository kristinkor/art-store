// src/components/CustomerForm.js
import React, { useState } from 'react';

const CustomerForm = ({ onSubmit }) => {
  const [customer, setCustomer] = useState({
    name: '',
    email: '',
    password: '',
    addressLine1: '',
    addressLine2: '',
    city: '',
    state: '',
    zip: '',
    billingAddressLine1: '',
    billingAddressLine2: '',
    billingCity: '',
    billingState: '',
    billingZip: '',
    paymentMethod: '',
    cardNumber: '',
    cardExpiration: '',
    cardCVC: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCustomer({ ...customer, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(customer);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="name" value={customer.name} onChange={handleChange} placeholder="Name" required />
      <input name="email" value={customer.email} onChange={handleChange} placeholder="Email" required />
      <input name="password" value={customer.password} onChange={handleChange} placeholder="Password" type="password" required />
      <input name="addressLine1" value={customer.addressLine1} onChange={handleChange} placeholder="Address Line 1" required />
      <input name="addressLine2" value={customer.addressLine2} onChange={handleChange} placeholder="Address Line 2" />
      <input name="city" value={customer.city} onChange={handleChange} placeholder="City" required />
      <input name="state" value={customer.state} onChange={handleChange} placeholder="State" required />
      <input name="zip" value={customer.zip} onChange={handleChange} placeholder="ZIP Code" required />
      <input name="billingAddressLine1" value={customer.billingAddressLine1} onChange={handleChange} placeholder="Billing Address Line 1" />
      <input name="billingAddressLine2" value={customer.billingAddressLine2} onChange={handleChange} placeholder="Billing Address Line 2" />
      <input name="billingCity" value={customer.billingCity} onChange={handleChange} placeholder="Billing City" />
      <input name="billingState" value={customer.billingState} onChange={handleChange} placeholder="Billing State" />
      <input name="billingZip" value={customer.billingZip} onChange={handleChange} placeholder="Billing ZIP Code" />
      <input name="paymentMethod" value={customer.paymentMethod} onChange={handleChange} placeholder="Payment Method" />
      <input name="cardNumber" value={customer.cardNumber} onChange={handleChange} placeholder="Card Number" />
      <input name="cardExpiration" value={customer.cardExpiration} onChange={handleChange} placeholder="Card Expiration" />
      <input name="cardCVC" value={customer.cardCVC} onChange={handleChange} placeholder="Card CVC" />
      <button type="submit">Submit</button>
    </form>
  );
};

export default CustomerForm;
