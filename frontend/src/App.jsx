import { Routes, Route, Link } from "react-router-dom";
import React from "react";
import iqbusiness from '/images/iq.png'
import './App.css'
import Signup from './Signup.jsx';
import Survey from "./Survey";

function App() {
  return (
    <>
      <div>
        <a href="https://iqbusiness.net/" target="_blank">
          <img src={iqbusiness} className="logo" alt="iq logo" />
        </a>
      </div>
      <h1>IQBusiness Survey Prep</h1>
      <div className="card">
        <button>
          <Link to="/signup">Go to Signup</Link>
        </button>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/survey" element={<Survey />} />
        </Routes>
      </div>
     
    </>
  )
}

function Home() {
  return (
    <div>
      <p>Click "Go to Signup" to get started.</p>
    </div>
  );
}

export default App