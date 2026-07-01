import { BrowserRouter, Routes, Route, Link, Navigate } from "react-router-dom";
import Home from "./components/Home";
import TrainersList from "./components/TrainersList";
import TrainerDetails from "./components/TrainerDetails";
export default function App() {
    return (
        <BrowserRouter>
            <h1>My Academy Trainers App</h1>
            <nav><Link to="/">Home</Link> |
                <Link to="/trainers">Show Trainers</Link>
            </nav>
            <Routes>
                <Route path="/" element={<Navigate to="/home" />} />
                <Route path="/home" element={<Home />} />
                <Route path="/trainers" element={<TrainersList />} />
                <Route path="/trainer/:id" element={<TrainerDetails />} />
            </Routes>
        </BrowserRouter>);
}
