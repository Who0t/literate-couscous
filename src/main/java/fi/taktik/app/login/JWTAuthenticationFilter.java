package fi.taktik.app.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.core.Authentication;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Handles filtering on authenticating.
 *
 * Alot background magic happening here which JWT and oAuth does.
 *
 * Created by Juuso Ahtiainen on 26/04/2017.
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain filterChain) throws IOException, ServletException {

        Authentication auth = TokenAuthenticationService.getAuthentication((HttpServletRequest)req);

        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(req, res);
    }
}
