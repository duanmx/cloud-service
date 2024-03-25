package com.duan.getway.filter;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * @author duanmx
 */
@Component
public class FilterUrl {


    private static final Map<String,String> FILTER_MAP = new HashMap<>();


    static {
        //swagger
        FILTER_MAP.put("/oauth/**", "anon");
        FILTER_MAP.put("/actuator/**", "anon");
        FILTER_MAP.put("/v3/api-docs/**", "anon");
        FILTER_MAP.put("/swagger/api-docs", "anon");
        FILTER_MAP.put("/swagger-ui.html", "anon");
        FILTER_MAP.put("/doc.html", "anon");
        FILTER_MAP.put("/swagger-resources/**", "anon");
        FILTER_MAP.put("/webjars/**", "anon");
        FILTER_MAP.put("/druid/**", "anon");
        FILTER_MAP.put("/error/**", "anon");
        FILTER_MAP.put("/assets/**", "anon");
        //配置登录不校验
        FILTER_MAP.put("/login/**", "anon");
        FILTER_MAP.put("/sysUser/**", "anon");

    }


    /**
     * 判断哪些url不需要过滤
     * @param url url
     * @return true or false
     */
    public  boolean filter(String url){
        //直接查找
        if (FILTER_MAP.get(url)!=null){
            return true;
        } else {
            for (Map.Entry<String, String> entry : FILTER_MAP.entrySet()) {
                String k = entry.getKey();
                String result = k.replace("/**", "");
                if (url.startsWith(result)) {
                    return true;
                }
            }
        }

        return false;
    }
}
