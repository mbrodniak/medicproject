//package com.brodniak.medicproject.Security;
//
//import com.brodniak.medicproject.service.UserPrincipal;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//public class TokenAuthFilter extends GenericFilterBean {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        final HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//
//        //extract token from header
//        final String accessToken = httpRequest.getHeader("xsrf-token");
//        if (null != accessToken) {
//            //get and check whether token is valid ( from DB or file wherever you are storing the token)
//
//            //Populate SecurityContextHolder by fetching relevant information using token
//            final User user = new User(
//                    "username",
//                    "password",
//                    true,
//                    true,
//                    true,
//                    true,
//                    null);
//            final UsernamePasswordAuthenticationToken authentication =
//                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        }
//
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}
