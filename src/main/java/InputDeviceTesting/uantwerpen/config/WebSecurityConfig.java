package InputDeviceTesting.uantwerpen.config;

import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Niels on 23/10/2015.
 */
@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static PasswordEncoder encoder;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().antMatchers("/auth/**").authenticated(); //auto naar de login page gaan hier.
        //http.authorizeRequests().antMatchers("/auth/**").permitAll(); //Laat alles door

        http
                .authorizeRequests()
                    .antMatchers("/","/index","/**").permitAll() //iedereen mag hierop
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login") // iedereen mag deze pagina zien
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

  /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }*/

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("trol").password("trol").roles("RESEARCHER"); // in memory user credentials.

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        if(encoder == null) {
            encoder = new BCryptPasswordEncoder();
        }

        return encoder;
    }
}
