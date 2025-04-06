package MOS.ecom.service;

import MOS.ecom.dto.Customer_DTO;

import java.util.List;

public interface Customer_Service {
    boolean addCustomer(Customer_DTO customer_dto);
    List<Customer_DTO> getAllCustomers();
    List<Customer_DTO> searchCustomer(String name);
    boolean updateCustomer(Customer_DTO customer_dto);
    boolean deleteCustomer(Integer id);
    List<Integer> getAllCustomerIds();
    Customer_DTO getCustomerById(Integer id);
    boolean updateCustomerPoints(Integer id, Double points);
}
