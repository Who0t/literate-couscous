package fi.taktik.app.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Login security configs.
 * Currently requests authentication only from /test/testLogin
 * Some background magic happening here.
 *
 * Created by Juuso Ahtiainen on 26/04/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Confs the allowed and undallowed URI:s.
     *
     * @param http http given to method.
     * @throws Exception Possible thrown exception.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers().permitAll()
                .antMatchers("/test/testLogin").authenticated()
                .and()
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    /***
     * Checks the given UN and PW with allowed users.
     *
     * @param auth Given auth manager.
     * @throws Exception Possible thrown exception.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles("ADMIN");
    }
}
