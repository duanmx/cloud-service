package com.duan.user.center.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 *【角色和菜单关联表】列表查询dto
 * 2023-12-06 10:04:48
*/
@Data
@ApiModel(value = "【角色和菜单关联表】列表查询dto")
public class QuerySysRoleMenuDto {

    @ApiModelProperty(value = "id参数")
    private List<String> queryIds;

}
