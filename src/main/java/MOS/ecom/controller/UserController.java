package MOS.ecom.controller;

import MOS.ecom.dto.User_DTO;
import MOS.ecom.service.User_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mos/user")
@CrossOrigin
public class UserController {

    final User_Service service;

    @PostMapping("/saveUser")
    public boolean SaveUser(@RequestBody User_DTO userDto) {
        return service.saveUser(userDto);
    }

    @GetMapping("/authenticateUser/{email}/{password}")
    public boolean authenticateUser(@PathVariable String email, @PathVariable String password) {
        return service.authenticateUser(email, password);
    }
    @GetMapping("/getAll")
    public List<User_DTO> sendOtp() {
        return service.getAll();
    }

}
