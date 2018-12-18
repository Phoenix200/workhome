package com.czxy.jmyp.config.zuul;

import com.czxy.jmyp.auth.util.JwtUtils;
import com.czxy.jmyp.config.FilterProperties;
import com.czxy.jmyp.config.JwtProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.protocol.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginFiter
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/17 8:56
 * @Version 1.0
 **/
@Component
@EnableConfigurationProperties({JwtProperties.class,FilterProperties.class})
public class LoginFiter extends ZuulFilter {

    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private FilterProperties filterProperties;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 5;
    }

    @Override
    public boolean shouldFilter() {
        //获取请求路径
        //获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request = ctx.getRequest();
        //获取请求路径
        String requestURI = request.getRequestURI();
        //判断白名单
        for(String path:filterProperties.getAllowPaths()){
            String[] pathArr=requestURI.split("/");
            if(path.equals("/"+pathArr[3])){
                return false;
            }
        }
        return true;
    }

    @Override  public Object run() throws ZuulException {
       //获得token
        RequestContext ctx=RequestContext.getCurrentContext();
        // 获取request
        HttpServletRequest request = ctx.getRequest();
        // 获取token
        String token = request.getHeader("Authorization");
        // 校验
        try {
            // 校验通过什么都不做，即放行
            JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
        } catch (Exception e) {
            // 校验出现异常，返回403
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(403);
            e.printStackTrace();
        }
        return null;
    }
}

