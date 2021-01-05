package devsuperior.miranda.cordeiro.dsdelivery.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import devsuperior.miranda.cordeiro.dsdelivery.dto.OrderDTO;
import devsuperior.miranda.cordeiro.dsdelivery.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO>findAll(){
	return repository.findOrderWithProducts().stream().map(x -> new OrderDTO(x)) .collect(Collectors.toList());}
	

}
