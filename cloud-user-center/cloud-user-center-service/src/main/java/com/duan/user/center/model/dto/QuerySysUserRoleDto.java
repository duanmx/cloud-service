package com.duan.user.center.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 *【用户和角色关联表】列表查询dto
 * system
 * 2023-12-06 10:04:48
*/
@Data
@ApiModel(value = "【用户和角色关联表】列表查询dto")
public class QuerySysUserRoleDto {

    @ApiModelProperty(value = "id参数")
    private List<String> queryIds;

}
