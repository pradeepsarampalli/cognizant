
import React from "react";

export default class CountPeople extends React.Component{
  constructor(props){
    super(props);
    this.state={
      entrycount:0,
      exitcount:0
    };
  }

  updateEntry=()=>{
    this.setState(prev=>({entrycount:prev.entrycount+1}));
  }

  updateExit=()=>{
    this.setState(prev=>({exitcount:prev.exitcount+1}));
  }

  render(){
    return(
      <div style={{display:"flex",justifyContent:"space-around",marginTop:"100px"}}>
        <div>
          <button onClick={this.updateEntry}>Login</button>
          <span> {this.state.entrycount} People Entered!!!</span>
        </div>

        <div>
          <button onClick={this.updateExit}>Exit</button>
          <span> {this.state.exitcount} People Left!!!</span>
        </div>
      </div>
    );
  }
}
