package softuni.bg.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import softuni.bg.model.user.ShareRideUserDetails;

import java.util.Collections;

@Service
public class TestUserDataService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new ShareRideUserDetails(
                "topsecret",
                username,
                "Test",
                "user",
                Collections.emptyList());
    }
}
