import React from "react"
import Post from "./Post"

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        };
    }

    async loadPosts() {
        try {
            const response = await fetch("https://jsonplaceholder.typicode.com/posts");
            const data = await response.json();
            const posts = data.map(p => new Post(p.userId, p.id,
                p.title,
                p.body));
            this.setState({posts: posts})
        } catch (err) {
            throw err;
        }
    }

    async componentDidMount() {
        await this.loadPosts();
    }

    componentDidCatch(err, info) {
        alert("Error " + err.message);
    }

    render() {
        return (
            <div>
                {
                    this.state.posts.map((post) => {
                        return (
                            <div key={post.id}>
                                <h3>{post.title}</h3>
                                <p>{post.body}</p>
                            </div>
                        )
                    })
                }
            </div>
        )
    }
}

export default Posts;