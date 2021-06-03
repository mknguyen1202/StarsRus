import React from "react";
import {Navbar, Nav, Button, Form, FormControl} from "react-bootstrap";
import {Link} from "react-router-dom";

class NavigationBar extends React.Component {
    render() {
        return (
            <>
            <Navbar bg="dark" variant="dark">
            <Link to={""} className="navbar-brand">Administrator Board</Link>
              <Nav className="mr-auto">
                <Link to={"customer"} className="nav-link">Customer</Link>
                <Link to={"stock"} className="nav-link">Actor</Link>
                <Link to={"actor"} className="nav-link">Stock</Link>
              </Nav>
            </Navbar>
          </>
        );
    }
}

export default NavigationBar;