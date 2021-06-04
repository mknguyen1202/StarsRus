import React from "react";
import {Navbar, Nav, Button, Form, FormControl} from "react-bootstrap";
import {Link} from "react-router-dom";

class CustomerNavBar extends React.Component {
    render() {
        return (
            <>
            <Navbar bg="dark" variant="dark">
            <Link to={""} className="navbar-brand">Welcome to StarsRus Stock Exchange</Link>
              <Nav className="mr-auto">
                <Link to={"/edit_customer/:username"} className="nav-link">Profile</Link>
                <Link to={"myaccount"} className="nav-link">My Account</Link>
                <Link to={"mystocks"} className="nav-link">My Stocks</Link>
                <Link to={"stockmarket"} className="nav-link">Stock Market</Link>
              </Nav>
            </Navbar>
          </>
        );
    }
}

export default CustomerNavBar;