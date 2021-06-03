import React from "react";
import {Navbar, Nav, Button, Form, FormControl} from "react-bootstrap";
import {Link} from "react-router-dom";

class CustomerNavBar extends React.Component {
    render() {
        return (
            <>
            <Navbar bg="dark" variant="dark">
            <Link to={""} className="navbar-brand">Hello to StarsRus Stock Exchange</Link>
              <Nav className="mr-auto">
                <Link to={"customer"} className="nav-link">Profile</Link>
                <Link to={"stock"} className="nav-link">My Account</Link>
                <Link to={"actor"} className="nav-link">My Stocks</Link>
                <Link to={"stockmarket"} className="nav-link">Stock Market</Link>
              </Nav>
            </Navbar>
          </>
        );
    }
}

export default CustomerNavBar;