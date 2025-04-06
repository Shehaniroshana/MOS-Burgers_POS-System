package MOS.ecom.entity;

import MOS.ecom.util.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NotNull(message = "All fields are required")
@Entity(name = "users")
public class User_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String email;
}
