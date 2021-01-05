package devsuperior.miranda.cordeiro.dsdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import devsuperior.miranda.cordeiro.dsdelivery.entities.Order;


public interface OrderRepository extends JpaRepository<Order,Long> {

}
