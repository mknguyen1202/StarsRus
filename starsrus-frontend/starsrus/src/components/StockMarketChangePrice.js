// import axios from "axios";
import React, {Component} from "react";
import {Card, Form, Button, Col} from "react-bootstrap";
import StockMarketService from "../services/StockMarketService";


class StockMarketChangePrice extends Component {
    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.actorStockChange = this.actorStockChange.bind(this);
        this.add_stockmarket_button = this.add_stockmarket_button.bind(this);

    }

    // {"symbol":"alfred","password":"hi","name":"Alfred Hitchcock",
    // "address":"6667 El Colegio #40 SB","state":"CA","phoneNumber":"(805)2574499",
    // "email":"alfred@hotmail.com","ssn":"606-76-7900","tid":"1022"}

    initialState = {
        stocktime:"",
        current_price:"",
        closing_price:"",
        last_closing_price:"",
        symbol:"",
        newprice:""
    }

    componentDidMount() {
        const symbol =  this.props.match.params.symbol;
        const stocktime = this.props.match.params.stocktime;
        console.log("MOUNTMOUNTMOUNT-----", stocktime);
        console.log(symbol);
        if (symbol) {
            this.findStockMarketChangePriceBySymbol(symbol +"/"+ stocktime);
        }
    }

    findStockMarketChangePriceBySymbol = (symbol) => {
        StockMarketService.edit(symbol)
        .then(response =>  {
            console.log("BBBBBBBBBBBBB-----", response.data);
            if (response.data != 0) {
                console.log(response.data.actor_dob);
                this.setState({
                    stocktime: response.data.stocktime,
                    current_price: response.data.current_price,
                    closing_time: response.data.closing_price,
                    last_closing_price: response.data.last_closing_price,
                    symbol: response.data.symbol
                });
            }
        })
        .catch (e => {
          console.log(e);  
        });
    }

    updateStockMarketChangePrice = event => {
        event.preventDefault();

        const stockmarket = {
            symbol: this.state.symbol,
            actor_name: this.state.actor_name,
            actor_dob: this.state.actor_dob,
        }
        StockMarketService.update(stockmarket)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("StockMarketChangePrice Updated Successfully!");
            } else {
                alert("Cannot upate stockmarket. Something wrong!");
            }
        })
    }

    resetForm = () => {
        this.setState(() => this.initialState);
    }

    add_stockmarket_button(event) {
        alert("Are you sure you want to change the price of the stock?");
        event.preventDefault();

        const newstockmarket = {
            symbol: this.state.symbol,
            current_price: this.state.newprice,
            closing_price: -1,
            stocktime: null
        };

        console.log("============ IN STOCKMARKET ADD", newstockmarket)

        StockMarketService.create(newstockmarket)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("StockMarketChangePrice Added Successfully!");
                this.props.history.push('/stockmarket');
            } else {
                alert("Cannot add stockmarket. symbol might already exist!");
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

    stockmarketPasswordChange(event) {
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    render() {
        const {
            stocktime,
            current_price,
            closing_price,
            last_closing_price,
            symbol,
            newprice
        } = this.state;
        return (
            <>

                <h1 className="text-center">{this.props.match.params.symbol ? "Change Stock Price" : "Add New StockMarketChangePrice"} </h1>
             <p>

             Stock of which the price to be changed: {" "}<Button className="text-white" variant="info">{this.props.match.params.symbol}</Button>
             </p>
            <Card className={"mb3"}>
                {/* <Card.Header>
                    Add New StockMarketChangePrice
                </Card.Header> */}
                

            <Form onSubmit={this.add_stockmarket_button} id="stockmarketFormId" >
                <Card.Body>
                    <Form.Row>

                        <Form.Group as={Col} controlId="symbol">
                            <Form.Label>Current Price in $</Form.Label>
                            <Form.Control readOnly
                                type="text"
                                name="symbol"
                                value={current_price}
                                onChange={this.actorStockChange}
                                className={"mb3"}
                                placeholder="Enter your Fullname. Maximum 20 Characters" 
                                maxLength="3"
                            />
                        </Form.Group>

                        <Form.Group as={Col} controlId="symbol">
                            <Form.Label>New Price in $</Form.Label>
                            <Form.Control 
                                type="number"
                                name="newprice"
                                
                                onChange={this.actorStockChange}
                                className={"mb3"}
                                placeholder="Enter your Fullname. Maximum 20 Characters" 
                                maxLength="7"
                            />
                        </Form.Group>
                    </Form.Row>
                    
                </Card.Body>

                <Card.Footer className="text-right">
                    <Button type="summit" variant="warning" onClick={this.add_stockmarket_button}>
                        {/* {this.props.match.params.symbol ? "Edit Actor Stock" : "Add New Actor Stock"} */}
                        CHANGE PRICE
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

export default StockMarketChangePrice;