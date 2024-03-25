package com.duan.user.center.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 *  【用户信息表】列表查询dto
 * system
*/
@Data
@ApiModel(value = "【用户信息表】列表查询dto")
public class QuerySysUserDto {

    @ApiModelProperty(value = "id参数")
    private List<String> queryIds;

}
