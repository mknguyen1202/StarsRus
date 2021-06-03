import axios from 'axios';

const ACTORMOVIE_REST_API_URL = "http://localhost:8080/api/actormovie";

class ActorMovieService {
    getActorMovies() {
        return axios.get(ACTORMOVIE_REST_API_URL);
    }

    createActorMovie(data) {
        return axios.post("http://localhost:8080/api/add_actormovie", data);
    }

    deleteActorMovie(data) {
        return axios.delete("http://localhost:8080/api/actormovie/" + data);
    }

    editActorMovie(data) {
        return axios.get("http://localhost:8080/api/actormovie/" + data);
    }

    updateActorMovie(data) {
        return axios.put("http://localhost:8080/api/add_actormovie", data);
    }


}

export default new ActorMovieService();
