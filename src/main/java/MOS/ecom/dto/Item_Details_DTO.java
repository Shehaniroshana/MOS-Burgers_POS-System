package MOS.ecom.dto;

import lombok.Data;

@Data
public class Item_Details_DTO {
    private Integer id;
    private Integer itemId;
    private Integer quantity;
    private String itemName;
    private String itemImage;
}
