package MOS.ecom.entity;

import MOS.ecom.util.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer customerId;
    private String customerName;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item_Details_Entity> itemDetails;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Double totalAmount;
    private LocalDate orderDate;
}
