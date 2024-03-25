package com.duan.user.center.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.duan.mybatis.plus.mysql.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 【菜单权限表】实体
*/
@Data
@TableName("sys_menu")
@EqualsAndHashCode
public class SysMenuPo extends BaseDO {

    /** 菜单ID **/
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /** 菜单名称 **/
    private String menuName;

    /** 父菜单ID **/
    private String parentId;

    /** 显示顺序 **/
    private Integer orderNum;

    /** 路由地址 **/
    private String path;

    /** 路由参数 **/
    private String query;

    /** 组件路径 **/
    private String component;

    /** 是否为外链（0是 1否） **/
    private Integer frame;

    /** 是否缓存（0缓存 1不缓存） **/
    private Integer cache;

    /** 菜单类型（M目录 C菜单 F按钮） **/
    private String menuType;

    /** 菜单状态（0显示 1隐藏） **/
    private String visible;

    /** 菜单状态（0正常 1停用） **/
    private String status;

    /** 权限标识 **/
    private String perms;

    /** 菜单图标 **/
    private String icon;

    /** 备注 **/
    private String remark;


}
