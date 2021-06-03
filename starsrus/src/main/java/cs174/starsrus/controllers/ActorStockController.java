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

import cs174.starsrus.entities.ActorStock;
import cs174.starsrus.repositories.ActorStockRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class ActorStockController {

    @Autowired
    private ActorStockRepository actorStockRepository;

    @GetMapping("stock")
    public List<ActorStock> getStocks() {
        return this.actorStockRepository.findAll();
    }

    @GetMapping("stock/{symbol}")
    public ActorStock getActorStockBySymbol(@PathVariable(value="symbol") String symbol) {
        return this.actorStockRepository.findBySymbol(symbol);
    }

    @PostMapping("add_stock")
    public int createStock(@RequestBody ActorStock actorStock) {
        return this.actorStockRepository.create(actorStock);
    }

    @DeleteMapping("stock/{symbol}")
    public int deleteStock(@PathVariable(value="symbol") String symbol) {
        return this.actorStockRepository.deleteBySymbol(symbol.trim());
    }

    @PutMapping("add_stock")
    public int updateStock(@RequestBody ActorStock actorStock){
        return this.actorStockRepository.update(actorStock);
    }
}
