import React from 'react';
import { Link } from 'react-router-dom';
import './HomePage.css';

const HomePage = () => {
  return (
    <div className="home-page">
      <div className="hero-section">
        <h1>Welcome to the Online Coding Platform</h1>
        <p>Practice coding problems and improve your programming skills</p>
        <Link to="/problems" className="cta-button">
          Start Coding
        </Link>
      </div>

      <div className="features-section">
        <h2>Features</h2>
        <div className="features-grid">
          <div className="feature-card">
            <h3>Various Problem Difficulty</h3>
            <p>Practice problems from easy to hard difficulty levels</p>
          </div>
          <div className="feature-card">
            <h3>Code Online</h3>
            <p>Write and run your code directly in the browser</p>
          </div>
          <div className="feature-card">
            <h3>Multiple Languages</h3>
            <p>Code in multiple programming languages</p>
          </div>
          <div className="feature-card">
            <h3>Track Progress</h3>
            <p>Keep track of your solutions and submissions</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default HomePage; 