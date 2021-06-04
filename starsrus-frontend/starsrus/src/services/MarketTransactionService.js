import axios from 'axios';

const REST_API_URL = "http://localhost:8080/api/myaccount";

class MarketTransactionService {
    get(){
        return axios.get(REST_API_URL);
    }

    create(data) {
        return axios.post("http://localhost:8080/api/add_myaccount", data);
    }

    delete(data) {
        return axios.delete("http://localhost:8080/api/myaccount" + data);
    }

    edit(data) {
        return axios.get("http://localhost:8080/api/myaccount" + data);
    }

    update(data) {
        return axios.put("http://localhost:8080/api/add_myaccount", data);
    }


}

export default new MarketTransactionService();
