import axios from 'axios'

const ADMINS_REST_API_URL = "http://localhost:8080/api/admin";

class AdminService {
    getAdmins() {
        return axios.get("http://localhost:8080/api/admin");
    }

    createAdmin(data) {
        return axios.post("http://localhost:8080/api/add_admin", data);
    }

    deleteAdmin(data) {
        return axios.delete("http://localhost:8080/api/admin/" + data);
    }

    editAdmin(data) {
        return axios.get("http://localhost:8080/api/admin/" + data);
    }

    updateAdmin(data) {
        return axios.put("http://localhost:8080/api/add_admin", data);
    }
}

export default new AdminService();
