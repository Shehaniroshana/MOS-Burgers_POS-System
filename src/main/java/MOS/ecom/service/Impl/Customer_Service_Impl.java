package MOS.ecom.service.Impl;

import MOS.ecom.dto.Customer_DTO;
import MOS.ecom.entity.Customer_Entity;
import MOS.ecom.repository.Customer_repository;
import MOS.ecom.service.Customer_Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Customer_Service_Impl implements Customer_Service {
    final Customer_repository repository;
    final ModelMapper mapper;

    @Override
    public boolean addCustomer(Customer_DTO customer_dto) {
        repository.save(mapper.map(customer_dto, Customer_Entity.class));
        return true;
    }

    @Override
    public List<Customer_DTO> getAllCustomers() {
        List<Customer_DTO> list = new ArrayList<>();
        for (Customer_Entity customer : repository.findAll()) {
            list.add(mapper.map(customer, Customer_DTO.class));
        }
        return list;
    }

    @Override
    public List<Customer_DTO> searchCustomer(String name) {
        List<Customer_DTO> list = new ArrayList<>();
        for (Customer_Entity customer : repository.findByNameContaining(name)) {
            list.add(mapper.map(customer, Customer_DTO.class));
        }
        return list;
    }

    @Override
    public boolean updateCustomer(Customer_DTO customer_dto) {
        try {
            if (customer_dto.getId() == null || ! repository.existsById(customer_dto.getId())) return false;
            repository.save(mapper.map(customer_dto, Customer_Entity.class));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        try {
            if(!repository.existsById(id)) return false;
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Integer> getAllCustomerIds() {
        List<Integer> list = new ArrayList<>();
        for (Customer_Entity customer : repository.findAll()) {
            list.add(customer.getId());
        }
        return list;
    }

    @Override
    public Customer_DTO getCustomerById(Integer id) {
        return mapper.map(repository.findById(id).get(), Customer_DTO.class);
    }

    @Override
    public boolean updateCustomerPoints(Integer id, Double points) {
        repository.findById(id).ifPresent(customer -> {
            customer.setLoyaltyPoints(customer.getLoyaltyPoints()+points);
            repository.save(customer);
        });
        return true;
    }

}
