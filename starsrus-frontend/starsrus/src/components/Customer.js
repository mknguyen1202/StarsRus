// import axios from "axios";
import React, {Component} from "react";
import {Card, Form, Button, Col} from "react-bootstrap";
import CustomerService from "../services/CustomerService";

class Customer extends Component {
    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.customerChange = this.customerChange.bind(this);
        this.add_customer_button = this.add_customer_button.bind(this);
    }

    // {"username":"alfred","password":"hi","name":"Alfred Hitchcock",
    // "address":"6667 El Colegio #40 SB","state":"CA","phoneNumber":"(805)2574499",
    // "email":"alfred@hotmail.com","ssn":"606-76-7900","tid":"1022"}

    initialState = {
        username:"",
        password:"",
        repeatpassword:"",
        name:"",
        address:"",
        state:"",
        phoneNumber:"",
        email:"",
        ssn:"",
        tid:""
    }

    componentDidMount() {
        const username =  this.props.match.params.username;
        console.log(username);
        if (username) {
            this.findCustomerByUsername(username);
        }
    }

    findCustomerByUsername = (username) => {
        CustomerService.editCustomer(username)
        .then(response =>  {
            if (response.data !== 0) {
                this.setState({
                    username: response.data.username,
                    name: response.data.name,
                    address: response.data.address,
                    state: response.data.state,
                    phoneNumber: response.data.phoneNumber,
                    email: response.data.email,
                    ssn: response.data.ssn,
                    tid: response.data.tid
                });
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
            password: this.state.password,
            name: this.state.name,
            address: this.state.address,
            state: this.state.state,
            phoneNumber: this.state.phoneNumber,
            email: this.state.email,
            ssn: this.state.ssn,
            tid: this.state.tid
        }
        CustomerService.updateCustomer(customer)
        .then(response => {
            if (response.data !== 0) {
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
            password: this.state.password,
            name: this.state.name,
            address: this.state.address,
            state: this.state.state,
            phoneNumber: this.state.phoneNumber,
            email: this.state.email,
            ssn: this.state.ssn,
            tid: this.state.tid
        };

        CustomerService.createCustomer(newcustomer)
        .then(response => {
            if (response.data !== 0) {
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
            password,
            repeatpassword,
            name,
            address,
            state,
            phoneNumber,
            email,
            ssn,
            tid
        } = this.state;
        return (
            <>

                <h1 className="text-center">{this.props.match.params.username ? "Edit Customer" : "Add New Customer"} </h1>
          
            <Card className={"mb3"}>
                {/* <Card.Header>
                    Add New Customer
                </Card.Header> */}
                

            <Form onSubmit={this.add_customer_button} id="customerFormId" >
                <Card.Body>
                    <Form.Row>

                        <Form.Group as={Col} controlId="formGridFullname">
                            <Form.Label>Full Name</Form.Label>
                            <Form.Control 
                                type="test"
                                name="name"
                                value={name}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Enter your Fullname. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridUsername">
                            <Form.Label>Username</Form.Label>
                            <Form.Control 
                                type="test" 
                                name="username"
                                value={username}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Enter Customer name. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                    </Form.Row>

                    <Form.Row>
                        <Form.Group as={Col} controlId="formGridPassword">
                            <Form.Label >Password</Form.Label>
                            <Form.Control 
                                type="password"
                                name="password"
                                value={password}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Enter password. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridRepeatPassword">
                            <Form.Label>Repeat Password</Form.Label>
                            <Form.Control  
                                type="password"
                                name="repeatpassword"
                                value={repeatpassword}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Repeat your password"
                                maxLength="20"
                            />
                        </Form.Group>
                    </Form.Row>

                    <Form.Row>

                        <Form.Group as={Col} controlId="formGridAddress">
                            <Form.Label>Address</Form.Label>
                            <Form.Control 
                                as="textarea"
                                name="address"
                                value={address}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Enter address" 
                                maxLength="30"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>State</Form.Label>
                            <Form.Control as="select"
                                name="state"
                                value={state}
                                onChange={this.customerChange}>
                                    <option value="AK">Alaska</option>
                                    <option value="AL">Alabama</option>
                                    <option value="AR">Arkansas</option>
                                    <option value="AZ">Arizona</option>
                                    <option value="CA">California</option>
                                    <option value="CO">Colorado</option>
                                    <option value="CT">Connecticut</option>
                                    <option value="DC">District of Columbia</option>
                                    <option value="DE">Delaware</option>
                                    <option value="FL">Florida</option>
                                    <option value="GA">Georgia</option>
                                    <option value="HI">Hawaii</option>
                                    <option value="IA">Iowa</option>
                                    <option value="ID">Idaho</option>
                                    <option value="IL">Illinois</option>
                                    <option value="IN">Indiana</option>
                                    <option value="KS">Kansas</option>
                                    <option value="KY">Kentucky</option>
                                    <option value="LA">Louisiana</option>
                                    <option value="MA">Massachusetts</option>
                                    <option value="MD">Maryland</option>
                                    <option value="ME">Maine</option>
                                    <option value="MI">Michigan</option>
                                    <option value="MN">Minnesota</option>
                                    <option value="MO">Missouri</option>
                                    <option value="MS">Mississippi</option>
                                    <option value="MT">Montana</option>
                                    <option value="NC">North Carolina</option>
                                    <option value="ND">North Dakota</option>
                                    <option value="NE">Nebraska</option>
                                    <option value="NH">New Hampshire</option>
                                    <option value="NJ">New Jersey</option>
                                    <option value="NM">New Mexico</option>
                                    <option value="NV">Nevada</option>
                                    <option value="NY">New York</option>
                                    <option value="OH">Ohio</option>
                                    <option value="OK">Oklahoma</option>
                                    <option value="OR">Oregon</option>
                                    <option value="PA">Pennsylvania</option>
                                    <option value="PR">Puerto Rico</option>
                                    <option value="RI">Rhode Island</option>
                                    <option value="SC">South Carolina</option>
                                    <option value="SD">South Dakota</option>
                                    <option value="TN">Tennessee</option>
                                    <option value="TX">Texas</option>
                                    <option value="UT">Utah</option>
                                    <option value="VA">Virginia</option>
                                    <option value="VT">Vermont</option>
                                    <option value="WA">Washington</option>
                                    <option value="WI">Wisconsin</option>
                                    <option value="WV">West Virginia</option>
                                    <option value="WY">Wyoming</option>
                                </Form.Control>
                        </Form.Group>
                    </Form.Row>


                    <Form.Row>
                        <Form.Group as={Col} controlId="formGridEmail">
                            <Form.Label >Email</Form.Label>
                            <Form.Control 
                                type="email"
                                name="email"
                                value={email}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Enter email i.e. abc@gmail.com" 
                                maxLength="30"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridPhone">
                            <Form.Label >Phone Number</Form.Label>
                            <Form.Control 
                                type="number"
                                name="phoneNumber"
                                value={phoneNumber}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Enter phone number" 
                                maxLength="10"
                            />
                        </Form.Group>
                    </Form.Row>


                    <Form.Row>

                        <Form.Group as={Col} controlId="formGridSNN">
                            <Form.Label>SSN</Form.Label>
                            <Form.Control  
                                type="test"
                                name="ssn"
                                value={ssn}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Repeat your SSN"
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridTID">
                            <Form.Label >TID</Form.Label>
                            <Form.Control 
                                type="test"
                                name="tid"
                                value={tid}
                                onChange={this.customerChange}
                                className={"mb3"}
                                placeholder="Enter your TID" 
                                maxLength="20"
                            />
                        </Form.Group>

                    </Form.Row>
                    

                    
                </Card.Body>

                <Card.Footer className="text-right">
                    <Button type="summit" variant="success" onClick={this.props.match.params.username ? this.updateCustomer : this.add_customer_button}>
                        {this.props.match.params.username ? "Edit Customer" : "Add Customer"}
                    </Button>
                    {" "}
                    <Button type="reset" variant="primary" onClick={this.resetForm}>Reset</Button>
                </Card.Footer>
            </Form>
            </Card>
            </>
        )
    }
}

export default Customer;