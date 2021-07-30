package cs174.starsrus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs174.starsrus.entities.StockWrapper;
import cs174.starsrus.entities.StockWrapperTester;
import cs174.starsrus.services.StockService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class StockController {

    @Autowired
	private StockService stockService;
	
	@GetMapping("/all/stock")
	public StockWrapperTester findStockWrapper() {
		return stockService.findStock("INTC");
	}
	

	// @GetMapping("/all/stock")
	// public StockWrapper findStockWrapper() {
	// 	return stockService.findStock("INTC");
	// }
	
	// @GetMapping("/user")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	// public String userAccess() {
	// 	return "User Content.";
	// }

	// @GetMapping("/mod")
	// @PreAuthorize("hasRole('MODERATOR')")
	// public String moderatorAccess() {
	// 	return "Moderator Board.";
	// }

	// @GetMapping("/admin")
	// @PreAuthorize("hasRole('ADMIN')")
	// public String adminAccess() {
	// 	return "Admin Board.";
	// }
    
}
