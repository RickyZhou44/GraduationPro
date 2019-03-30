package whu.iss.insurancesys.security;

/*
 * @Author SeanShe
 * @Date 2019/3/30 13:56
 * Notes:
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import whu.iss.insurancesys.entity.UserAccount;
import whu.iss.insurancesys.service.UserAccountService;
import whu.iss.insurancesys.util.MD5Util;

import java.util.HashSet;
import java.util.Set;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserAccountService userAccountService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        String password = (String) authentication.getCredentials();

        if(password.isEmpty()){

            throw new BadCredentialsException("Password is empty");

        }

        UserAccount userAccount = userAccountService.loginByUsername(username);
        if(userAccount == null){

            throw new BadCredentialsException("User not exist");

        }

        if(password.length() != 32){

            password = MD5Util.encode2hex(password);

        }

        if (!password.equals(userAccount.getPassword())) {

            throw new BadCredentialsException("username or password is wrong");

        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, this.listUserGrantedAuthorities(userAccount.getUserType(), userAccount.getAccountStatus()));
        token.setDetails(authentication.getDetails());
        return token;

    }

    @Override
    public boolean supports(Class<?> aClass) {

        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass));

    }

    private Set<GrantedAuthority> listUserGrantedAuthorities(String type, String status) {

        Set<GrantedAuthority> authorities = new HashSet<>();
        if(status.equals("启用")){

            switch (type){

                case "本公司员工账户":
                    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    break;
                case "其他账户":
                    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                    break;
                default:
                    break;

            }

        }
        return authorities;

    }

}
