package com.duan.user.center.model.vo.reponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 【部门表】展示
 * @author user
 */
@Data
@ApiModel
public class SysDeptResponseVo {
    @ExcelIgnore
    @ApiModelProperty(value = "部门id")
    private String id;
    @ExcelProperty(value = "父部门id")
    @ApiModelProperty(value = "父部门id")
    private String parentId;
    @ExcelProperty(value = "部门编码")
    @ApiModelProperty(value = "部门编码")
    private String code;
    @ExcelProperty(value = "部门名称")
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ExcelProperty(value = "负责人")
    @ApiModelProperty(value = "负责人")
    private String leader;
    @ExcelProperty(value = "联系电话")
    @ApiModelProperty(value = "联系电话")
    private String phone;
    @ExcelProperty(value = "邮箱")
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ExcelProperty(value = "部门状态（0正常 1停用）")
    @ApiModelProperty(value = "部门状态（0正常 1停用）")
    private String status;
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

}
