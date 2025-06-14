import React, { useState } from 'react';
import axios from 'axios';
import {useNavigate} from 'react-router-dom';
function Register() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    departmentName: '',
    departmentAddress: '',
    departmentCode: '',
  });

  const handleChange = (e) => {
    setFormData({...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:6968/departments", formData);
      alert('Registered successfully!');
      navigate('/')
    } catch (err) {
      console.log("eroor is",err)
      c
      alert('Error during registration');
    }
  };

  return (
    <div>
      <h2>Register Department</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="departmentName" placeholder="Department Name" onChange={handleChange} /><br />
        <input type="text" name="departmentAddress" placeholder="Department Address" onChange={handleChange} /><br />
        <input type="text" name="departmentCode" placeholder="Department Code" onChange={handleChange} /><br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;
