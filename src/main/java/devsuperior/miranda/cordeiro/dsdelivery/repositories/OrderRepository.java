package devsuperior.miranda.cordeiro.dsdelivery.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import devsuperior.miranda.cordeiro.dsdelivery.entities.Order;

@Transactional
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
	
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findOrderWithProducts();
	
	
}
