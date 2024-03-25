package com.duan.user.center.api.fegin;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author duanmx
 */
@FeignClient(name = "cloud-user-center-service", path = "/admin")
public interface TestFeign {
    @GetMapping("/cs")
    String loginNoCode();
}
