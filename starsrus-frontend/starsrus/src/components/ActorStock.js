// import axios from "axios";
import React, {Component} from "react";
import {Card, Form, Button, Col} from "react-bootstrap";
import ActorStockService from "../services/ActorStockService";


class ActorStock extends Component {
    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.actorStockChange = this.actorStockChange.bind(this);
        this.add_actorstock_button = this.add_actorstock_button.bind(this);

    }

    // {"symbol":"alfred","password":"hi","name":"Alfred Hitchcock",
    // "address":"6667 El Colegio #40 SB","state":"CA","phoneNumber":"(805)2574499",
    // "email":"alfred@hotmail.com","ssn":"606-76-7900","tid":"1022"}

    initialState = {
        symbol:"",
        actor_name:"",
        actor_dob:"",
    }

    componentDidMount() {
        const symbol =  this.props.match.params.symbol;
        console.log(symbol);
        if (symbol) {
            this.findActorStockBySymbol(symbol);
        }
    }

    findActorStockBySymbol = (symbol) => {
        ActorStockService.editActorStock(symbol)
        .then(response =>  {
            if (response.data != 0) {
                console.log(response.data.actor_dob);
                this.setState({
                    symbol: response.data.symbol,
                    actor_name: response.data.actor_name,
                    actor_dob: response.data.actor_dob,
                });
            }
        })
        .catch (e => {
          console.log(e);  
        });
    }

    updateActorStock = event => {
        event.preventDefault();

        const actorstock = {
            symbol: this.state.symbol,
            actor_name: this.state.actor_name,
            actor_dob: this.state.actor_dob,
        }
        ActorStockService.updateActorStock(actorstock)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("ActorStock Updated Successfully!");
            } else {
                alert("Cannot upate actorstock. Something wrong!");
            }
        })
    }

    resetForm = () => {
        this.setState(() => this.initialState);
    }

    add_actorstock_button(event) {
        alert("Are you sure you want to add new actorstock?");
        event.preventDefault();

        const newactorstock = {
            symbol: this.state.symbol,
            actor_name: this.state.actor_name,
            actor_dob: this.state.actor_dob,
        };

        ActorStockService.createActorStock(newactorstock)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("ActorStock Added Successfully!");
            } else {
                alert("Cannot add actorstock. symbol might already exist!");
            }
        }).catch (e => {
            console.log(e);
        });
        

    }

    actorStockChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    actorstockPasswordChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    render() {
        const {
            symbol,
            actor_name,
            actor_dob,
        } = this.state;
        return (
            <>

                <h1 className="text-center">{this.props.match.params.symbol ? "Edit ActorStock" : "Add New ActorStock"} </h1>
          
            <Card className={"mb3"}>
                {/* <Card.Header>
                    Add New ActorStock
                </Card.Header> */}
                

            <Form onSubmit={this.add_actorstock_button} id="actorstockFormId" >
                <Card.Body>
                    <Form.Row>

                        <Form.Group as={Col} controlId="symbol">
                            <Form.Label>Symbol</Form.Label>
                            <Form.Control 
                                type="test"
                                name="symbol"
                                value={symbol.toUpperCase()}
                                onChange={this.actorStockChange}
                                className={"mb3"}
                                placeholder="Enter your Fullname. Maximum 20 Characters" 
                                maxLength="3"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="dob">
                            <Form.Label>Date of Birth</Form.Label>
                            <Form.Control 
                                type="date" 
                                name="actor_dob"
                                value={actor_dob}
                                onChange={this.actorStockChange}
                                className={"mb3"}
                                placeholder="Date of Birth" 
                            /></Form.Group>
{/* 
                                <Form.Group as={Col} controlId="formGridsymbol">
                                <ControlLabel>Label</ControlLabel>
                                <DatePicker id="example-datepicker" value={this.state.value} onChange={this.handleChange} />
                                <HelpBlock>Help</HelpBlock>
                        </Form.Group> */}

                        {/* <Form.Label>Label</Form.Label>
                        <DatePicker id="example-datepicker" value={this.state.value} onChange={this.handleChange} />
                        <HelpBlock>Help</HelpBlock>
                         */}

                    </Form.Row>

                    <Form.Row>
                        <Form.Group as={Col} controlId="fullname">
                            <Form.Label >Actor's Name</Form.Label>
                            <Form.Control 
                                type="text"
                                name="actor_name"
                                value={actor_name}
                                onChange={this.actorStockChange}
                                className={"mb3"}
                                placeholder="Enter password. Maximum 20 Characters" 
                                maxLength="30"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="dobread">
                            <Form.Label >Date Of Birth will be saved as</Form.Label>
                            <Form.Control 
                                type="text"
                                name="actor_dob"
                                value={actor_dob}
                                onChange={this.actorStockChange}
                                className={"mb3"}
                                readOnly
                            />
                        </Form.Group>
                    </Form.Row>

                    
                </Card.Body>

                <Card.Footer className="text-right">
                    <Button type="summit" variant="success" onClick={this.props.match.params.symbol ? this.updateActorStock : this.add_actorstock_button}>
                        {this.props.match.params.symbol ? "Edit Actor Stock" : "Add New Actor Stock"}
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

export default ActorStock;