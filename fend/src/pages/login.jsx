import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Login() {
  const [name, setName] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.get(`http://localhost:6968/departments/name/${name}`);
      if (res.data) {
        navigate('/home');
      }
    } catch (err) {
      console.error(err);
      alert('Login failed. Department not found.');
    }
  };

  return (
    <div>
      <h2>Login with Department Name</h2>
      <form onSubmit={handleLogin}>
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Enter Department Name"
        /><br />
        <button type="submit">Login</button>
      </form>
    </div>
  );
}

export default Login;
