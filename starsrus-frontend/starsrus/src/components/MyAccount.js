import React, {useState} from "react";
import MasketTransactionService from "../services/MarketTransactionService";
import {ButtonGroup, Button, Modal} from "react-bootstrap";
import {Link} from "react-router-dom";

class MyAccount extends React.Component {
    constructor (props) {
        super(props)
        this.state = {
            marketTransactions:[],
            show: false,
            symbol: "",
        };
    }

    componentDidMount() {
        MasketTransactionService.get().then((response) => {
            console.log("AAAAAAAAAAAAAAAA================", response.data);
            this.setState({marketTransactions: response.data})
        });
    }
    
    render() {
        // const [show, setShow] = useState(false);

        return (
            <div>
                <h1 className="text-center"> My Account </h1>
                <p>
                <Link to="/withdraw" className="btn btn-success">Withdraw</Link>
                
                {" "}

                <Link to="/deposit" className="btn btn-warning">Deposit</Link>

                </p>
                <p>
                    {/* {this.state.stockmarkets[0].closing_price? "The Market is Closed" : "The Market is Open."} */}
                </p>
                <table className="table table-striped text-center" >
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Date</td>
                            <td>Amount</td>
                            <td>Username</td>
                        </tr>
                    </thead>
                    <tbody>
                    {   this.state.marketTransactions.length === 0 ?
                        <tr> <td  colspan="6">No Transactions Available.</td>
                        </tr>
                        :
                        this.state.marketTransactions.map(
                            marketTransaction => 
                            <tr key = {marketTransaction._deposit_id}>
                                <td >{marketTransaction._deposit_id}</td>
                                <td >{marketTransaction._deposit_date}</td>
                                <td >{marketTransaction._deposit_amount}</td>
                                <td >{marketTransaction._username}</td>
                            </tr>
                        )
                    }
                </tbody>
                </table>                    
            </div>
        )
    }
}

export default  MyAccount;