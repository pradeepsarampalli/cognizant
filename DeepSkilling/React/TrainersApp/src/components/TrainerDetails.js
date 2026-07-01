import { useParams } from "react-router-dom";
import trainers from "../TrainersMock";
export default function TrainerDetails() {
    const { id } = useParams();
    const t = trainers.find(x => x.trainerId === id);
    if (!t) return <h2>Trainer not found</h2>;
    return (
        <div>
            <h2>Trainers Details</h2>
            <h3>{t.name} ({t.technology})</h3>
            <p>{t.email}</p><p>{t.phone}</p>
            <ul>
                {t.skills.map(s => <li key={s}>{s}</li>)}
            </ul>
        </div>);
}
