import axios from 'axios';

const REST_API_URL = "http://localhost:8080/api/stockmarket";

class StockMarketService {
    get(){
        return axios.get(REST_API_URL);
    }

    create(data) {
        return axios.post("http://localhost:8080/api/add_stockmarket", data);
    }

    delete(data) {
        return axios.delete("http://localhost:8080/api/stockmarket/" + data);
    }

    edit(data) {
        return axios.get("http://localhost:8080/api/stockmarket/" + data);
    }

    update(data) {
        return axios.put("http://localhost:8080/api/add_stockmarket", data);
    }

    close_market(data) {
        return axios.post("http://localhost:8080/api/close_stockmarket", data);
    }
    open_market(data) {
        return axios.post("http://localhost:8080/api/open_stockmarket", data);
    }

}

export default new StockMarketService();
