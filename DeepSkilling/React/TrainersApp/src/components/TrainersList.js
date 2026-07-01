import {Link} from "react-router-dom";
import trainers from "../TrainersMock";
export default function TrainersList(){
return(
<div>
    <h2>Trainers List</h2>
    <ul>{
        trainers.map(t=><li key={t.trainerId}>
        <Link to={`/trainer/${t.trainerId}`}>
        {t.name}</Link>
        </li>)
        }</ul>
    </div>);
}
