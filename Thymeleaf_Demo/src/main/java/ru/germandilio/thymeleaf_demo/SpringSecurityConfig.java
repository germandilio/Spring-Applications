package ru.germandilio.thymeleaf_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    private DataSource securityDataSource;

    @Autowired
    public void setSecurityDataSource(@Qualifier("securityDataSource") DataSource securityDataSource) {
        this.securityDataSource = securityDataSource;
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        return new JdbcUserDetailsManager(securityDataSource);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/customers/list")
                .hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                .antMatchers("/customers/edit*", "/customers/confirm-edit*", "/customers/add*", "/customers/confirm-add*")
                .hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/customers/delete*")
                .hasRole("ADMIN")
                .antMatchers("/resources/**")
                .permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");

        return httpSecurity.build();
    }
}
