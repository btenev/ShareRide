package softuni.bg.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import softuni.bg.model.entity.RoleEntity;
import softuni.bg.model.entity.UserEntity;
import softuni.bg.model.user.ShareRideUserDetails;
import softuni.bg.repository.UserRepository;

public class ShareRideUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public ShareRideUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository
                .findByEmail(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with " + username + " not found!"));
        // TODO: 20.7.2022 г. review and change exception handling
    }

    private UserDetails map(UserEntity userEntity) {
        return new ShareRideUserDetails(
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity
                        .getRoles()
                        .stream()
                        .map(this::map)
                        .toList()
        );
    }

    private GrantedAuthority map(RoleEntity roleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + roleEntity.getUserRole().name());
    }
}
