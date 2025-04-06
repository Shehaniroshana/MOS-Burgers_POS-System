package MOS.ecom.service.Impl;

import MOS.ecom.dto.Order_DTO;
import MOS.ecom.entity.Item_Details_Entity;
import MOS.ecom.entity.Order_Entity;
import MOS.ecom.repository.Order_repository;
import MOS.ecom.service.Order_Service;
import MOS.ecom.util.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Order_Service_Impl implements Order_Service {

    final Order_repository repository;
    final ModelMapper mapper;

    @Override
    public boolean saveOrder(Order_DTO dto) {
        Order_Entity orderEntity = mapper.map(dto, Order_Entity.class);
        for (Item_Details_Entity itemDetails : orderEntity.getItemDetails()) {
            itemDetails.setOrder(orderEntity);
        }
        repository.save(orderEntity);
        return true;
    }

    @Override
    public boolean updateOrder(Order_DTO dto) {
        Order_Entity orderEntity = mapper.map(dto, Order_Entity.class);
        for (Item_Details_Entity itemDetails : orderEntity.getItemDetails()) {
            itemDetails.setOrder(orderEntity);
        }
        repository.save(orderEntity);
        return true;
    }

    @Override
    public boolean deleteOrder(Integer id) {
         repository.deleteById(id);
         return true;
    }

    @Override
    public List<Order_DTO> getAllOrders() {
        List<Order_DTO> list = new ArrayList<>();
        for (Order_Entity order : repository.findAll()) {
            list.add(mapper.map(order, Order_DTO.class));
        }
        return list;
    }

    @Override
    public List<Order_DTO> SearchByCustomer(String name) {
        List<Order_DTO> list=new ArrayList<>();
        for(Order_Entity order:repository.findByCustomerNameContaining(name)){
            list.add(mapper.map(order,Order_DTO.class));
        }
       return list;
    }

    @Override
    public List<Order_DTO> SearchByStatus(OrderStatus status) {
        List<Order_DTO> list=new ArrayList<>();
        for(Order_Entity order:repository.findByStatus(status)){
            list.add(mapper.map(order,Order_DTO.class));
        }
        return list;
    }

    @Override
    public boolean updateStatus(Integer id, OrderStatus status) {
        Optional<Order_Entity> byId = repository.findById(id);
        byId.get().setStatus(status);
        repository.save(byId.get());
        return true;
    }

    @Override
    public List<Order_DTO> recentOrders() {
        Iterable<Order_Entity> all = repository.findAll();
        List<Order_DTO> list=new ArrayList<>();
        for(Order_Entity order:all){
            list.add(mapper.map(order,Order_DTO.class));
        }
       list.sort(Comparator.comparing(Order_DTO::getOrderDate,Comparator.reverseOrder()));
        return list;
    }

}
