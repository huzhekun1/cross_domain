package com.ithzk.cross.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域请求处理过滤器
 * @author hzk
 * @date 2019/4/3
 */
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        //支持所有域
        String origin = httpServletRequest.getHeader("Origin");
        if(!StringUtils.isEmpty(origin)){
            //带cookie时，该响应头必须完全匹配，不能使用*
            httpServletResponse.addHeader("Access-Control-Allow-Origin", origin);
            //httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        }

        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");

        //支持所有自定义头
        String headers = httpServletRequest.getHeader("Access-Control-Request-Headers");
        if(!StringUtils.isEmpty(headers)){
//            httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,X-Header-1,X-Header-2");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", headers);
        }

        //设置预检命令缓存时间
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");

        //支持跨域携带cookie
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
