package anh.pham.iss.infrastucture.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user1")
                .password("{noop}user1")
                .build();
        UserDetails user2 = User.builder()
                .username("user2")
                .password("{noop}user2")
                .build();
        return new InMemoryUserDetailsManager(user, user2);
    }
}
