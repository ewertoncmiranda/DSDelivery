package devsuperior.miranda.cordeiro.dsdelivery.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devsuperior.miranda.cordeiro.dsdelivery.entities.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product,Long> {

	public List<Product> findAllByOrderByNameAsc();
		
	
}
