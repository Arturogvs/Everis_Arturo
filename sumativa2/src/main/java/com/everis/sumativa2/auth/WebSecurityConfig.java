/*package com.everis.sumativa2.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
            authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/registro","/producto/listar","/producto/ingresar","/","/login","/user/*","/categoria/*","/carrito/*","/index","/ingUser","/ingProducto","/ingCategoria" ).permitAll()
              //  .antMatchers("/index").hasRole("ROL_USER")
                .anyRequest()
                .authenticated()
                .and()
            .formLogin()
                .loginPage("/index")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
    

    
}*/