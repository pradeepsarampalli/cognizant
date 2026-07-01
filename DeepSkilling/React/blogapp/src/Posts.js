import React from "react";

class Posts extends React.Component{
  constructor(props){
    super(props);
    this.state={posts:[]};
  }

  loadPosts(){
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then(res=>res.json())
      .then(data=>this.setState({posts:data}))
      .catch(err=>alert(err));
  }

  componentDidMount(){
    this.loadPosts();
  }

  componentDidCatch(error,info){
    alert(error);
    console.error(info);
  }

  render(){
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map(post=>(
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <hr/>
          </div>
        ))}
      </div>
    );
  }
}
export default Posts;
