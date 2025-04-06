package MOS.ecom.repository;

import MOS.ecom.entity.Order_Entity;
import MOS.ecom.util.OrderStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Order_repository extends CrudRepository<Order_Entity,Integer> {
    List<Order_Entity> findByCustomerNameContaining(String name);
    List<Order_Entity> findByStatus(OrderStatus status);
}
