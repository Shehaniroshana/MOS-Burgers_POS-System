package MOS.ecom.dto;

import MOS.ecom.util.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NotNull(message = "All fields are required")
public class User_DTO {
    private String userName;
    private String password;
    private UserRole role;
    private String email;
}
