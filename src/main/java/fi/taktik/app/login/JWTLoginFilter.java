package fi.taktik.app.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Handles authentications.
 * Some background magic happening here.
 *
 * Created by Juuso Ahtiainen on 26/04/2017.
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter{

    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    /**
     * Snatches the POST request from login page and tries to process it.
     *
     * @param req http request
     * @param res http response
     * @return either success or failure on authenticating.
     * @throws AuthenticationException Exception occurring while authenticating makes its magic.
     * @throws IOException Exception occurring while authenticating makes its magic.
     * @throws ServletException Exception occurring while authenticating makes its magic.
     */
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req,
            HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {

        AccountCredentials creds = new ObjectMapper()
                .readValue(req.getInputStream(), AccountCredentials.class);

        return getAuthenticationManager()
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                        creds.getUsername(),
                        creds.getPassword(),
                        Collections.emptyList())
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        TokenAuthenticationService.addAuthentication(res, auth.getName());
    }
}
