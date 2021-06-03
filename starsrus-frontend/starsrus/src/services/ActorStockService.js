import axios from 'axios';

const ACTORSTOCK_REST_API_URL = "http://localhost:8080/api/stock";

class ActorStockService {
    getActorStocks() {
        return axios.get(ACTORSTOCK_REST_API_URL);
    }

    createActorStock(data) {
        return axios.post("http://localhost:8080/api/add_stock", data);
    }

    deleteActorStock(data) {
        return axios.delete("http://localhost:8080/api/stock/" + data);
    }

    editActorStock(data) {
        return axios.get("http://localhost:8080/api/stock/" + data);
    }

    updateActorStock(data) {
        return axios.put("http://localhost:8080/api/add_stock", data);
    }


}

export default new ActorStockService();
