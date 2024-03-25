package com.duan.user.center.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duan.user.center.model.dto.QuerySysMenuDto;
import com.duan.user.center.model.dto.SysMenuDto;
import com.duan.user.center.model.po.SysMenuPo;
import com.duan.user.center.model.vo.reponse.SysMenuResponseVo;

import java.util.List;


/**
 * 【菜单权限表】Service
 * @author duanmx
 */
public interface ISysMenuService extends IService<SysMenuPo> {

    /**
    * 分页查询
    * @param querySysMenuDto 实体条件
    * @param page 分页条件
    * @return 分页数据
    */
    IPage<SysMenuResponseVo> list(QuerySysMenuDto querySysMenuDto, IPage<SysMenuResponseVo> page);

    /**
    * 查询详情
    * @param id id
    * @return SysMenuResponseVo
    */
    SysMenuResponseVo queryInfo(String id);

    /**
    * 新增
    * @param sysMenuDto 实体数据
    * @return 是否成功
    */
    boolean add(SysMenuDto sysMenuDto);

    /**
     * 编辑
     * @param sysMenuDto 实体数据
     * @return 是否成功
     */
    boolean update(SysMenuDto sysMenuDto);

    /**
     * 删除
     * @param sysMenuDto 实体数据
     * @return 是否成功
     */
    boolean del(SysMenuDto sysMenuDto);

    /**
 * 导入数据
 * @param dataList dataList
 */
    void importData(List<SysMenuResponseVo> dataList);

    /**
     * 导出数据
     * @return List<SysMenuResponseVo>
     */
    List<SysMenuResponseVo> exportData(QuerySysMenuDto querySysMenuDto);

}
