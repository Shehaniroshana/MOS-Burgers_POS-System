package MOS.ecom.repository;

import MOS.ecom.entity.Item_Entity;
import MOS.ecom.util.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Item_repository extends CrudRepository<Item_Entity,Integer> {
    public Item_Entity findByName(String name);
    public List<Item_Entity> findByNameContaining(String name);
    public List<Item_Entity> findByCategory(Category category);
}
