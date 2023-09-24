package com.zhuzi.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(-1) // 设置执行顺序，-1为最先执行
@Component
public class AuthorizeFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        // 2. 获取响应对象
        ServerHttpResponse response = exchange.getResponse();
        // 3. 获取所有的请求参数，封装成键和值
        MultiValueMap<String, String> params = request.getQueryParams();
        // 4. 获取第一个匹配的值
        String auth = params.getFirst("authorization");
        // 5. 如果等于admin，则放行
        if ("admin".equals(auth)) {
            // 方法的返回值表示消息处理完毕
            return chain.filter(exchange);
        }
        // 6. 否则设置状态码为未登录
        response.setStatusCode(HttpStatus.UNAUTHORIZED); // 401错误
        // 返回消息处理完毕
        return response.setComplete();
    }

}
