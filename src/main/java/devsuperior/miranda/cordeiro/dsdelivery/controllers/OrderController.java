package devsuperior.miranda.cordeiro.dsdelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devsuperior.miranda.cordeiro.dsdelivery.dto.OrderDTO;
import devsuperior.miranda.cordeiro.dsdelivery.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	OrderService service ;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findall(){
	return ResponseEntity.ok().body(service.findAll()); 
	}
	
	

}
