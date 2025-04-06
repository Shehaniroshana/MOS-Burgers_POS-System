package MOS.ecom.dto;

import MOS.ecom.util.Category;
import lombok.Data;

@Data
public class Item_DTO {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Integer qty;
    private String imagePath;
    private Category category;
    private Double discount;
}
