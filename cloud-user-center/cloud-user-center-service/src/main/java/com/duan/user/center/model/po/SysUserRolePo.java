package com.duan.user.center.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.duan.mybatis.plus.mysql.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 *[用户和角色关联表]实体
 *system
 *2023-12-06 10:04:48
*/
@Data
@TableName("sys_user_role")
@EqualsAndHashCode
public class SysUserRolePo extends BaseDO {

    private String id;

    /** 用户ID **/
    private String userId;

    /** 角色ID **/
    private String roleId;


}
