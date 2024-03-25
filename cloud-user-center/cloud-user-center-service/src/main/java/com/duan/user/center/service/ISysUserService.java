package com.duan.user.center.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duan.user.center.model.dto.QuerySysUserDto;
import com.duan.user.center.model.dto.SysUserDto;
import com.duan.user.center.model.po.SysUserPo;
import com.duan.user.center.model.vo.reponse.SysUserResponseVo;

import java.util.List;


/**
 * 【用户信息表】Service
 * @author duanmx
 */
public interface ISysUserService extends IService<SysUserPo> {

    /**
    * 分页查询
    * @param querySysUserDto 实体条件
    * @param page 分页条件
    * @return 分页数据
    */
    IPage<SysUserResponseVo> list(QuerySysUserDto querySysUserDto, IPage<SysUserResponseVo> page);

    /**
    * 查询详情
    * @param id id
    * @return SysUserResponseVo
    */
    SysUserResponseVo queryInfo(String id);

    /**
    * 新增
    * @param sysUserDto 实体数据
    * @return 是否成功
    */
    boolean add(SysUserDto sysUserDto);

    /**
     * 编辑
     * @param sysUserDto 实体数据
     * @return 是否成功
     */
    boolean update(SysUserDto sysUserDto);

    /**
     * 删除
     * @param sysUserDto 实体数据
     * @return 是否成功
     */
    boolean del(SysUserDto sysUserDto);

    /**
 * 导入数据
 * @param dataList dataList
 */
    void importData(List<SysUserResponseVo> dataList);

    /**
     * 导出数据
     * @return List<SysUserResponseVo>
     */
    List<SysUserResponseVo> exportData(QuerySysUserDto querySysUserDto);

}
