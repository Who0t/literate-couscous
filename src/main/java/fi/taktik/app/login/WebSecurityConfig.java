package fi.taktik.app.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.util.Collections;

/**
 * Login security configs.
 * Currently requests authentication only from /test/testLogin
 * Some background magic happening here.
 *
 * TODO:
 * !!! Currently no hash of any kind on passwords !!!
 *
 * Created by Juuso Ahtiainen on 26/04/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountCredentialsRepository database;

    /**
     * Confs the allowed and unallowed URI:s.
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
     * Allowed Users are fetched from the database.
     *
     * @param auth Given auth manager.
     * @throws Exception Possible thrown exception.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles("ADMIN");*/

        auth.userDetailsService(username -> {
            try {

                Iterable<AccountCredentials> accounts = database.findAll();

                for(AccountCredentials acc : accounts) {

                    if(username.equals(acc.getUsername())) {
                        return new User(acc.getUsername(), acc.getPassword(), Collections.singleton(new
                                SimpleGrantedAuthority("USER")));
                    }
                }

                throw new UsernameNotFoundException("invalid Username");
            } catch (Exception e) {
                throw new UsernameNotFoundException("invalid Username");
            }
        });
    }
}
