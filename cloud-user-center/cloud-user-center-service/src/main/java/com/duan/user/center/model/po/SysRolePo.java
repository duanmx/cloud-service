package com.duan.user.center.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.duan.mybatis.plus.mysql.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 *【角色信息表】实体
 * 2023-12-06 10:04:48
*/
@Data
@TableName("sys_role")
@EqualsAndHashCode
public class SysRolePo extends BaseDO {

    /** 角色ID **/
    private String id;

    /** 角色名称 **/
    private String roleName;

    /** 角色权限字符串 **/
    private String roleKey;

    /** 显示顺序 **/
    private Integer roleSort;

    /** 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限） **/
    private String dataScope;


}
