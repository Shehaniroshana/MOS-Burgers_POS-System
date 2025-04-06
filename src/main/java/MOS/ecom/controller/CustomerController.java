package MOS.ecom.controller;

import MOS.ecom.dto.Customer_DTO;
import MOS.ecom.service.Customer_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mos/customer")
@CrossOrigin
public class CustomerController {

    private final Customer_Service service;
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/saveCustomer")
    public boolean saveCustomer(@RequestBody Customer_DTO customerDto) {
        return service.addCustomer(customerDto);
    }

    @GetMapping("/getAllCustomers")
    public List<Customer_DTO> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/searchCustomer/{name}")
    public List<Customer_DTO> searchCustomer(@PathVariable String name) {
        return service.searchCustomer(name);
    }

    @PutMapping("/updateCustomer")
    public boolean updateCustomer(@RequestBody Customer_DTO customerDto) {
        return service.updateCustomer(customerDto);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public boolean deleteCustomer(@PathVariable Integer id) {
        return service.deleteCustomer(id);
    }

    @GetMapping("/getCustomerIds")
    public List<Integer> getCustomerIds() {
        return service.getAllCustomerIds();
    }
    @GetMapping("/getCustomerById/{id}")
    public Customer_DTO getCustomerById(@PathVariable Integer id) {
        return service.getCustomerById(id);
    }
    @PutMapping("/updateCustomerPoints/{id}/{points}")
    public boolean updateCustomerPoints(@PathVariable Integer id,@PathVariable Double points) {
        return service.updateCustomerPoints(id,points);
    }
}
