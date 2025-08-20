import { useState } from "react";
import './Signup.css';
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Signup() {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        setError("");
        
        console.log("Submitting:", { name, email });

        try {
            const response = await axios.post(
                "http://localhost:8080/api/users/signup",
                { name, email },
                { headers: { "Content-Type": "application/json" } }
            );

            console.log("Signup successful:", response.data);
            
            // Navigate to survey with userId
            if (response.status === 200 || response.status === 201) {
                navigate("/survey", { state: { userId: response.data.userId } });
            }
        } catch (error) {
            console.error("Signup error:", error.response || error.message);
            setError("Signup failed. Please try again.");
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="signup-container">
            <h1 className="heading">IQ Signup</h1>
            <p>Sign up to access the survey:</p>
            
            {error && <div style={{color: 'red', marginBottom: '1rem'}}>{error}</div>}
            
            <form onSubmit={handleSubmit}>
                <label htmlFor="name">Please provide your name:</label><br />
                <input
                    type="text"
                    placeholder="Enter name here"
                    name="name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                    disabled={loading}
                />
                <br />
                <label htmlFor="email">Please provide your email:</label><br />
                <input
                    type="email"
                    placeholder="Enter email here"
                    name="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                    disabled={loading}
                />
                <br /><br />
                <button type="submit" disabled={loading}>
                    {loading ? "Signing up..." : "Sign up"}
                </button>
            </form>
        </div>
    );
}

export default Signup;