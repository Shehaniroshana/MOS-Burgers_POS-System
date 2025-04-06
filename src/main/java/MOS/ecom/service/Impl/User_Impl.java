package MOS.ecom.service.Impl;

import MOS.ecom.dto.User_DTO;
import MOS.ecom.entity.User_Entity;
import MOS.ecom.repository.User_repository;
import MOS.ecom.service.User_Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class User_Impl implements User_Service {

    final User_repository repository;
    final ModelMapper mapper;
    final BCryptPasswordEncoder encoder;

    @Override
    public boolean saveUser(User_DTO user_dto) {
        if (repository.findByEmail(user_dto.getEmail()) != null){
            return false;
        }else {
            user_dto.setPassword(encoder.encode(user_dto.getPassword()));
            repository.save(mapper.map(user_dto, User_Entity.class));
            return true;
        }
    }

    @Override
    public boolean authenticateUser(String email, String password) {
        User_Entity user = repository.findByEmail(email);
        return user != null && encoder.matches(password, user.getPassword());
    }

    @Override
    public String sendOtp() {
        // Implement OTP sending logic here
        return "OTP_SENT";
    }

    @Override
    public boolean verifyOtp(String otp) {
        // Implement OTP verification logic here
        return true;
    }

    @Override
    public List<User_DTO> getAll() {
        List<User_DTO> list = new ArrayList<>();
        for (User_Entity user : repository.findAll()) {
            list.add(mapper.map(user, User_DTO.class));
        }
        return list;
    }
}