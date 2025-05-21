import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Register from './pages/registe';
import Login from './pages/login';
import Home from './pages/home';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/home" element={<Home />} />
    </Routes>
  );
}

export default App;
