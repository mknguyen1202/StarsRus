import axios from 'axios'

const WITHDRAW_REST_API_URL = "http://localhost:8080/api/withdraw";

class WithdrawService {
    getWithdraw() {
        return axios.get("http://localhost:8080/api/withdraw");
    }

    createWithdraw(data) {
        return axios.post("http://localhost:8080/api/add_withdraw", data);
    }

    deleteWithdraw(data) {
        return axios.delete("http://localhost:8080/api/withdraw/" + data);
    }

    editWithdraw(data) {
        return axios.get("http://localhost:8080/api/withdraw/" + data);
    }

    updateWithdraw(data) {
        return axios.put("http://localhost:8080/api/add_withdraw", data);
    }
}

export default new WithdrawService();
