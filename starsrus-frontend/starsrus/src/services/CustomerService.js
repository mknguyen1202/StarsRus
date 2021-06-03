import axios from 'axios';

const CUSTOMERS_REST_API_URL = "http://localhost:8080/api/customer";

class CustomerService {
    getCustomers() {
        return axios.get("http://localhost:8080/api/customer");
    }

    createCustomer(data) {
        return axios.post("http://localhost:8080/api/add_customer", data);
    }

    deleteCustomer(data) {
        return axios.delete("http://localhost:8080/api/customer/" + data);
    }

    editCustomer(data) {
        return axios.get("http://localhost:8080/api/customer/" + data);
    }

    updateCustomer(data) {
        return axios.put("http://localhost:8080/api/add_customer", data);
    }


}

export default new CustomerService();
