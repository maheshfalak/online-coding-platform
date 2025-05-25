import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import CodeEditor from '../components/CodeEditor';
import api from '../services/api';
import './ProblemDetailPage.css';

const ProblemDetailPage = () => {
  const { id } = useParams();
  const [problem, setProblem] = useState(null);
  const [loading, setLoading] = useState(true);
  const [code, setCode] = useState('');
  const [language, setLanguage] = useState('java');
  const [output, setOutput] = useState('');
  const [isSubmitting, setIsSubmitting] = useState(false);

  useEffect(() => {
    const fetchProblem = async () => {
      try {
        const response = await api.getProblemById(id);
        setProblem(response.data);
        setCode(response.data.solutionTemplate || '');
        setLoading(false);
      } catch (error) {
        console.error('Error fetching problem:', error);
        setLoading(false);
      }
    };

    fetchProblem();
  }, [id]);

  const handleCodeChange = (newCode) => {
    setCode(newCode);
  };

  const handleLanguageChange = (e) => {
    setLanguage(e.target.value);
  };

  const handleSubmit = async () => {
    setIsSubmitting(true);
    setOutput('');

    try {
      // In a real app, you would get the user ID from authentication
      const userId = 1;
      
      const submissionData = {
        problemId: parseInt(id),
        userId: userId,
        submissionCode: code,
        language: language
      };

      const response = await api.submitCode(submissionData);
      
      // In a real app, you would display the actual execution results
      setOutput(JSON.stringify(response.data, null, 2));
    } catch (error) {
      console.error('Error submitting code:', error);
      setOutput('Error submitting code: ' + error.message);
    } finally {
      setIsSubmitting(false);
    }
  };

  if (loading) {
    return <div className="loading">Loading problem...</div>;
  }

  if (!problem) {
    return <div className="error">Problem not found</div>;
  }

  return (
    <div className="problem-detail-page">
      <div className="problem-header">
        <h1>{problem.title}</h1>
        <span className="difficulty" data-difficulty={problem.difficultyLevel.toLowerCase()}>
          {problem.difficultyLevel}
        </span>
      </div>

      <div className="problem-content">
        <div className="problem-description-section">
          <h2>Description</h2>
          <div className="problem-description">{problem.description}</div>

          {problem.exampleInput && (
            <div className="example">
              <h3>Example Input:</h3>
              <pre>{problem.exampleInput}</pre>
            </div>
          )}

          {problem.exampleOutput && (
            <div className="example">
              <h3>Example Output:</h3>
              <pre>{problem.exampleOutput}</pre>
            </div>
          )}
        </div>

        <div className="code-section">
          <div className="code-header">
            <select
              value={language}
              onChange={handleLanguageChange}
              className="language-select"
            >
              <option value="java">Java</option>
              <option value="python">Python</option>
              <option value="javascript">JavaScript</option>
              <option value="cpp">C++</option>
            </select>
            <button
              onClick={handleSubmit}
              disabled={isSubmitting}
              className="submit-button"
            >
              {isSubmitting ? 'Submitting...' : 'Submit Solution'}
            </button>
          </div>

          <CodeEditor
            initialValue={code}
            language={language}
            onCodeChange={handleCodeChange}
          />

          {output && (
            <div className="output-section">
              <h3>Output:</h3>
              <pre className="output">{output}</pre>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default ProblemDetailPage; 