import axios from 'axios'

const DEPOSIT_REST_API_URL = "http://localhost:8080/api/deposit";

class DepositService {
    getDeposit() {
        return axios.get("http://localhost:8080/api/deposit");
    }

    createDeposit(data) {
        return axios.post("http://localhost:8080/api/add_deposit", data);
    }

    deleteDeposit(data) {
        return axios.delete("http://localhost:8080/api/deposit/" + data);
    }

    editDeposit(data) {
        return axios.get("http://localhost:8080/api/deposit/" + data);
    }

    updateDeposit(data) {
        return axios.put("http://localhost:8080/api/add_deposit", data);
    }
}

export default new DepositService();
