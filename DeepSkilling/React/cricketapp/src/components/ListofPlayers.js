
export default function ListofPlayers({players}){
  return (
    <ul>
      {players.map((p,i)=><li key={i}>Mr. {p.name} <span>{p.score}</span></li>)}
    </ul>
  );
}
