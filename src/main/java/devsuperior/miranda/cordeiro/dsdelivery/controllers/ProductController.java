package devsuperior.miranda.cordeiro.dsdelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devsuperior.miranda.cordeiro.dsdelivery.dto.ProductDTO;
import devsuperior.miranda.cordeiro.dsdelivery.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService service ;
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
	List<ProductDTO> lista = service.findAll(); 
	return ResponseEntity.ok().body(lista);	
	}
	
	
}
