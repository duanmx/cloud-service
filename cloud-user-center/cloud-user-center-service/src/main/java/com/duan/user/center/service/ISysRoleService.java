package com.duan.user.center.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duan.user.center.model.dto.QuerySysRoleDto;
import com.duan.user.center.model.dto.SysRoleDto;
import com.duan.user.center.model.po.SysRolePo;
import com.duan.user.center.model.vo.reponse.SysRoleResponseVo;

import java.util.List;


/**
 * 【角色信息表】Service
 * @author duanmx
 */
public interface ISysRoleService extends IService<SysRolePo> {

    /**
    * 分页查询
    * @param querySysRoleDto 实体条件
    * @param page 分页条件
    * @return 分页数据
    */
    IPage<SysRoleResponseVo> list(QuerySysRoleDto querySysRoleDto, IPage<SysRoleResponseVo> page);

    /**
    * 查询详情
    * @param id id
    * @return SysRoleResponseVo
    */
    SysRoleResponseVo queryInfo(String id);

    /**
    * 新增
    * @param sysRoleDto 实体数据
    * @return 是否成功
    */
    boolean add(SysRoleDto sysRoleDto);

    /**
     * 编辑
     * @param sysRoleDto 实体数据
     * @return 是否成功
     */
    boolean update(SysRoleDto sysRoleDto);

    /**
     * 删除
     * @param sysRoleDto 实体数据
     * @return 是否成功
     */
    boolean del(SysRoleDto sysRoleDto);

    /**
 * 导入数据
 * @param dataList dataList
 */
    void importData(List<SysRoleResponseVo> dataList);

    /**
     * 导出数据
     * @return List<SysRoleResponseVo>
     */
    List<SysRoleResponseVo> exportData(QuerySysRoleDto querySysRoleDto);

}
