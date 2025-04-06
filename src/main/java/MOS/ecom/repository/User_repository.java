package MOS.ecom.repository;

import MOS.ecom.entity.User_Entity;
import org.springframework.data.repository.CrudRepository;

public interface User_repository extends CrudRepository<User_Entity,Integer> {
    public User_Entity findByUserName(String userName);
    public User_Entity findByEmail(String userName);

}
