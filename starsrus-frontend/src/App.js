import React, { Component } from "react";
import { connect } from "react-redux";
import { Router, Switch, Route, Link } from "react-router-dom";

import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import Login from "./components/endpoints/login.component";
import Register from "./components/endpoints/register.component";
import Home from "./components/endpoints/home.component";
import Profile from "./components/endpoints/profile.component";
import BoardUser from "./components/endpoints/board-user.component";
import BoardModerator from "./components/endpoints/board-moderator.component";
import BoardAdmin from "./components/endpoints/board-admin.component";

import { logout } from "./actions/auth";
import { clearMessage } from "./actions/message";

import { history } from './helpers/history';

// icon imports
import admin_icon from "./icons/#12172D/admin.png"
import bookmarks_icon from "./icons/#12172D/bookmarks.png"
//import home_icon from "./icons/#12172D/home.png"
import logout_icon from "./icons/#12172D/logout.png"
import messages_icon from "./icons/#12172D/messages.png"
import moderator_icon from "./icons/#12172D/moderator.png"
import notifications_icon from "./icons/#12172D/notifications.png"
import stock_market_icon from "./icons/#12172D/stock_market.png"
import user_icon from "./icons/#12172D/user.png"

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    };

    history.listen((location) => {
      props.dispatch(clearMessage()); // clear message when changing location
    });
  }

  componentDidMount() {
    const user = this.props.user;

    if (user) {
      this.setState({
        currentUser: user,
        showModeratorBoard: user.roles.includes("ROLE_MODERATOR"),
        showAdminBoard: user.roles.includes("ROLE_ADMIN"),
      });
    }
  }

  logOut() {
    this.props.dispatch(logout());
  }

  render() {
    const { currentUser, showModeratorBoard, showAdminBoard } = this.state;

    return (
      <Router history={history}>
        <div>
          <nav class="navbar navbar-expand navbar-light bg-primary">
            <Link to={"/home"} className="navbar-brand text-white fs-2">
              StarsRus
            </Link>

            <button class="navbar-toggler toggler-example" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1"
              aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"><span class="dark-blue-text"><i
                class="fas fa-bars fa-1x"></i></span></button>

            <div className="navbar-nav mr-auto">
              {/* <li className="nav-item">
                <Link to={"/home"} className="nav-link">
                  <img src={home_icon} width="25" height="25" alt="Home"/>
                </Link>
              </li> */}

              {showModeratorBoard && (
                <li className="nav-item">
                  <Link to={"/mod"} className="nav-link">
                  <img src={moderator_icon} width="25" height="25" alt="Moderator Board"/>
                  </Link>
                </li>
              )}

              {showAdminBoard && (
                <li className="nav-item">
                  <Link to={"/admin"} className="nav-link">
                  <img src={admin_icon} width="25" height="25" alt="Admin Board"/>
                  </Link>
                </li>
              )}
            </div>

            {currentUser ? (
              <div className="navbar-nav ml-auto">
                <li className="nav-item">
                  <Link to={"/stock_market"} className="nav-link">
                    <img src={stock_market_icon} width="25" height="25" alt="Stock Market"/>
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to={"/bookmarks"} className="nav-link">
                    <img src={bookmarks_icon} width="25" height="25" alt="Stock Market"/>
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to={"/notifications"} className="nav-link">
                    <img src={notifications_icon} width="25" height="25" alt="Notifications"/>
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to={"/messages"} className="nav-link">
                    <img src={messages_icon} width="25" height="25" alt="Messages"/>
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to={"/profile"} className="nav-link">
                    {/* {currentUser.username} */}
                    <img src={user_icon} width="25" height="25" alt="User"/>
                  </Link>
                </li>
                <li className="nav-item">
                  <a href="/login" className="nav-link" onClick={this.logOut}>
                    <img src={logout_icon} width="25" height="25" alt="Logout"/>
                  </a>
                </li>
              </div>
            ) : (
              <div className="navbar-nav ml-auto">
                <li className="nav-item">
                  <Link to={"/login"} className="nav-link">
                    Login
                  </Link>
                </li>

                <li className="nav-item">
                  <Link to={"/register"} className="nav-link">
                    Sign Up
                  </Link>
                </li>
              </div>
            )}
          </nav>

          <div className="container mt-3">
            <Switch>
              <Route exact path={["/", "/home"]} component={Home} />
              <Route exact path="/login" component={Login} />
              <Route exact path="/register" component={Register} />
              <Route exact path="/profile" component={Profile} />
              <Route path="/user" component={BoardUser} />
              <Route path="/mod" component={BoardModerator} />
              <Route path="/admin" component={BoardAdmin} />
            </Switch>
          </div>
        </div>
      </Router>
    );
  }
}

function mapStateToProps(state) {
  const { user } = state.auth;
  return {
    user,
  };
}

export default connect(mapStateToProps)(App);