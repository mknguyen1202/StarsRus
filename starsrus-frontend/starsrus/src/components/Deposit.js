// import axios from "axios";
import React, {Component} from "react";
import {Card, Form, Button, Col} from "react-bootstrap";
import DepositService from "../services/DepositService";

class Deposit extends Component {
    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.depositChange = this.depositChange.bind(this);
        this.add_deposit_button = this.add_deposit_button.bind(this);
    }

    // {"username":"alfred","password":"hi","name":"Alfred Hitchcock",
    // "address":"6667 El Colegio #40 SB","state":"CA","phoneNumber":"(805)2574499",
    // "email":"alfred@hotmail.com","ssn":"606-76-7900","tid":"1022"}

    initialState = {
    
        deposit_id:"",
        deposit_date:"",
        deposit_amount:"",
        username:""
    }

    componentDidMount() {
        const deposit_id =  this.props.match.params.deposit_id;
        console.log(deposit_id);
        if (deposit_id) {
            this.findByDepositID(deposit_id);
        }
    }

    findByDepositID = (deposit_id) => {
        DepositService.editDeposit(deposit_id)
        .then(response =>  {
            if (response.data != 0) {
                this.setState({
                    deposit_id: response.data.deposit_id,
                    deposit_date: response.data.deposit_date,
                    deposit_amount: response.data.deposit_amount,
                    username: response.data.username
                });
            }
        })
        .catch (e => {
          console.log(e);  
        });
    }

    updateDeposit = event => {
        event.preventDefault();

        const deposit = {
            deposit_id: this.state.deposit_id,
            deposit_date: this.state.deposit_date,
            deposit_amount: this.state.deposit_amount,
            username: this.state.username
        }
        DepositService.updateDeposit(deposit)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("Deposit Updated Successfully!");
            } else {
                alert("Cannot upate deposit. Something wrong!");
            }
        })
    }

    resetForm = () => {
        this.setState(() => this.initialState);
    }

    add_deposit_button(event) {
        alert("Are you sure you want to add new deposit?");
        event.preventDefault();

        const newdeposit = {
            deposit_id: this.state.deposit_id,
            deposit_date: this.state.deposit_date,
            deposit_amount: this.state.deposit_amount,
            username: this.state.username
        };

        DepositService.createDeposit(newdeposit)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("Deposit Added Successfully!");
            } else {
                alert("Cannot add deposit. Username might already exist!");
            }
        }).catch (e => {
            console.log(e);
        });
        

    }

    depositChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    depositPasswordChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    render() {
        const {
            deposit_id,
            deposit_date,
            deposit_amount,
            username
        } = this.state;
        return (
            <>

                <h1 className="text-center">{this.props.match.params.deposit_id ? "Edit deposit" : "Add New deposit"} </h1>
          
            <Card className={"mb3"}>
                {/* <Card.Header>
                    Add New Deposit
                </Card.Header> */}
                

            <Form onSubmit={this.add_deposit_button} id="depositFormId" >
                <Card.Body>
                    <Form.Row>

                        <Form.Group as={Col} controlId="formGriddeposit_id">
                            <Form.Label>deposit ID</Form.Label>
                            <Form.Control 
                                type="test"
                                name="deposit_id"
                                value={deposit_id}
                                onChange={this.depositChange}
                                className={"mb3"}
                                placeholder="Enter your deposit id. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridUsername">
                            <Form.Label>Username</Form.Label>
                            <Form.Control 
                                type="test" 
                                name="username"
                                value={username}
                                onChange={this.depositChange}
                                className={"mb3"}
                                placeholder="Enter Deposit username. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                    </Form.Row>

                    <Form.Row>
                        <Form.Group as={Col} controlId="formGriddeposit_date">
                            <Form.Label >Deposit Date</Form.Label>
                            <Form.Control 
                                type="test"
                                name="deposit_date"
                                value={deposit_date}
                                onChange={this.depositChange}
                                className={"mb3"}
                                placeholder="Enter deposit date. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGriddeposit_amount">
                            <Form.Label>Deposit Amount</Form.Label>
                            <Form.Control  
                                type="test"
                                name="deposit_amount"
                                value={deposit_amount}
                                onChange={this.depositChange}
                                className={"mb3"}
                                placeholder="Deposit Amount"
                                maxLength="20"
                            />
                        </Form.Group>
                    </Form.Row>
                    
                </Card.Body>

                <Card.Footer className="text-right">
                    <Button type="summit" variant="success" onClick={this.props.match.params.username ? this.updateDeposit : this.add_deposit_button}>
                        {this.props.match.params.username ? "Edit Deposit" : "Add Deposit"}
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

export default Deposit;