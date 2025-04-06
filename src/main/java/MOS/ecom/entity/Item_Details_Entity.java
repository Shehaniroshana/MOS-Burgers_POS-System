package MOS.ecom.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "item_details")
public class Item_Details_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order_Entity order;
    private Integer itemId;
    private Integer quantity;
    private String itemName;
    private String itemImage;
}
