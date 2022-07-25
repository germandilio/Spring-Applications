package ru.germandilio.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails employee = User.
                withDefaultPasswordEncoder()
                .username("employee")
                .password("employee")
                .roles("EMPLOYEE")
                .build();

        UserDetails manager = User
                .withDefaultPasswordEncoder()
                .username("manager")
                .password("manager")
                .roles("MANAGER")
                .build();

        UserDetails user = User
                .withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(employee, manager, user);
    }
}
