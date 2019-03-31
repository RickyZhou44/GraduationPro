package whu.iss.insurancesys.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import whu.iss.insurancesys.entity.LoginRegisterEntities.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/4/10 0010.
 */
//检查此session是否已经登陆，如果登陆了则直接进入相关页面，如果没有则要求他进行登陆操作
public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final String[]IGNORE_URI={"/userPage","/managePage"};
    /*
    * preHandle方法是进行处理器拦截用的，该方法在controller处理之前进行调用
    * 该方法的返回值为true拦截器才会继续往下执行，该方法的返回值为false的时候整个请求就结束了
    * */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean flag=false;
        String servletPath=httpServletRequest.getServletPath();
        for(String s:IGNORE_URI){
            if(servletPath.contains(s)){
                flag=true;
                break;
            }
        }
        //拦截请求
        if(!flag){
            //1获取session中的用户
            Account organization=(Account)httpServletRequest.getSession().getAttribute("user");
            //判断用户是否已经登陆
            if(organization==null){
                System.out.println("AuthorizationInterceptor 拦截请求: ");
                httpServletRequest.setAttribute("message","Please login first");
                 httpServletRequest.getRequestDispatcher("WEB-INF/pages/login.html").forward(httpServletRequest,httpServletResponse);
            }
            else {
                System.out.println("AuthorizationInterceptor放行请求：");
                flag=true;
            }
        }
        return flag;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthorizationInterceptor postHandle -->");
    }
/*
* 该方法将在整个请求之后执行，主要作用是用于清理资源*/
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("AuthorizationInterceptor afterCompletion -->");

    }
}
