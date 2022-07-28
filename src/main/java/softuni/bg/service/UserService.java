package softuni.bg.service;

import org.springframework.stereotype.Service;
import softuni.bg.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
