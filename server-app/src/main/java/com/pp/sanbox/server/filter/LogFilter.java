package com.pp.sanbox.server.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1)
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("======== : filter in");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("======== : filter out");
    }

    @Override
    public void destroy() {

    }
}
