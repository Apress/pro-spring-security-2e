package com.apress.pss.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("admin").password(passwordEncoder.encode("admin123")).roles("USER", "ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                //.antMatchers("/login*").requiresSecure(); use this to use HTTPS
                .antMatchers("/", "/index", "/login").permitAll()
                .antMatchers("/**").hasRole("ADMIN")
                .and().formLogin()
                //.and().httpBasic()  Use this for basic HTTP authentication
                // .and().formLogin().loginPage("/login").permitAll() use this for custom login page
                // .and().formLogin().loginPage("/login").permitAll().failureHandler(new CustomAuthenticationFailureHandler()) use this for custom login page and authentication failure handler
                .and().logout().deleteCookies("JSESSIONID") //use this to delete the cookies JSESSIONID when loggin out
                .and().logout().invalidateHttpSession(true) // use this to delete the http session after logging out
                .and().logout().logoutSuccessUrl("/index").permitAll()
                //.and().rememberMe().key("remember-me").rememberMeParameter("remember-me").rememberMeCookieName("rememberloginnardone").tokenValiditySeconds(100) //use this for remember-me case
                //.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS) use this for session management
                //.and().sessionManagement().maximumSessions(2) use this to have 2 sessions open at the same time
                .and().csrf().disable();

    }


    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }



}
