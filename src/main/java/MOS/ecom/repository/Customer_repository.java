package MOS.ecom.repository;

import MOS.ecom.entity.Customer_Entity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Customer_repository extends CrudRepository<Customer_Entity, Integer> {
    public List<Customer_Entity> findByNameContaining(String name);
}
