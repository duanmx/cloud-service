package com.duan.user.center.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;

/**
 * 【角色和部门关联表】列表查询dto
*/
@Data
@ApiModel(value = "【角色和部门关联表】列表查询dto")
public class QuerySysRoleDeptDto {

    @ApiModelProperty(value = "id参数")
    private List<String> queryIds;

}
