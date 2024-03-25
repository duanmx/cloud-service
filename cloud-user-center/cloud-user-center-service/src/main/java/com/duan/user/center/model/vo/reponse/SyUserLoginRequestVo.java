package com.duan.user.center.model.vo.reponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求参数
 * @author duanmx
 */
@Data
@ApiModel
public class SyUserLoginRequestVo implements Serializable {


    @ApiModelProperty(value = "用户登录账号")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String password;


}
