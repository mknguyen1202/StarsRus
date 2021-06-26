import axios from 'axios';

class LoginService {

    
    getCustomers() {
        return axios.get("http://localhost:8080/api/customer");
    }

    createCustomer(data) {
        return axios.post("http://localhost:8080/api/add_customer", data);
    }

    deleteCustomer(data) {
        console.log("IN LOGIN SERVICE: ", data);
        return axios.delete("http://localhost:8080/api/customer/" + data);
    }

    editCustomer(data) {
        return axios.get("http://localhost:8080/api/login/" + data);
    }

    updateCustomer(data) {
        return axios.put("http://localhost:8080/api/add_customer", data);
    }
}

export default new LoginService();
