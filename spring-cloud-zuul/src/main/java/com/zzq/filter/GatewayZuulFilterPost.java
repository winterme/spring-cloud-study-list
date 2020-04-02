package com.zzq.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * 网关认证过滤器（Demo演示，实际根据自身业务考虑实现）
 *
 * @author Levin
 * @date 2017-08-14.
 */
@Component
public class GatewayZuulFilterPost extends ZuulFilter {

    /**
     * per：路由之前，如实现认证、记录调试信息等
     * routing：路由时
     * post：路由后，比如添加HTTP Header
     * error：发生错误时调用
     */
    @Override
    public String filterType() {
        return "post";
    }

    /**
     * 过滤器顺序，类似@Filter中的order
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();
        /*HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");
        if(token == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(404);
            ctx.setResponseBody("token cannot be empty");
        }*/

        /*int status = response.getStatus();
        if (status == 404) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(404);
            ctx.setResponseBody("{\"code\": 404}");
        }*/

        return null;
    }
}