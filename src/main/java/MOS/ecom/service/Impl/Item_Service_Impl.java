package MOS.ecom.service.Impl;

import MOS.ecom.dto.Item_DTO;
import MOS.ecom.entity.Item_Entity;
import MOS.ecom.repository.Item_repository;
import MOS.ecom.service.Item_Service;
import MOS.ecom.util.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class Item_Service_Impl implements Item_Service {

    final Item_repository repository;
    final ModelMapper mapper;

    @Override
    public boolean addItem(Item_DTO item) {
        repository.save(mapper.map(item, Item_Entity.class));
        return true;
    }

    @Override
    public boolean deleteItem(Integer id) {
         if(! repository.existsById(id)) return false;
         repository.deleteById(id);
         return true;
    }

    @Override
    public boolean updateItem(Item_DTO item) {
        if (!repository.existsById(item.getId())) return false;
        repository.save(mapper.map(item, Item_Entity.class));
        return true;
    }

    @Override
    public List<Item_DTO> searchItem(String name) {
        List<Item_DTO> list=new ArrayList<>();
        for(Item_Entity item:repository.findByNameContaining(name)){
            list.add(mapper.map(item,Item_DTO.class));
        }
        return list;
    }

    @Override
    public List<Item_DTO> getAllItems() {
        List<Item_DTO> list=new ArrayList<>();
        for(Item_Entity item:repository.findAll()){
            list.add(mapper.map(item,Item_DTO.class));
        }
        return list;
    }

    @Override
    public List<Item_DTO> getItemsByCategory(Category category) {
        List<Item_DTO> list=new ArrayList<>();
        for(Item_Entity item:repository.findByCategory(category)){
            list.add(mapper.map(item,Item_DTO.class));
        }
        return list;
    }

    @Override
    public boolean updateQty(Integer id, Integer qty) {
        repository.findById(id).ifPresent(item -> {
            item.setQty(qty);
            repository.save(item);
        });
        return true;
    }

    @Override
    public Integer getQty(Integer id) {
        return repository.findById(id).get().getQty();
    }

    @Override
    public List<Object> getInventoryStatus() {
        Map<Category, Integer> totals = new EnumMap<>(Category.class);

        Arrays.stream(Category.values())
                .forEach(category -> totals.put(category, 0));

        repository.findAll().forEach(item ->
                totals.merge(item.getCategory(), item.getQty(), Integer::sum)
        );

        return Arrays.asList(
                "burgers: " + totals.getOrDefault(Category.Burgers, 0),
                "submarines: " + totals.getOrDefault(Category.Submarines, 0),
                "pasta: " + totals.getOrDefault(Category.Pasta, 0),
                "fries: " + totals.getOrDefault(Category.Fries, 0),
                "chicken: " + totals.getOrDefault(Category.Chicken, 0),
                "beverages: " + totals.getOrDefault(Category.Beverages, 0)
        );

    }


}
