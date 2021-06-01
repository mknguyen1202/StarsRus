import React from "react";
import CustomerService from "../services/CustomerService";

class CustomerComponent extends React.Component {
    constructor (props) {
        super(props)
        this.state = {
            customers:[]
        }
    }

    componentDidMount() {
        CustomerService.getCustomers().then((response) => {
            this.setState({customers: response.data})
        });
    }
    render() {
        return (
            <div>
                <h1 className="text-center"> Customer List </h1>
                <table className="table table-striped" >
                    <thead>
                        <tr>
                            <td>Username</td>
                            <td>Full Name</td>
                            <td>Address</td>
                            <td>Email</td>
                            <td>Phone Number</td>
                            <td>State</td>
                           
                        </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.customers.map(
                            customer => 
                            <tr key = {customer.username}>
                                <td>{customer.username}</td>
                                <td>{customer.name}</td>
                                <td>{customer.address}</td>
                                <td>{customer.email}</td>
                                <td>{customer.phoneNumber}</td>
                                <td>{customer.state}</td>
                            </tr>
                        )
                    }
                </tbody>
                </table>


            </div>
        )
    }
}

export default CustomerComponent;