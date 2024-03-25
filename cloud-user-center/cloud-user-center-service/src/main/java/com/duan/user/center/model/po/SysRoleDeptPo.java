package com.duan.user.center.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.duan.mybatis.plus.mysql.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 【角色和部门关联表】实体
*/
@Data
@TableName("sys_role_dept")
@EqualsAndHashCode
public class SysRoleDeptPo extends BaseDO {

    /** id **/
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /** 角色ID **/
    private Long roleId;

    /** 部门ID **/
    private Long deptId;


}
