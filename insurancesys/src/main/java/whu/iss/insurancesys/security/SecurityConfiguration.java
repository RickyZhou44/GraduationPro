package whu.iss.insurancesys.security;

/*
 * @Author SeanShe
 * @Date 2019/3/30 13:33
 * Notes:
 * */

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Controller
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth
                .authenticationProvider(usernamePasswordAuthenticationProvider);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .addFilterAt(AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                //.antMatchers("/**").permitAll()//规则，权限
                .antMatchers("/feeRate/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .permitAll()
                .and()
                .logout().logoutSuccessHandler(new LogoutSuccessHandler())
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");

    }

    class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
                throws IOException, ServletException {

            JSONObject returnObj = new JSONObject();
            returnObj.put("status", "1");
            returnObj.put("username", auth.getPrincipal());
            returnObj.put("otherInfo", auth.getDetails());
            response.getWriter().print(returnObj.toString());
            response.getWriter().flush();

        }
    }

    @Bean
    public SimpleUrlAuthenticationSuccessHandler authenticationSuccessHandler() {
        AuthenticationSuccessHandler authenticationSuccessHandler = new AuthenticationSuccessHandler();
        return authenticationSuccessHandler;
    }

    class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                            AuthenticationException exception)
                throws IOException, ServletException {

            JSONObject returnObj = new JSONObject();
            returnObj.put("status", "2");
            returnObj.put("reason", exception.getMessage());
            response.getWriter().print(returnObj.toString());
            response.getWriter().flush();

        }
    }

    @Bean
    public SimpleUrlAuthenticationFailureHandler authenticationFailureHandler() {
        AuthenticationFailureHandler authenticationFailureHandler = new AuthenticationFailureHandler();
        return authenticationFailureHandler;
    }

    class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

        @Override
        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

            request.getRequestDispatcher("/logoutSucceed").forward(request, response);

        }

    }

    @Bean
    public AuthenticationFilter AuthenticationFilter() {

        AuthenticationFilter filter = new AuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager);
        return filter;

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();

    }

}
