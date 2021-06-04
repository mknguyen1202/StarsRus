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

import cs174.starsrus.entities.StockMarket;
import cs174.starsrus.repositories.StockMarketRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class StockMarketController {

    @Autowired
    private StockMarketRepository stockMarketRepository;

    @GetMapping("stockmarket")
    public List<StockMarket> getStocks() {
        return this.stockMarketRepository.findAll();
    }

    @GetMapping("stockmarket/{symbol}")
    public StockMarket getStockMarketBySymbol(@PathVariable(value="symbol") String symbol) {
        System.out.println("STOCK MARKET --------------------------" + symbol);
        return this.stockMarketRepository.findBySymbol(symbol);
    }

    @PostMapping("add_stockmarket")
    public int createStock(@RequestBody StockMarket actorStock) {
        return this.stockMarketRepository.create(actorStock);
    }

    @PostMapping("open_stockmarket")
    public int openMarket(@RequestBody StockMarket actorStock) {
        return this.stockMarketRepository.createOpen(actorStock);
    }

    @PostMapping("close_stockmarket")
    public int closeMarket(@RequestBody StockMarket actorStock) {
        return this.stockMarketRepository.createClose(actorStock);
    }

    @DeleteMapping("stockmarket/{symbol}")
    public int deleteStock(@PathVariable(value="symbol") String symbol) {
        return this.stockMarketRepository.deleteBySymbol(symbol.trim());
    }

    @PutMapping("add_stockmarket")
    public int updateStock(@RequestBody StockMarket actorStock){
        return this.stockMarketRepository.update(actorStock);
    }
}
