import { useState, useEffect } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import './Survey.css';

function Survey() {
    const [questions, setQuestions] = useState([]);
    const [answers, setAnswers] = useState({});
    const [loading, setLoading] = useState(true);
    const [submitting, setSubmitting] = useState(false);
    const [error, setError] = useState("");
    const navigate = useNavigate();
    const location = useLocation();

    const userId = location.state?.userId;

    useEffect(() => {
        if (!userId) {
            navigate("/");
            return;
        }

        fetchQuestions();
    }, [userId, navigate]);

    const fetchQuestions = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/questions");
            setQuestions(response.data);
            
            // Initialize answers object
            const initialAnswers = {};
            response.data.forEach(question => {
                initialAnswers[question.questionId] = "";
            });
            setAnswers(initialAnswers);
        } catch (error) {
            console.error("Error fetching questions:", error);
            setError("Failed to load questions");
        } finally {
            setLoading(false);
        }
    };

    const handleAnswerChange = (questionId, answer) => {
        setAnswers(prev => ({
            ...prev,
            [questionId]: answer
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setSubmitting(true);
        setError("");

        try {
            // Prepare answers for submission
            const answersToSubmit = Object.entries(answers).map(([questionId, answer]) => ({
                userId: userId,
                questionId: parseInt(questionId),
                answer: answer
            }));

            const response = await axios.post(
                "http://localhost:8080/api/answers/batch",
                answersToSubmit,
                { headers: { "Content-Type": "application/json" } }
            );

            console.log("Survey submitted successfully:", response.data);
            navigate("/thank-you"); // Create a ThankYou component
        } catch (error) {
            console.error("Error submitting survey:", error);
            setError("Failed to submit survey");
        } finally {
            setSubmitting(false);
        }
    };

    if (loading) {
        return <div className="survey-container">Loading questions...</div>;
    }

    return (
        <div className="survey-container">
            <h1 className="survey-heading">Technical Interview Survey</h1>
            <p>Please answer the following questions:</p>
            
            {error && <div className="error-message">{error}</div>}
            
            <form onSubmit={handleSubmit}>
                {questions.map((question, index) => (
                    <div key={question.questionId} className="question-container">
                        <label className="question-label">
                            {index + 1}. {question.questionText}
                        </label>
                        <textarea
                            className="answer-textarea"
                            value={answers[question.questionId] || ""}
                            onChange={(e) => handleAnswerChange(question.questionId, e.target.value)}
                            placeholder="Type your answer here..."
                            rows={4}
                            required
                        />
                    </div>
                ))}
                
                <button 
                    type="submit" 
                    className="submit-button"
                    disabled={submitting}
                >
                    {submitting ? "Submitting..." : "Submit Survey"}
                </button>
            </form>
        </div>
    );
}

export default Survey;