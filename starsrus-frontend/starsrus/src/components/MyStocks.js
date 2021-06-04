import React, {useState} from "react";
import StockTransactionService from "../services/StockTransactionService";
import {ButtonGroup, Button, Modal} from "react-bootstrap";
import {Link} from "react-router-dom";

class MyStocks extends React.Component {
    constructor (props) {
        super(props)
        this.state = {
            stockTransactions:[],
            show: false,
            symbol: "",
        };
    }

    componentDidMount() {
        StockTransactionService.get().then((response) => {
            console.log("AAAAAAAAAAAAAAAA================", response.data);
            this.setState({stockTransactions: response.data})
        });
    }
    
    render() {
        // const [show, setShow] = useState(false);

        return (
            <div>
                <h1 className="text-center"> My Stocks </h1>
                <h2 className="text-center"> Table1 </h2>
                <table className="table table-striped text-center" >
                    <thead>
                        <tr>
                            <td>symbol</td>
                            <td>balance</td>
                            <td>original_buying_price</td>
                            <td>account_date</td>
                            <td>Username</td>
                        </tr>
                    </thead>
                    <tbody>
                    {   this.state.stockTransactions.length === 0 ?
                        <tr> <td  colspan="6">No Transactions Available.</td>
                        </tr>
                        :
                        this.state.stockTransactions.map(
                            stockTransaction => 
                            <tr key = {stockTransaction.symbol}>  
                                <td >{stockTransaction.symbol}</td>
                                <td >{stockTransaction.balance}</td>
                                <td >{stockTransaction.original_buying_price}</td>
                                <td >{stockTransaction.account_date}</td>
                                <td >{stockTransaction._username}</td>
                            </tr>
                        )
                    }
                </tbody>
                </table>
                <h2 className="text-center"> Table2 </h2>
                <table className="table table-striped text-center" >
                    <thead>
                        <tr>
                            <td>symbol</td>
                            <td>balance</td>
                            <td>original_buying_price</td>
                            <td>account_date</td>
                            <td>Username</td>
                        </tr>
                    </thead>
                    <tbody>
                    {   this.state.stockTransactions.length === 0 ?
                        <tr> <td  colspan="6">No Transactions Available.</td>
                        </tr>
                        :
                        this.state.stockTransactions.map(
                            stockTransaction => 
                            <tr key = {stockTransaction.symbol}>  
                                <td >{stockTransaction.symbol}</td>
                                <td >{stockTransaction.balance}</td>
                                <td >{stockTransaction.original_buying_price}</td>
                                <td >{stockTransaction.account_date}</td>
                                <td >{stockTransaction._username}</td>
                            </tr>
                        )
                    }
                </tbody>
                </table>                    
                    
            </div>
            


            
        )
    }
}

export default  MyStocks;