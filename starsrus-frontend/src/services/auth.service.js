import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  login(username, password) {
    return axios
      .post(API_URL + "signin", { username, password })
      .then((response) => {
        if (response.data.accessToken) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(
          username,
          password,
          firstname,
          lastname,
          dob,
          address,
          state,
          phone,
          email,
          ssn,
          role) {
    return axios.post(API_URL + "signup", {
      username,
      password,
      firstname,
      lastname,
      dob,
      address,
      state,
      phone,
      email,
      ssn,
      role
    });
  }
}

export default new AuthService();