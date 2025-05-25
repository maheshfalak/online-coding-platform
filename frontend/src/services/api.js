import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

const api = {
  // Problem related API calls
  getProblems: () => {
    return axios.get(`${API_BASE_URL}/problems`);
  },

  getProblemById: (id) => {
    return axios.get(`${API_BASE_URL}/problems/${id}`);
  },

  getProblemsByDifficulty: (level) => {
    return axios.get(`${API_BASE_URL}/problems/difficulty/${level}`);
  },

  searchProblems: (keyword) => {
    return axios.get(`${API_BASE_URL}/problems/search?keyword=${keyword}`);
  },

  // Submission related API calls
  submitCode: (submissionData) => {
    return axios.post(`${API_BASE_URL}/submissions`, submissionData);
  },

  getUserSubmissions: (userId) => {
    return axios.get(`${API_BASE_URL}/submissions/user/${userId}`);
  },

  getProblemSubmissions: (problemId) => {
    return axios.get(`${API_BASE_URL}/submissions/problem/${problemId}`);
  }
};

export default api; 