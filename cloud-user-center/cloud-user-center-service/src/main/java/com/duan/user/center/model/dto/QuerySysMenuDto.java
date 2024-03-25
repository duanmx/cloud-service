package com.duan.user.center.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 【菜单权限表】列表查询dto
*/
@Data
@ApiModel(value = "【菜单权限表】列表查询dto")
public class QuerySysMenuDto {

    @ApiModelProperty(value = "id参数")
    private List<String> queryIds;

}
