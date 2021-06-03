// import axios from "axios";
import React, {Component} from "react";
import {Card, Form, Button, Col} from "react-bootstrap";
import AdminService from "../services/AdminService";

class Admin extends Component {
    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.adminChange = this.adminChange.bind(this);
        this.add_admin_button = this.add_admin_button.bind(this);
    }

    // {"username":"alfred","password":"hi","name":"Alfred Hitchcock",
    // "address":"6667 El Colegio #40 SB","state":"CA","phoneNumber":"(805)2574499",
    // "email":"alfred@hotmail.com","ssn":"606-76-7900","tid":"1022"}

    initialState = {
        admin_username:"",
        admin_password:"",
        admin_repeatpassword:"",
        admin_name:"",
        admin_address:"",
        admin_state:"",
        admin_phone:"",
        admin_email:"",
        admin_ssn:"",
        admin_tid:""
    }

    componentDidMount() {
        const username =  this.props.match.params.username;
        console.log(username);
        if (username) {
            this.findAdminByUsername(username);
        }
    }

    findAdminByUsername = (username) => {
        AdminService.editAdmin(username)
        .then(response =>  {
            if (response.data != 0) {
                this.setState({
                    admin_username: response.data.admin_username,
                    admin_name: response.data.admin_name,
                    admin_address: response.data.admin_address,
                    admin_state: response.data.admin_state,
                    admin_phone: response.data.admin_phone,
                    admin_email: response.data.admin_email,
                    admin_ssn: response.data.admin_ssn,
                    admin_tid: response.data.admin_tid
                });
            }
        })
        .catch (e => {
          console.log(e);  
        });
    }

    updateAdmin = event => {
        event.preventDefault();

        const admin = {
            admin_username: this.state.admin_username,
            admin_password: this.state.admin_password,
            admin_name: this.state.admin_name,
            admin_address: this.state.admin_address,
            admin_state: this.state.admin_state,
            admin_phone: this.state.admin_phone,
            admin_email: this.state.admin_email,
            admin_ssn: this.state.admin_ssn,
            admin_tid: this.state.admin_tid
        }
        AdminService.updateAdmin(admin)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("Admin Updated Successfully!");
            } else {
                alert("Cannot upate admin. Something wrong!");
            }
        })
    }

    resetForm = () => {
        this.setState(() => this.initialState);
    }

    add_admin_button(event) {
        alert("Are you sure you want to add new admin?");
        event.preventDefault();

        const newadmin = {
            admin_username: this.state.admin_username,
            admin_password: this.state.admin_password,
            admin_name: this.state.admin_name,
            admin_address: this.state.admin_address,
            admin_state: this.state.admin_state,
            admin_phone: this.state.admin_phone,
            admin_email: this.state.admin_email,
            admin_ssn: this.state.admin_ssn,
            admin_tid: this.state.admin_tid
        };

        AdminService.createAdmin(newadmin)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("Admin Added Successfully!");
            } else {
                alert("Cannot add admin. Username might already exist!");
            }
        }).catch (e => {
            console.log(e);
        });
        

    }

    adminChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    adminPasswordChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    render() {
        const {
            admin_username,
            admin_password,
            admin_repeatpassword,
            admin_name,
            admin_address,
            admin_state,
            admin_phone,
            admin_email,
            admin_ssn,
            admin_tid
        } = this.state;
        return (
            <>

                <h1 className="text-center">{this.props.match.params.username ? "Edit Admin" : "Add New Admin"} </h1>
          
            <Card className={"mb3"}>
                {/* <Card.Header>
                    Add New Admin
                </Card.Header> */}
                

            <Form onSubmit={this.add_admin_button} id="adminFormId" >
                <Card.Body>
                    <Form.Row>

                        <Form.Group as={Col} controlId="formGridFullname">
                            <Form.Label>Full Name</Form.Label>
                            <Form.Control 
                                type="test"
                                name="admin_name"
                                value={admin_name}
                                onChange={this.adminChange}
                                className={"mb3"}
                                placeholder="Enter your Fullname. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridUsername">
                            <Form.Label>Username</Form.Label>
                            <Form.Control 
                                type="test" 
                                name="admin_username"
                                value={admin_username}
                                onChange={this.adminChange}
                                className={"mb3"}
                                placeholder="Enter Admin name. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                    </Form.Row>

                    <Form.Row>
                        <Form.Group as={Col} controlId="formGridPassword">
                            <Form.Label >Password</Form.Label>
                            <Form.Control 
                                type="password"
                                name="admin_password"
                                value={admin_password}
                                onChange={this.adminChange}
                                className={"mb3"}
                                placeholder="Enter password. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridRepeatPassword">
                            <Form.Label>Repeat Password</Form.Label>
                            <Form.Control  
                                type="password"
                                name="admin_repeatpassword"
                                value={admin_repeatpassword}
                                onChange={this.adminChange}
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
                                name="admin_address"
                                value={admin_address}
                                onChange={this.adminChange}
                                className={"mb3"}
                                placeholder="Enter address" 
                                maxLength="30"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>State</Form.Label>
                            <Form.Control as="select"
                                name="admin_state"
                                value={admin_state}
                                onChange={this.adminChange}>
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
                                name="admin_email"
                                value={admin_email}
                                onChange={this.adminChange}
                                className={"mb3"}
                                placeholder="Enter email i.e. abc@gmail.com" 
                                maxLength="30"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridPhone">
                            <Form.Label >Phone Number</Form.Label>
                            <Form.Control 
                                type="number"
                                name="admin_phone"
                                value={admin_phone}
                                onChange={this.adminChange}
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
                                name="admin_ssn"
                                value={admin_ssn}
                                onChange={this.adminChange}
                                className={"mb3"}
                                placeholder="Repeat your SSN"
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridTID">
                            <Form.Label >TID</Form.Label>
                            <Form.Control 
                                type="test"
                                name="admin_tid"
                                value={admin_tid}
                                onChange={this.adminChange}
                                className={"mb3"}
                                placeholder="Enter your TID" 
                                maxLength="20"
                            />
                        </Form.Group>

                    </Form.Row>
                    

                    
                </Card.Body>

                <Card.Footer className="text-right">
                    <Button type="summit" variant="success" onClick={this.props.match.params.username ? this.updateAdmin : this.add_admin_button}>
                        {this.props.match.params.username ? "Edit Admin" : "Add Admin"}
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

export default Admin;