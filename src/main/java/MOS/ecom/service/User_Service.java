package MOS.ecom.service;

import MOS.ecom.dto.User_DTO;

import java.util.List;

public interface User_Service {
    boolean saveUser(User_DTO user_dto);
    boolean authenticateUser(String email, String password);
    String sendOtp();
    boolean verifyOtp(String otp);
    List<User_DTO> getAll();
}
