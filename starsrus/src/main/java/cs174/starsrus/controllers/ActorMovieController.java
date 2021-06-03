package cs174.starsrus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs174.starsrus.entities.ActorMovie;
import cs174.starsrus.repositories.ActorMovieRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class ActorMovieController {
    

    @Autowired
    private ActorMovieRepository actorMovieRepository;

    @GetMapping("actorMovie")
    public List<ActorMovie> getActorMovies() {
        return this.actorMovieRepository.findAll();
    }

    @GetMapping("actorMovie/{contract_id}")
    public ActorMovie getActorMovieByUsername(@PathVariable(value="contract_id") int contract_id) {
        return this.actorMovieRepository.findByContractId(contract_id);
    }

    @PostMapping("add_actorMovie")
    public int createActorMovie(@RequestBody ActorMovie actorMovie) {
        return this.actorMovieRepository.create(actorMovie);
    }

    @DeleteMapping("actorMovie/{contract_id}")
    public int deleteActorMovie(@PathVariable(value="contract_id") int contract_id) {
        return this.actorMovieRepository.deleteByContractId(contract_id);
    }

    @PutMapping("add_actorMovie")
    public int updateActorMovie(@RequestBody ActorMovie actorMovie){

        return this.actorMovieRepository.update(actorMovie);
    }
}
