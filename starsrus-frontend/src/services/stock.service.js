import axios from "axios";

const API_URL = "http://localhost:8080/api/test/all/stock";

class StockService {


    getData() {
        return axios.get(API_URL);
    }
  

  }
  
  export default new StockService();