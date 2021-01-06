package devsuperior.miranda.cordeiro.dsdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import devsuperior.miranda.cordeiro.dsdelivery.dto.OrderDTO;
import devsuperior.miranda.cordeiro.dsdelivery.dto.ProductDTO;
import devsuperior.miranda.cordeiro.dsdelivery.entities.Order;
import devsuperior.miranda.cordeiro.dsdelivery.entities.OrderStatus;
import devsuperior.miranda.cordeiro.dsdelivery.entities.Product;
import devsuperior.miranda.cordeiro.dsdelivery.repositories.OrderRepository;
import devsuperior.miranda.cordeiro.dsdelivery.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository ;
	
	
	@Transactional(readOnly = true)
	public List<OrderDTO>findAll(){
	return repository.findOrderWithProducts().stream().map(x -> new OrderDTO(x)) .collect(Collectors.toList());}
	

	@Transactional()
	public OrderDTO insert(OrderDTO dto){
		Order order = new Order(1, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(),OrderStatus.PENDING);
		
		for(ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}		
		return new OrderDTO(repository.save(order)) ;
	}
	
	
	
	@Transactional()
	public OrderDTO setDelivered(Long id){
		
		Order order = repository.getOne(id) ;
		order.setStatus(OrderStatus.DELIVERED);
		return new OrderDTO(repository.save(order));		
		
	}
	
	
	
	
	
	
	
}
