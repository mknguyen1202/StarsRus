import axios from 'axios';

const ACTORSTOCK_REST_API_URL = "http://localhost:8080/api/actorMovie";

class ActorMovieService {
    getActorMovies() {
        return axios.get(ACTORSTOCK_REST_API_URL);
    }

    createActorMovie(data) {
        return axios.post("http://localhost:8080/api/add_actorMovie", data);
    }

    deleteActorMovie(data) {
        return axios.delete("http://localhost:8080/api/actorMovie/" + data);
    }

    editActorMovie(data) {
        return axios.get("http://localhost:8080/api/actorMovie/" + data);
    }

    updateActorMovie(data) {
        return axios.put("http://localhost:8080/api/add_actorMovie", data);
    }


}

export default new ActorMovieService();
