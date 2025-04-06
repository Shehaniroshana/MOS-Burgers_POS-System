package MOS.ecom.controller;

import MOS.ecom.dto.Order_DTO;
import MOS.ecom.service.Order_Service;
import MOS.ecom.util.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    final Order_Service service;
    @PostMapping("/saveOrder")
    public boolean saveOrder(@RequestBody Order_DTO dto) {
        return service.saveOrder(dto);
    }
    @GetMapping("/getAllOrders")
    public List<Order_DTO> getAllOrders() {
        return service.getAllOrders();
    }
    @PutMapping("/updateOrder")
    public boolean updateOrder(@RequestBody Order_DTO dto) {
        return service.updateOrder(dto);
    }
    @DeleteMapping("/deleteOrder/{id}")
    public boolean deleteOrder(@PathVariable("id") Integer id) {
        return service.deleteOrder(id);
    }
    @GetMapping("/searchOrder/{name}")
    public List<Order_DTO> searchOrder(@PathVariable("name") String name) {
        return service.SearchByCustomer(name);
    }
    @GetMapping("/searchOrderStatus/{status}")
    public List<Order_DTO> searchOrderStatus(@PathVariable("status") OrderStatus status) {
        return service.SearchByStatus(status);
    }
    @PutMapping("/updateOrderStatus/{id}/{status}")
    public boolean updateOrderStatus(@PathVariable("id") Integer id,@PathVariable("status") OrderStatus status) {
        return service.updateStatus(id,status);
    }
    @GetMapping("/recentOrders")
    public List<Order_DTO> recentOrders() {
        return service.recentOrders();
    }
}
