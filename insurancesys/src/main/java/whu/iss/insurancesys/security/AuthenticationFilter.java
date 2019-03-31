package whu.iss.insurancesys.security;

/*
 * @Author SeanShe
 * @Date 2019/3/30 13:39
 * Notes:
 * */

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public static final String USERNAME_KEYWORD = "username";
    public static final String PASSWORD_KEYWORD = "password";
    public static final String LOGIN_TYPE_KEYWORD = "loginType";

    private String usernameParam = USERNAME_KEYWORD;
    private String passwordParam = PASSWORD_KEYWORD;
    private String typeParam = LOGIN_TYPE_KEYWORD;

    protected AuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
                                                HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {

        if (!httpServletRequest.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + httpServletRequest.getMethod());
        }

        String username = httpServletRequest.getParameter(usernameParam);
        String password = httpServletRequest.getParameter(passwordParam);
        String type = httpServletRequest.getParameter(typeParam);//登陆方式
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        if (type == null) {
            type = "";
        }
        username = username.trim();

        AbstractAuthenticationToken token = null;
        switch (type){

            case "mobileNumber":
                //电话号码登陆方式
                break;
            default:
                token = new UsernamePasswordAuthenticationToken(username, password);
                break;

        }

        token.setDetails(authenticationDetailsSource.buildDetails(httpServletRequest));

        return this.getAuthenticationManager().authenticate(token);

    }

}
