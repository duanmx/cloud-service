package com.duan.getway.filter;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.duan.commmon.core.Results;
import com.duan.commmon.core.constants.CommonConstants;
import com.duan.common.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;


/**
 * <p>
 * 网关统一的token验证
 * <p>
 * @author duanmx
 */
@Component
@Slf4j
public class TokenFilter implements GlobalFilter, Ordered {

    @Autowired
    private FilterUrl filterUrl;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        //1.获取请求路径---
        String path = request.getPath().toString();
        path = replacePrefix(path);
        //判断该路径是否放行路径
        if(filterUrl.filter(path)){
            return chain.filter(exchange);
        }
        //获取请求头
        String token = request.getHeaders().getFirst("Authorization");
        if (!StrUtil.isEmpty(token)){
            return chain.filter(exchange);
        } else {

            String result = JSON.toJSONString(Results.error(CommonConstants.RESULT_TOKEN_ERROR));
            byte[] bytes = result.
                    getBytes(StandardCharsets.UTF_8);
            response.getHeaders().add(HttpHeaders.CONTENT_TYPE,"application/json;charset=UTF-8");
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            return response.writeWith(Mono.just(buffer));
        }

    }

    /**
     * 移除模块前缀
     **/
    private String replacePrefix(String path) {
        return path.substring(path.indexOf("/", 1));
    }



    @Override
    public int getOrder() {
        return 0;
    }
}
