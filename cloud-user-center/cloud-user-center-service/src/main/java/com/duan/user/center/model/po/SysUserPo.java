package com.duan.user.center.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.duan.mybatis.plus.mysql.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 *【用户信息表】实体
 *system
 *2023-12-06 10:04:48
*/
@Data
@TableName("sys_user")
@EqualsAndHashCode
public class SysUserPo extends BaseDO {

    /** 用户ID **/
    private String id;

    /** 部门ID **/
    private String deptId;

    /** 用户账号 **/
    private String userName;

    /** 用户昵称 **/
    private String nickName;

    /** 用户类型（0:系统用户） **/
    private String userType;

    /** 用户邮箱 **/
    private String email;

    /** 手机号码 **/
    private String phoneNumber;

    /** 用户性别（0男 1女 2未知） **/
    private String sex;

    /** 头像地址 **/
    private String avatar;

    /** 密码 **/
    private String password;

    /** 帐号状态（0正常 1停用） **/
    private String status;

    /** 最后登录IP **/
    private String loginIp;

    /** 最后登录时间 **/
    private Date loginDate;

    /** 盐值 **/
    private String salt;

    /** 备注 **/
    private String remark;



}
