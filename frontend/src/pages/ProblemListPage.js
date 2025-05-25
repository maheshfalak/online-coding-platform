import React, { useState, useEffect } from 'react';
import ProblemCard from '../components/ProblemCard';
import api from '../services/api';
import './ProblemListPage.css';

const ProblemListPage = () => {
  const [problems, setProblems] = useState([]);
  const [loading, setLoading] = useState(true);
  const [filter, setFilter] = useState('all');
  const [searchTerm, setSearchTerm] = useState('');

  useEffect(() => {
    const fetchProblems = async () => {
      try {
        let response;
        if (filter !== 'all') {
          response = await api.getProblemsByDifficulty(filter);
        } else if (searchTerm) {
          response = await api.searchProblems(searchTerm);
        } else {
          response = await api.getProblems();
        }
        setProblems(response.data);
        setLoading(false);
      } catch (error) {
        console.error('Error fetching problems:', error);
        setLoading(false);
      }
    };

    fetchProblems();
  }, [filter, searchTerm]);

  const handleFilterChange = (e) => {
    setFilter(e.target.value);
  };

  const handleSearch = (e) => {
    e.preventDefault();
    // Search is triggered by the useEffect
  };

  return (
    <div className="problem-list-page">
      <h1>Coding Problems</h1>

      <div className="problem-filters">
        <div className="filter-group">
          <label htmlFor="difficulty">Filter by Difficulty:</label>
          <select
            id="difficulty"
            value={filter}
            onChange={handleFilterChange}
            className="filter-select"
          >
            <option value="all">All Difficulties</option>
            <option value="Easy">Easy</option>
            <option value="Medium">Medium</option>
            <option value="Hard">Hard</option>
          </select>
        </div>

        <form onSubmit={handleSearch} className="search-form">
          <input
            type="text"
            placeholder="Search problems..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            className="search-input"
          />
          <button type="submit" className="search-button">
            Search
          </button>
        </form>
      </div>

      {loading ? (
        <div className="loading">Loading problems...</div>
      ) : problems.length === 0 ? (
        <div className="no-problems">No problems found</div>
      ) : (
        <div className="problem-grid">
          {problems.map((problem) => (
            <ProblemCard key={problem.id} problem={problem} />
          ))}
        </div>
      )}
    </div>
  );
};

export default ProblemListPage; 