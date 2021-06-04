import axios from 'axios';

const REST_API_URL = "http://localhost:8080/api/mystocks";

class StockTransactionService {
    get(){
        return axios.get(REST_API_URL);
    }

    create(data) {
        return axios.post("http://localhost:8080/api/add_mystocks", data);
    }

    delete(data) {
        return axios.delete("http://localhost:8080/api/mystocks" + data);
    }

    edit(data) {
        return axios.get("http://localhost:8080/api/mystocks" + data);
    }

    update(data) {
        return axios.put("http://localhost:8080/api/add_mystocks", data);
    }


}

export default new StockTransactionService();
