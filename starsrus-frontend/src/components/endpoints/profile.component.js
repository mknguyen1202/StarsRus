import React, { Component } from "react";
import { Button, Form } from "react-bootstrap";
import { Redirect } from 'react-router-dom';
import { connect } from "react-redux";
import StockList from '../StockList'
import "./profile.component.css";

class Profile extends Component {

  constructor(props){
    super(props);
    this.handleChange = this.handleChange.bind(this);
    this.postThis = this.postThis.bind(this);

    this.state = {
      post:"",  
    };
  }

  // TODO: Send to database,
  //       Dynamic scroll view
  postThis() {
    console.log(this.state.post);
  }

  handleChange = (e) => {
    // console.log(e.target.name);
    // console.log(e.target.value);
    this.setState({
      [e.target.name]: e.target.value
    });
  }
  render() {
    const { user: currentUser } = this.props;

    if (!currentUser) {
      return <Redirect to="/login"/>;
    }

    return (
      <div className="container">
        <div className="div-with-bg">
          <img src="https://avatars.githubusercontent.com/u/55862469?v=4" alt="edWHINE"></img>
          <h1>
            {currentUser.firstname + " " + currentUser.lastname}
          </h1>
        </div>
        <div className='form-box'>
          <Form class="post-box">
            <Form.Group>
              <Form.Control
                as="textarea"
                rows={3}
                type="text"
                name="post"
                placeholder="What's on your mind?"
                value={this.state.post}
                onChange={this.handleChange}
              />
            </Form.Group>
          </Form>
          <Button className="float-right" onClick={this.postThis}> 
            Post
          </Button>
        </div>
        <div className='stock-list'>
          <StockList
            header={'My Stocks'}
          />
        </div>
        <div className='second-row'>
          <p>
            <strong>Token:</strong> {currentUser.accessToken.substring(0, 20)} ...{" "}
            {currentUser.accessToken.substr(currentUser.accessToken.length - 20)}
          </p>
          <p>
            <strong>Id:</strong> {currentUser.id}
          </p>
          <p>
            <strong>Email:</strong> {currentUser.email}
          </p>
          <strong>Authorities:</strong>
          <ul>
            {currentUser.roles &&
              currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
          </ul>
        </div>
      </div>
    );
  }
}

function mapStateToProps(state) {
  const { user } = state.auth;
  return {
    user,
  };
}

export default connect(mapStateToProps)(Profile);