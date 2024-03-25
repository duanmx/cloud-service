package com.duan.user.center.model.vo.reponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 *【角色和菜单关联表】展示
 *2023-12-06 10:04:48
 * @author user
 */
@Data
@ApiModel
public class SysRoleMenuResponseVo {
    @ExcelIgnore
    @ApiModelProperty(value = "id")
    private String id;
    @ExcelProperty(value = "角色ID")
    @ApiModelProperty(value = "角色ID")
    private String roleId;
    @ExcelProperty(value = "菜单ID")
    @ApiModelProperty(value = "菜单ID")
    private String menuId;
    @ExcelProperty(value = "创建者")
    @ApiModelProperty(value = "创建者")
    private String createBy;
    @ExcelProperty(value = "创建者名称")
    @ApiModelProperty(value = "创建者名称")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createByName;
    @ExcelProperty(value = "创建时间")
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ExcelProperty(value = "更新者")
    @ApiModelProperty(value = "更新者")
    private String updateBy;
    @ExcelProperty(value = "更新者名称")
    @ApiModelProperty(value = "更新者名称")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateByName;
    @ExcelProperty(value = "更新时间")
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
