import './App.css';
import './Stylesheets/mystyle.css';
import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <CalculateScore Name={"Upender"} School={"Ekashila public school"}
    total={284} goal={3}/>
  )
}

export default App;
