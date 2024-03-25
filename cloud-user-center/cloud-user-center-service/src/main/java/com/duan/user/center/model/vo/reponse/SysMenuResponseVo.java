package com.duan.user.center.model.vo.reponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 *【菜单权限表】展示
 * 2023-12-06 10:04:48
 * @author user
 */
@Data
@ApiModel
public class SysMenuResponseVo {
    @ExcelIgnore
    @ApiModelProperty(value = "菜单ID")
    private String id;
    @ExcelProperty(value = "菜单名称")
    @ApiModelProperty(value = "菜单名称")
    private String menuName;
    @ExcelProperty(value = "父菜单ID")
    @ApiModelProperty(value = "父菜单ID")
    private String parentId;
    @ExcelProperty(value = "显示顺序")
    @ApiModelProperty(value = "显示顺序")
    private Integer orderNum;
    @ExcelProperty(value = "路由地址")
    @ApiModelProperty(value = "路由地址")
    private String path;
    @ExcelProperty(value = "路由参数")
    @ApiModelProperty(value = "路由参数")
    private String query;
    @ExcelProperty(value = "组件路径")
    @ApiModelProperty(value = "组件路径")
    private String component;
    @ExcelProperty(value = "是否为外链（0是 1否）")
    @ApiModelProperty(value = "是否为外链（0是 1否）")
    private Integer frame;
    @ExcelProperty(value = "是否缓存（0缓存 1不缓存）")
    @ApiModelProperty(value = "是否缓存（0缓存 1不缓存）")
    private Integer cache;
    @ExcelProperty(value = "菜单类型（M目录 C菜单 F按钮）")
    @ApiModelProperty(value = "菜单类型（M目录 C菜单 F按钮）")
    private String menuType;
    @ExcelProperty(value = "菜单状态（0显示 1隐藏）")
    @ApiModelProperty(value = "菜单状态（0显示 1隐藏）")
    private String visible;
    @ExcelProperty(value = "菜单状态（0正常 1停用）")
    @ApiModelProperty(value = "菜单状态（0正常 1停用）")
    private String status;
    @ExcelProperty(value = "权限标识")
    @ApiModelProperty(value = "权限标识")
    private String perms;
    @ExcelProperty(value = "菜单图标")
    @ApiModelProperty(value = "菜单图标")
    private String icon;
    @ExcelProperty(value = "删除标志（0代表存在 1代表删除）")
    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）")
    private String delFlag;
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
    @ExcelProperty(value = "备注")
    @ApiModelProperty(value = "备注")
    private String remark;

}
