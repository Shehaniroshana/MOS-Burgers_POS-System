package MOS.ecom.controller;

import MOS.ecom.dto.Item_DTO;
import MOS.ecom.service.Item_Service;
import MOS.ecom.util.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mos/items")
@CrossOrigin
public class ItemController {
    final Item_Service service;

   @GetMapping("/test")
   public String test(){
       return "test";
   }

   @PostMapping("/saveItem")
   public boolean saveItem(@RequestBody Item_DTO itemDto){
       return service.addItem(itemDto);
   }

   @GetMapping("/getAllItems")
   public List<Item_DTO> getAllItems(){
       return service.getAllItems();
   }

   @PutMapping("/updateItem")
   public boolean updateItem(@RequestBody Item_DTO itemDto){
       return service.updateItem(itemDto);
   }

   @DeleteMapping("/deleteItem/{id}")
   public boolean deleteItem(@PathVariable Integer id){
       return service.deleteItem(id);
   }

   @GetMapping("/searchItem/{name}")
   public List<Item_DTO> searchItem(@PathVariable String name){
       return service.searchItem(name);
   }

   @GetMapping("/searchItemByCategory/{category}")
   public List<Item_DTO> searchItemByCategory(@PathVariable Category category){
       return service.getItemsByCategory(category);
   }
   @PutMapping("/updateItemQty/{id}/{qty}")
   public boolean updateItemQty(@PathVariable Integer id,@PathVariable Integer qty){
       return service.updateQty(id,qty);
   }
   @GetMapping("/getCurrentQty/{id}")
   public Integer getItemById(@PathVariable Integer id){
       return service.getQty(id);
   }

    @GetMapping("/getInventoryStatus")
    public List<Object> getInventoryStatus(){
        return service.getInventoryStatus();
    }
}
