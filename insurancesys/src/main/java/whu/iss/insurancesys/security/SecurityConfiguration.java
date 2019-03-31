package whu.iss.insurancesys.security;

/*
 * @Author SeanShe
 * @Date 2019/3/30 13:33
 * Notes:
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import whu.iss.insurancesys.security.AuthenticationFilter;
import whu.iss.insurancesys.security.UsernamePasswordAuthenticationProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

    @Autowired
    AuthenticationManager authenticationManager;

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
                .successForwardUrl("/loginSucceed")
                .failureForwardUrl("/loginFail")
                .permitAll()
                .and()
                .logout().logoutSuccessHandler(new LogoutSuccessHandler())
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");

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
