import React from 'react';
import { Link } from 'react-router-dom';
import './ProblemCard.css';

const ProblemCard = ({ problem }) => {
  const getDifficultyColor = (level) => {
    switch (level.toLowerCase()) {
      case 'easy':
        return '#4caf50';
      case 'medium':
        return '#ff9800';
      case 'hard':
        return '#f44336';
      default:
        return '#2196f3';
    }
  };

  return (
    <div className="problem-card">
      <h3 className="problem-title">
        <Link to={`/problems/${problem.id}`}>{problem.title}</Link>
      </h3>
      <div className="problem-info">
        <span
          className="problem-difficulty"
          style={{ backgroundColor: getDifficultyColor(problem.difficultyLevel) }}
        >
          {problem.difficultyLevel}
        </span>
      </div>
      <p className="problem-description">
        {problem.description.length > 150
          ? `${problem.description.substring(0, 150)}...`
          : problem.description}
      </p>
      <Link to={`/problems/${problem.id}`} className="solve-btn">
        Solve Problem
      </Link>
    </div>
  );
};

export default ProblemCard; 