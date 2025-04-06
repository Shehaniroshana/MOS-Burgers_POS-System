package MOS.ecom.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NotNull(message = "All fields are required")
public class Customer_DTO {
    private Integer id;
    private String name;
    private String contact;
    private Double loyaltyPoints;
}
