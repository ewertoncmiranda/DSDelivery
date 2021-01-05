package devsuperior.miranda.cordeiro.dsdelivery.services;


import java.util.List;

import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import devsuperior.miranda.cordeiro.dsdelivery.dto.ProductDTO;


import devsuperior.miranda.cordeiro.dsdelivery.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository ;
	
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
	
	return repository.findAllByOrderByNameAsc().stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	
		
	}

}
