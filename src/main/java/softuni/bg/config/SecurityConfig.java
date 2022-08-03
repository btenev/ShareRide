package softuni.bg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import softuni.bg.model.enums.RoleEnum;
import softuni.bg.repository.UserRepository;
import softuni.bg.service.ShareRideUserDetailsService;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new ShareRideUserDetailsService(userRepository);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // define which requests are allowed and which not
                .authorizeRequests()
                // everyone can download static resources (.css, javascript and images)
                .antMatchers("/css/**", "/js/**", "/images/**", "/bootstrap/**").permitAll()
                // everyone can log in and register
                .antMatchers("/", "/users/login", "/users/register").permitAll()
                // pages accessible to the admin
                .antMatchers("/pages/admins").hasRole(RoleEnum.ADMIN.name())
                // all other pages are accessible after user authentication - logged user
                .anyRequest().authenticated()
        .and()
                // configuration of form login
                .formLogin()
                // the custom login form
                .loginPage("/users/login")
                // the name of the username form field
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                // the name of the password form field
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                // where to go if login is successful
                .defaultSuccessUrl("/")
                // where to go if login has failed
                .failureForwardUrl("/users/login-error")
            .and()
                // configure logout
                .logout()
                // which is the logout Url
                .logoutUrl("/users/logout")
                // on logout go to the home page
                .logoutSuccessUrl("/")
                // invalidate the session and delete the cookies
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
        return http.build();
    }
}
