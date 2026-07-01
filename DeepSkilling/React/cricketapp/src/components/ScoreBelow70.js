
export default function ScoreBelow70({players}){
 const filtered=players.filter(p=>p.score<=70);
 return <ul>{filtered.map((p,i)=><li key={i}>Mr. {p.name} {p.score}</li>)}</ul>;
}
