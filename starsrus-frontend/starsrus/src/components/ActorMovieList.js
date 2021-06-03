import React, {useState} from "react";
import ActorMovieService from "../services/ActorMovieService";
import {ButtonGroup, Button, Modal} from "react-bootstrap";
import {Link} from "react-router-dom";

class ActorMovieList extends React.Component {
    constructor (props) {
        super(props)
        this.state = {
            actormovies:[],
            show: false,
            symbol: "",
        };
        this.handleClose = this.handleClose.bind(this.state);
        this.handleShow = this.handleShow.bind(this);
    }

    componentDidMount() {
        const symbol =  this.props.match.params.symbol;
        console.log(symbol);
        if (symbol) {
            this.findActorMovieBySymbol(symbol);
        }
    }

    findActorMovieBySymbol = (symbol) => {
        ActorMovieService.editActorMovie(symbol)
        .then(response =>  {
            if (response.data != 0) {
                console.log(response);
                this.setState({
                    actormovies: response.data
                });
                console.log("IT WORKS!" + this.state.actormovies.length);
            }
        })
        .catch (e => {
          console.log(e);  
        });
    }


    deleteActorMovie = (symbol) => {
            console.log(symbol);
            ActorMovieService.deleteActorMovie(symbol)
            .then(response => {
                console.log(response);
                if (response.data != 0) {
                    
                    alert("ActorStock Deleted Successfully!");
                    this.setState({
                        actormovies: this.state.actormovies.filter(actormovie => actormovie.symbol != symbol)
                    });
                    this.handleClose();
                } else {
                    alert("Cannot delete actormovieS. Something went wrong");
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
                <h1 className="text-center"> Actor-Movie Contract List </h1>
                <p>
                <Link to="/add_actormovie" className="btn btn-success">Add New Movie</Link>

                </p>
                <table className="table table-striped text-center" >
                    <thead>
                        <tr>
                            <td colspan="2">Actor's Name: {" "} <Button  variant="outline-info">{this.props.match.params.actor_name}</Button> </td>
                            <td >Stock Symbol: {" "}<Button className="text-white" variant="info">{this.props.match.params.symbol}</Button></td>
                        </tr>
                        <tr>
                            <td>ID</td>
                            <td>Year</td>
                            <td>Actor's Role</td>
                            <td>Movie's Title</td>
                            <td>Box Office (Total Value)</td>
                            <td>Actions</td>
                        </tr>
                    </thead>
                    <tbody>
                    {   this.state.actormovies.length === 0 ?
                        <tr> <td  colspan="6">No Movie Contract Available.</td>
                        </tr>
                        :
                        this.state.actormovies.map(
                            actormovie => 
                            <tr key = {actormovie.contract_id}>
                                <td>
                                    {actormovie.contract_id}
                  
                                </td>
                                <td>{actormovie.contract_year}</td>
                                <td>{actormovie.actor_role}</td>
                                <td>{actormovie.title}</td>
                                <td>{actormovie.total_value}</td>
                                <td>
                                    <ButtonGroup>
                                        
                                        <Link to={"edit_actormovie/"+actormovie.symbol} className="btn btn-primary">EDIT</Link>
                                        {" "}
                                        <Button variant="danger" onClick={this.handleShow.bind(this, actormovie.symbol)}>DELETE</Button>
                                    </ButtonGroup>    

                                    {/* THIS IS FOR CONFIRMATION FORM*/}

                                    <Modal show={this.state.show} onHide={this.handleClose}>
                                        <Modal.Header closeButton>
                                        <Modal.Title>Warning!</Modal.Title>
                                        </Modal.Header>
                                        <Modal.Body>
                                            <p>Are you sure you want to delete this movie?</p>
                                            
                                            <p><b>{this.state.symbol}</b></p>
                                        </Modal.Body>
                                        <Modal.Footer>
                                        <Button variant="secondary" onClick={this.handleClose}>
                                            No
                                        </Button>
                                        <Button variant="warning" onClick={this.deleteActorMovie.bind(this, this.state.symbol)}>
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

export default ActorMovieList;