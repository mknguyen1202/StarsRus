// import axios from "axios";
import React, {Component} from "react";
import {Card, Form, Button, Col} from "react-bootstrap";
import DepositService from "../services/DepositService";

class Deposit extends Component {
    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.withdrawChange = this.withdrawChange.bind(this);
        this.add_withdraw_button = this.add_withdraw_button.bind(this);
    }

    // {"username":"alfred","password":"hi","name":"Alfred Hitchcock",
    // "address":"6667 El Colegio #40 SB","state":"CA","phoneNumber":"(805)2574499",
    // "email":"alfred@hotmail.com","ssn":"606-76-7900","tid":"1022"}

    initialState = {
        

        withdraw_id:"",
        withdraw_date:"",
        withdraw_amount:"",
        username:""
    }

    componentDidMount() {
        const withdraw_id =  this.props.match.params.withdraw_id;
        console.log(withdraw_id);
        if (withdraw_id) {
            this.findByDepositID(withdraw_id);
        }
    }

    findByDepositID = (withdraw_id) => {
        DepositService.editDeposit(withdraw_id)
        .then(response =>  {
            if (response.data != 0) {
                this.setState({
                    withdraw_id: response.data.withdraw_id,
                    withdraw_date: response.data.withdraw_date,
                    withdraw_amount: response.data.withdraw_amount,
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

        const withdraw = {
            withdraw_id: this.state.withdraw_id,
            withdraw_date: this.state.withdraw_date,
            withdraw_amount: this.state.withdraw_amount,
            username: this.state.username
        }
        DepositService.updateDeposit(withdraw)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("Deposit Updated Successfully!");
            } else {
                alert("Cannot upate withdraw. Something wrong!");
            }
        })
    }

    resetForm = () => {
        this.setState(() => this.initialState);
    }

    add_withdraw_button(event) {
        alert("Are you sure you want to add new withdraw?");
        event.preventDefault();

        const newwithdraw = {
            withdraw_id: this.state.withdraw_id,
            withdraw_date: this.state.withdraw_date,
            withdraw_amount: this.state.withdraw_amount,
            username: this.state.username
        };

        DepositService.createDeposit(newwithdraw)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("Deposit Added Successfully!");
            } else {
                alert("Cannot add withdraw. Username might already exist!");
            }
        }).catch (e => {
            console.log(e);
        });
        

    }

    withdrawChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    withdrawPasswordChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    render() {
        const {
            withdraw_id,
            withdraw_date,
            withdraw_amount,
            username
        } = this.state;
        return (
            <>

                <h1 className="text-center">{this.props.match.params.withdraw_id ? "Edit withdraw" : "Add New withdraw"} </h1>
          
            <Card className={"mb3"}>
                {/* <Card.Header>
                    Add New Deposit
                </Card.Header> */}
                

            <Form onSubmit={this.add_withdraw_button} id="withdrawFormId" >
                <Card.Body>
                    <Form.Row>

                        <Form.Group as={Col} controlId="formGridwithdraw_id">
                            <Form.Label>withdraw ID</Form.Label>
                            <Form.Control 
                                type="test"
                                name="withdraw_id"
                                value={withdraw_id}
                                onChange={this.withdrawChange}
                                className={"mb3"}
                                placeholder="Enter your withdraw id. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridUsername">
                            <Form.Label>Username</Form.Label>
                            <Form.Control 
                                type="test" 
                                name="username"
                                value={username}
                                onChange={this.withdrawChange}
                                className={"mb3"}
                                placeholder="Enter Deposit username. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                    </Form.Row>

                    <Form.Row>
                        <Form.Group as={Col} controlId="formGridwithdraw_date">
                            <Form.Label >Deposit Date</Form.Label>
                            <Form.Control 
                                type="test"
                                name="withdraw_date"
                                value={withdraw_date}
                                onChange={this.withdrawChange}
                                className={"mb3"}
                                placeholder="Enter withdraw date. Maximum 20 Characters" 
                                maxLength="20"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridwithdraw_amount">
                            <Form.Label>Deposit Amount</Form.Label>
                            <Form.Control  
                                type="test"
                                name="withdraw_amount"
                                value={withdraw_amount}
                                onChange={this.withdrawChange}
                                className={"mb3"}
                                placeholder="Deposit Amount"
                                maxLength="20"
                            />
                        </Form.Group>
                    </Form.Row>
                    
                </Card.Body>

                <Card.Footer className="text-right">
                    <Button type="summit" variant="success" onClick={this.props.match.params.username ? this.updateDeposit : this.add_withdraw_button}>
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