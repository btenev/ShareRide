package softuni.bg.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.model.dto.UserRegisterDto;
import softuni.bg.model.entity.RoleEntity;
import softuni.bg.model.entity.UserEntity;
import softuni.bg.model.enums.RoleEnum;
import softuni.bg.model.mapper.UserMapper;
import softuni.bg.repository.RoleRepository;
import softuni.bg.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegisterDto userRegisterDto) {
        UserEntity newUser =
                this.userMapper
                        .userRegisterDtoToUserEntity(userRegisterDto)
                        .setPassword(this.passwordEncoder.encode(userRegisterDto.getPassword()));

        RoleEntity passengerRole = this.roleRepository.findByUserRole(RoleEnum.PASSENGER);
        newUser.addRole(passengerRole);

        RoleEntity driverRole = this.roleRepository.findByUserRole(RoleEnum.DRIVER);
        newUser.addRole(driverRole);

        this.userRepository.save(newUser);
    }
}
