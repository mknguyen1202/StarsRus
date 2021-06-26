// import axios from "axios";
import React, {Component} from "react";
import {Card, Form, Button, Col} from "react-bootstrap";
import LoginService from "../services/LoginService";
import {Link} from "react-router-dom";

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.customerChange = this.customerChange.bind(this);
        this.add_customer_button = this.add_customer_button.bind(this);
        this.findCustomerByUsername = this.findCustomerByUsername.bind(this);
    }

    // {"username":"alfred","password":"hi","name":"Alfred Hitchcock",
    // "address":"6667 El Colegio #40 SB","state":"CA","phoneNumber":"(805)2574499",
    // "email":"alfred@hotmail.com","ssn":"606-76-7900","tid":"1022"}

    initialState = {
        username:"",
        password:""
    }

    // componentDidMount() {
    //     const username =  this.props.match.params.username;
    //     console.log(username);
    //     if (username) {
    //         this.findCustomerByUsername(username);
    //     }
    // }

    findCustomerByUsername = (username) => {

        console.log("aaaaaaaaa: ", username);
        LoginService.editCustomer(username)
        .then(response =>  {
            if (response.data != 0) {
                this.setState({
                    username: response.data.username,
                    password: response.data.password
                    // name: response.data.name,
                    // address: response.data.address,
                    // state: response.data.state,
                    // phoneNumber: response.data.phoneNumber,
                    // email: response.data.email,
                    // ssn: response.data.ssn,
                    // tid: response.data.tid
                });
                
                this.props.history.push("/customer/" + response.data.username);
            }
        })
        .catch (e => {
          console.log(e);  
        });
    }

    updateCustomer = event => {
        event.preventDefault();

        const customer = {
            username: this.state.username,
            password: this.state.password
            // name: this.state.name,
            // address: this.state.address,
            // state: this.state.state,
            // phoneNumber: this.state.phoneNumber,
            // email: this.state.email,
            // ssn: this.state.ssn,
            // tid: this.state.tid
        }
        LoginService.updateCustomer(customer)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("Customer Updated Successfully!");
            } else {
                alert("Cannot upate customer. Something wrong!");
            }
        })
    }

    resetForm = () => {
        this.setState(() => this.initialState);
    }

    add_customer_button(event) {
        alert("Are you sure you want to add new customer?");
        event.preventDefault();

        const newcustomer = {
            username: this.state.username,
            password: this.state.password
            // name: this.state.name,
            // address: this.state.address,
            // state: this.state.state,
            // phoneNumber: this.state.phoneNumber,
            // email: this.state.email,
            // ssn: this.state.ssn,
            // tid: this.state.tid
        };

        LoginService.createCustomer(newcustomer)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("Customer Added Successfully!");
            } else {
                alert("Cannot add customer. Username might already exist!");
            }
        }).catch (e => {
            console.log(e);
        });
        

    }

    customerChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    customerPasswordChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    render() {
        const {
            username,
            password
        } = this.state;
        return (
            <>

                <h1 className="text-center">Login </h1>
          
            <Card className={"mb3"}>
                {/* <Card.Header>
                    Add New Customer
                </Card.Header> */}
                

            <Form onSubmit={this.add_customer_button} id="customerFormId" >
                <Card.Body>
                    <Form.Row>

                        <Form.Group as={Col} controlId="formGridFullname">
                            <Form.Label>Username</Form.Label>
                            <Form.Control 
                                type="text"
                                name="username"
                                value={username}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Enter username. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridUsername">
                            <Form.Label>Password</Form.Label>
                            <Form.Control 
                                type="text" 
                                name="password"
                                value={password}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Enter password. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                    </Form.Row>

                    
                </Card.Body>

                <Card.Footer className="text-right">
                <Button onClick={this.findCustomerByUsername(username)} className="primary">LOGIN</Button>
                    {" "}
                    <Button type="reset" variant="success" onClick={this.resetForm}>Register</Button>
                </Card.Footer>
            </Form>
            </Card>
            </>
        )
    }
}

export default Login;