import React, {useState} from "react";
import CustomerService from "../services/CustomerService";
import {ButtonGroup, Button, Modal} from "react-bootstrap";
import {Link} from "react-router-dom";


class CustomerList extends React.Component {
    constructor (props) {
        super(props)
        this.state = {
            customers:[],
            show: false,
            username: "",
        };
        this.handleClose = this.handleClose.bind(this.state);
        this.handleShow = this.handleShow.bind(this);
    }

    componentDidMount() {
        CustomerService.getCustomers().then((response) => {
            this.setState({customers: response.data})
        });
    }

    deleteCustomer = (username) => {
            console.log(username);
            CustomerService.deleteCustomer(username)
            .then(response => {
                console.log(response);
                if (response.data != 0) {
                    
                    alert("Customer Deleted Successfully!");
                    this.setState({
                        customers: this.state.customers.filter(customer => customer.username != username)
                    });
                    this.handleClose();
                } else {
                    alert("Cannot delete customers. Something went wrong");
                }
            }).catch (e => {
                console.log(e);
            });
        
    }

    handleShow = (deleteusername) => { 
        this.setState({
            show: true,
            username: deleteusername
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
                <h1 className="text-center"> Customer List </h1>
                <p>
                <Link to="/add_customer" className="btn btn-success">Add Customer</Link>

                </p>
                <table className="table table-striped" >
                    <thead>
                        <tr>
                            <td>Username</td>
                            <td>Full Name</td>
                            <td>Address</td>
                            <td>Email</td>
                            <td>Phone Number</td>
                            <td>State</td>
                            <td>Actions</td>
                        </tr>
                    </thead>
                    <tbody>
                    {   this.state.customers.length === 0 ?
                        <tr colSpan="6"> No Customer Available.
                        </tr>
                        :
                        this.state.customers.map(
                            customer => 
                            <tr key = {customer.username}>
                                <td>{customer.username}</td>
                                <td>{customer.name}</td>
                                <td>{customer.address}</td>
                                <td>{customer.email}</td>
                                <td>{customer.phoneNumber}</td>
                                <td>{customer.state}</td>
                                <td>
                                    <ButtonGroup>
                                        
                                        <Link to={"edit/"+customer.username} className="btn btn-primary">EDIT</Link>
                                        {" "}
                                        <Button variant="danger" onClick={this.handleShow.bind(this, customer.username)}>DELETE</Button>
                                    </ButtonGroup>    

                                    {/* THIS IS FOR CONFIRMATION FORM*/}

                                    <Modal show={this.state.show} onHide={this.handleClose}>
                                        <Modal.Header closeButton>
                                        <Modal.Title>Warning!</Modal.Title>
                                        </Modal.Header>
                                        <Modal.Body>
                                            <p>Are you sure you want to delete this customer?</p>
                                            
                                            <p><b>{this.state.username}</b></p>
                                        </Modal.Body>
                                        <Modal.Footer>
                                        <Button variant="secondary" onClick={this.handleClose}>
                                            No
                                        </Button>
                                        <Button variant="warning" onClick={this.deleteCustomer.bind(this, this.state.username)}>
                                            Delete Customer
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

export default CustomerList;