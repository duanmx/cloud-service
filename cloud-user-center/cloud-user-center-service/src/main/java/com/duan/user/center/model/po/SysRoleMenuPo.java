package com.duan.user.center.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.duan.mybatis.plus.mysql.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 【角色和菜单关联表】实体
 *  2023-12-06 10:04:48
*/
@Data
@TableName("sys_role_menu")
@EqualsAndHashCode
public class SysRoleMenuPo extends BaseDO {

    /** id **/
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /** 角色ID **/
    private String roleId;

    /** 菜单ID **/
    private String menuId;

}
