import axios from 'axios';

const REST_API_URL = "http://localhost:8080/api/stockmarket";

class ActorStockService {
    get(){
        return axios.get(REST_API_URL);
    }

    create(data) {
        return axios.post("http://localhost:8080/api/add_stockmarket", data);
    }

    delete(data) {
        return axios.delete("http://localhost:8080/api/stockmarket" + data);
    }

    edit(data) {
        return axios.get("http://localhost:8080/api/stockmarket" + data);
    }

    update(data) {
        return axios.put("http://localhost:8080/api/add_stockmarket", data);
    }


}

export default new ActorStockService();
