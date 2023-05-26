package org.j2os.controller;

import org.j2os.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class PermissionMonitor implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (Objects.nonNull(request.getSession().getAttribute("user")) && request.getRequestURI().split("/")[1].equals(((User) request.getSession().getAttribute("user")).getRoleName())) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect("/index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
