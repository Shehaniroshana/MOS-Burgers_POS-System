package MOS.ecom.entity;

import MOS.ecom.util.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Integer qty;
    private String imagePath;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Double discount;
}
