import React, {useState} from "react";
import StockMarketService from "../services/StockMarketService";
import {ButtonGroup, Button, Modal} from "react-bootstrap";
import {Link} from "react-router-dom";

class StockMarketList extends React.Component {
    constructor (props) {
        super(props)
        this.state = this.initialState;
        this.handleClose = this.handleClose.bind(this.state);
        this.handleShow = this.handleShow.bind(this);
        this.open_market = this.open_market.bind(this);
        this.close_market = this.close_market.bind(this);
    }

    initialState = {
        stockmarkets:[],
        show: false,
        symbol: "",
    }


    componentDidMount() {
        StockMarketService.get().then((response) => {
            console.log("AAAAAAAAAAAAAAAA================", response.data);
            this.setState({stockmarkets: response.data})
        });
    }

    delete = (symbol) => {
            StockMarketService.delete(symbol)
            .then(response => {
                
                if (response.data != 0) {
                    
                    alert(" Deleted Successfully!");
                    this.setState({
                        stockmarkets: this.state.stockmarkets.filter(stockmarket => stockmarket.symbol != symbol)
                    });
                    this.handleClose();
                } else {
                    alert("Cannot delete stockmarkets. Something went wrong");
                }
            }).catch (e => {
                console.log(e);
            });
        
    }


    close_market(event) {
        event.preventDefault();
        console.log(this.state);

        const newstockmarket = {
            symbol: this.state.stockmarkets.symbol,
            current_price: this.state.stockmarkets.current_price,
            closing_price: this.state.stockmarkets.current_price,
            stocktime: null
        };

        console.log("============ IN STOCKMARKET ADD", newstockmarket)

        StockMarketService.close_market(newstockmarket)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("StockMarketChangePrice Close Successfully!");
                this.componentDidMount();
            } else {
                alert("Cannot add stockmarket. symbol might already exist!");
            }
        }).catch (e => {
            console.log(e);
        });
    }

    open_market(event) {
        event.preventDefault();



        const newstockmarket = {
            symbol: this.state.symbol,
            current_price: this.state.current_price,
            closing_price: this.state.current_price,
            stocktime: null
        };

        console.log("============ IN STOCKMARKET ADD", newstockmarket)

        StockMarketService.open_market(newstockmarket)
        .then(response => {
            if (response.data != 0) {
                this.setState(this.initialState);
                alert("StockMarketChangePrice Open Successfully!");
                this.componentDidMount();
            } else {
                alert("Cannot add stockmarket. symbol might already exist!");
            }
        }).catch (e => {
            console.log(e);
        });
    }

    handleShow = (deletesymbol) => { 
        this.setState({
            show: true,
            symbol: deletesymbol
        });
    };
    handleClose = e => { 
        this.setState({
            show: false

        });
    };
    
    render() {
        // const [show, setShow] = useState(false);



        return (
            <div>
                <h1 className="text-center"> Overall Market Stock List </h1>
                <p>
                <Button to="/add_stockmarket" variant="success" onClick={this.open_market}>Open Market</Button>
                
                {" "}

                <Button to="/add_stockmarket" variant="danger" onClick={this.close_market}>Close Market</Button>

                </p>
                <p>
                    {this.state.stockmarkets.length && this.state.stockmarkets[0].closing_price === -1? "The Market is Open" : "The Market is Closed."}
                </p>
                <table className="table table-striped text-center" >
                    <thead>
                        <tr>
                            <td>Symbol</td>
                            <td>Time</td>
                            <td>Current Price</td>
                            <td>Closing Price</td>
                            <td>Last Closing Price</td>
                            <td>Actions</td>
                        </tr>
                    </thead>
                    <tbody>
                    {   this.state.stockmarkets.length === 0 ?
                        <tr> <td  colspan="6">No Stock Available.</td>
                        </tr>
                        :
                        this.state.stockmarkets.map(
                            stockmarket => 
                            <tr key = {stockmarket.symbol}>
                                <td><Link   
                                            className="btn btn-info text-white"
                                            size="lg">
                                    {stockmarket.symbol}
                                    </Link>
                                </td>
                                <td >{stockmarket.stocktime}</td>
                                <td >{stockmarket.current_price}</td>
                                <td> {stockmarket.closing_price === -1? "N/A Market is Open" : stockmarket.closing_price }</td>
                                <td >{stockmarket.last_closing_price}</td>
                                <td>
                                    <ButtonGroup >
                                        
                                        <Link to={this.state.stockmarkets.length && this.state.stockmarkets[0].closing_price === -1? 
                                        "add_stockmarket/"+stockmarket.symbol +"/"+ stockmarket.stocktime : "#"} 
                                        className="btn btn-warning"  >CHANGE PRICE</Link>
                                        {" "}
                                        
                                    </ButtonGroup>    

                                    {/* THIS IS FOR CONFIRMATION FORM*/}

                                    <Modal show={this.state.show} onHide={this.handleClose}>
                                        <Modal.Header closeButton>
                                        <Modal.Title>Warning!</Modal.Title>
                                        </Modal.Header>
                                        <Modal.Body>
                                            <p>Are you sure you want to delete this stock?</p>
                                            
                                            <p><b>{this.state.symbol}</b></p>
                                        </Modal.Body>
                                        <Modal.Footer>
                                        <Button variant="secondary" onClick={this.handleClose}>
                                            No
                                        </Button>
                                        <Button variant="warning" onClick={this.delete.bind(this, this.state.symbol)}>
                                            Delete 
                                        </Button>
                                        </Modal.Footer>
                                    </Modal>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
                </table>                    
            </div>
        )
    }
}

export default StockMarketList;