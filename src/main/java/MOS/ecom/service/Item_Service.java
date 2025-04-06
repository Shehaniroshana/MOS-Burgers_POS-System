package MOS.ecom.service;

import MOS.ecom.dto.Item_DTO;
import MOS.ecom.util.Category;

import java.util.List;

public interface Item_Service {
    public boolean addItem(Item_DTO item);
    public boolean deleteItem(Integer id);
    public boolean updateItem(Item_DTO item);
    public List<Item_DTO> searchItem(String name);
    public List<Item_DTO> getAllItems();
    public List<Item_DTO> getItemsByCategory(Category category);
    public boolean updateQty(Integer id,Integer qty);
    public Integer getQty(Integer id);
    public List<Object> getInventoryStatus();
}
