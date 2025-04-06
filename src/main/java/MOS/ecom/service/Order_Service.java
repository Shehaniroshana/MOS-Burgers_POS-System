package MOS.ecom.service;


import MOS.ecom.dto.Order_DTO;
import MOS.ecom.util.OrderStatus;

import java.util.List;

public interface Order_Service {
    public boolean saveOrder(Order_DTO dto);
    public boolean updateOrder(Order_DTO dto);
    public boolean deleteOrder(Integer id);
    public List<Order_DTO> getAllOrders();
    public List<Order_DTO> SearchByCustomer(String name);
    public List<Order_DTO> SearchByStatus(OrderStatus status);
    public boolean updateStatus(Integer id,OrderStatus status);
    public List<Order_DTO> recentOrders();
}
