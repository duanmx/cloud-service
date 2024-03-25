package com.duan.mybatis.plus.mysql.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 基本信息
 * </p>
 *
 * @author duanmx
 * @since 2023/10/8
 */
public class BaseDO implements Serializable {

    private static final long serialVersionUID = -1319089850037580017L;

    /**
     * 删除标志(0:有效 1：无效) 默认为：0
     */
    @TableLogic
    @TableField(value = "del_flag")
    private Integer delFlag;


    @TableField(value = "create_by_name")
    private String createByName;

    @TableField(value = "createBy")
    private String createBy;

    @TableField("created_time")
    private Date createdTime;

    @TableField(value = "update_by")
    private String updateBy;

    @TableField(value = "update_by_name")
    private String updateByName;

    @TableField(value = "updated_time")
    private Date updatedTime;


    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
