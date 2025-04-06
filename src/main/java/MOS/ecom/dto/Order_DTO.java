package MOS.ecom.dto;

import MOS.ecom.entity.Item_Details_Entity;
import MOS.ecom.util.OrderStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Data
public class Order_DTO {
    private Integer id;
    private Integer customerId;
    private String customerName;
    private List<Item_Details_DTO> itemDetails;
    private OrderStatus status;
    private Double totalAmount;
    private LocalDate orderDate;

}
