package com.duan.user.center.model.vo.reponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 【用户信息表】展示
 *  2023-12-06 10:04:48
 * @author user
 */
@Data
@ApiModel
public class SysUserResponseVo {
    @ExcelIgnore
    @ApiModelProperty(value = "用户ID")
    private String id;
    @ExcelProperty(value = "部门ID")
    @ApiModelProperty(value = "部门ID")
    private String deptId;
    @ExcelProperty(value = "用户账号")
    @ApiModelProperty(value = "用户账号")
    private String userName;
    @ExcelProperty(value = "用户昵称")
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @ExcelProperty(value = "用户类型（0:系统用户）")
    @ApiModelProperty(value = "用户类型（0:系统用户）")
    private String userType;
    @ExcelProperty(value = "用户邮箱")
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    @ExcelProperty(value = "手机号码")
    @ApiModelProperty(value = "手机号码")
    private String phoneNumber;
    @ExcelProperty(value = "用户性别（0男 1女 2未知）")
    @ApiModelProperty(value = "用户性别（0男 1女 2未知）")
    private String sex;
    @ExcelProperty(value = "头像地址")
    @ApiModelProperty(value = "头像地址")
    private String avatar;
    @ExcelProperty(value = "密码")
    @ApiModelProperty(value = "密码")
    private String password;
    @ExcelProperty(value = "帐号状态（0正常 1停用）")
    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    private String status;
    @ExcelProperty(value = "最后登录IP")
    @ApiModelProperty(value = "最后登录IP")
    private String loginIp;
    @ExcelProperty(value = "最后登录时间")
    @ApiModelProperty(value = "最后登录时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginDate;
    @ExcelProperty(value = "盐值")
    @ApiModelProperty(value = "盐值")
    private String salt;
    @ExcelProperty(value = "备注")
    @ApiModelProperty(value = "备注")
    private String remark;
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
