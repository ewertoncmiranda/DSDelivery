package devsuperior.miranda.cordeiro.dsdelivery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import devsuperior.miranda.cordeiro.dsdelivery.entities.Order;
import devsuperior.miranda.cordeiro.dsdelivery.entities.OrderStatus;

public class OrderDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String address;
	private Double latitude ;
	private Double longitude ;
	private Instant moment;
	private OrderStatus status ;
	
	
	private List<ProductDTO> products = new ArrayList<>();
	
	public OrderDTO() {};
	
	public OrderDTO(Order entity) {
		address = entity.getAdress();
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
		moment = entity.getMoment();
		status = entity.getStatus();
		
		products = entity.getProducts().stream()
		  .map(x-> new ProductDTO(x)).collect(Collectors.toList());
	}
	
	public OrderDTO(String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}
	
	
	
}
