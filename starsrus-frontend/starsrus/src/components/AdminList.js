import React, {useState} from "react";
import AdminService from "../services/AdminService";
import {ButtonGroup, Button, Modal} from "react-bootstrap";
import {Link} from "react-router-dom";


class AdminList extends React.Component {
    constructor (props) {
        super(props)
        this.state = {
            admins:[],
            show: false,
            username: "",
        };
        this.handleClose = this.handleClose.bind(this.state);
        this.handleShow = this.handleShow.bind(this);
    }

    componentDidMount() {
        AdminService.getAdmins().then((response) => {
            console.log(response.data);
            this.setState({admins: response.data})
        });
    }

    deleteAdmin = (username) => {
            console.log(username);
            AdminService.deleteAdmin(username)
            .then(response => {
                console.log(response);
                if (response.data != 0) {
                    
                    alert("Admin Deleted Successfully!");
                    this.setState({
                        admins: this.state.admins.filter(admin => admin.admin_username != username)
                    });
                    this.handleClose();
                } else {
                    alert("Cannot delete admins. Something went wrong");
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
                <h1 className="text-center"> Admin List </h1>
                <p>
                <Link to="/add_admin" className="btn btn-success">Add Admin</Link>

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
                    {   this.state.admins.length === 0 ?
                        <tr colSpan="6"> No Admin Available.
                        </tr>
                        :
                        this.state.admins.map(
                            admin => 
                            <tr key = {admin.admin_username}>
                                <td>{admin.admin_username}</td>
                                <td>{admin.admin_name}</td>
                                <td>{admin.admin_address}</td>
                                <td>{admin.admin_email}</td>
                                <td>{admin.admin_phone}</td>
                                <td>{admin.admin_state}</td>
                                <td>
                                    <ButtonGroup>
                                        
                                        <Link to={"edit/"+admin.admin_username} className="btn btn-primary">EDIT</Link>
                                        {" "}
                                        <Button variant="danger" onClick={this.handleShow.bind(this, admin.admin_username)}>DELETE</Button>
                                    </ButtonGroup>    

                                    {/* THIS IS FOR CONFIRMATION FORM*/}

                                    <Modal show={this.state.show} onHide={this.handleClose}>
                                        <Modal.Header closeButton>
                                        <Modal.Title>Warning!</Modal.Title>
                                        </Modal.Header>
                                        <Modal.Body>
                                            <p>Are you sure you want to delete this admin?</p>
                                            
                                            <p><b>{this.state.username}</b></p>
                                        </Modal.Body>
                                        <Modal.Footer>
                                        <Button variant="secondary" onClick={this.handleClose}>
                                            No
                                        </Button>
                                        <Button variant="warning" onClick={this.deleteAdmin.bind(this, this.state.username)}>
                                            Delete Admin
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

export default AdminList;