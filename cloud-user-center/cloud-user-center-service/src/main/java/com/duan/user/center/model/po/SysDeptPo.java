package com.duan.user.center.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.duan.mybatis.plus.mysql.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 【部门表】实体
*/
@Data
@TableName("sys_dept")
@EqualsAndHashCode
public class SysDeptPo extends BaseDO {

    /** 部门id **/
    private String id;

    /** 父部门id **/
    private String parentId;

    /** 部门编码 **/
    private String code;

    /** 部门名称 **/
    private String deptName;

    /** 负责人 **/
    private String leader;

    /** 联系电话 **/
    private String phone;

    /** 邮箱 **/
    private String email;

    /** 部门状态（0正常 1停用） **/
    private String status;


}
