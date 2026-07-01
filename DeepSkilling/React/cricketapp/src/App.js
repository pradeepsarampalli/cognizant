
import ListofPlayers from "./components/ListofPlayers";
import ScoreBelow70 from "./components/ScoreBelow70";
import {OddPlayers,EvenPlayers,IndianPlayers,ListofIndianPlayers} from "./components/IndianPlayers";

const players=[
{name:"Jack",score:50},{name:"Michael",score:70},{name:"John",score:40},
{name:"Ann",score:61},{name:"Elizabeth",score:61},{name:"Sachin",score:95},
{name:"Dhoni",score:100},{name:"Virat",score:84},{name:"Jadeja",score:64},
{name:"Raina",score:75},{name:"Rohit",score:80}
];
const IndianTeam=["Sachin1","Dhoni2","Virat3","Rohit4","Yuvraj5","Raina6"];
const flag=true;

export default function App(){
 if(flag){
  return <div><h1>List of Players</h1><ListofPlayers players={players}/><hr/><h1>List of Players having Scores Less than 70</h1><ScoreBelow70 players={players}/></div>;
 }
 return <div><h1>Indian Team</h1><h2>Odd Players</h2>{OddPlayers(IndianTeam)}<hr/><h2>Even Players</h2>{EvenPlayers(IndianTeam)}<hr/><h2>List of Indian Players Merged</h2><ListofIndianPlayers players={IndianPlayers}/></div>;
}
