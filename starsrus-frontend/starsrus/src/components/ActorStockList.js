import React, {useState} from "react";
import ActorStockService from "../services/ActorStockService";
import {ButtonGroup, Button, Modal} from "react-bootstrap";
import {Link} from "react-router-dom";

class ActorStockList extends React.Component {
    constructor (props) {
        super(props)
        this.state = {
            actorstocks:[],
            show: false,
            symbol: "",
        };
        this.handleClose = this.handleClose.bind(this.state);
        this.handleShow = this.handleShow.bind(this);
    }

    componentDidMount() {
        ActorStockService.getActorStocks().then((response) => {
            this.setState({actorstocks: response.data})
        });
    }

    deleteActorStock = (symbol) => {
            console.log(symbol);
            ActorStockService.deleteActorStock(symbol)
            .then(response => {
                console.log(response);
                if (response.data != 0) {
                    
                    alert("ActorStock Deleted Successfully!");
                    this.setState({
                        actorstocks: this.state.actorstocks.filter(actorstock => actorstock.symbol != symbol)
                    });
                    this.handleClose();
                } else {
                    alert("Cannot delete actorstocks. Something went wrong");
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
                <h1 className="text-center"> Actor-Stock List </h1>
                <p>
                <Link to="/add_stock" className="btn btn-success">Add New Stock</Link>

                </p>
                <table className="table table-striped text-center" >
                    <thead>
                        <tr>
                            <td>Symbol</td>
                            <td>Actor's Full Name</td>
                            <td>Date of Birth (DD-MM-YYYY)</td>
                            <td>Actions</td>
                        </tr>
                    </thead>
                    <tbody>
                    {   this.state.actorstocks.length === 0 ?
                        <tr> <td  colspan="4">No Actor Stock Available.</td>
                        </tr>
                        :
                        this.state.actorstocks.map(
                            actorstock => 
                            <tr key = {actorstock.symbol}>
                                <td><Link   to={"actormovie/"+ actorstock.symbol +"/"+ actorstock.actor_name} 
                                            className="btn btn-info text-white"
                                            size="lg">
                                    {actorstock.symbol}
                                    </Link>
                                </td>
                                <td>{actorstock.actor_name}</td>
                                <td >{actorstock.actor_dob}</td>
                                <td>
                                    <ButtonGroup>
                                        
                                        <Link to={"edit_stock/"+actorstock.symbol} className="btn btn-primary">EDIT</Link>
                                        {" "}
                                        <Button variant="danger" onClick={this.handleShow.bind(this, actorstock.symbol)}>DELETE</Button>
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
                                        <Button variant="warning" onClick={this.deleteActorStock.bind(this, this.state.symbol)}>
                                            Delete ActorStock
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

export default ActorStockList;