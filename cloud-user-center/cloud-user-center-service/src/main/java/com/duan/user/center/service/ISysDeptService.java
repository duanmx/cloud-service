package com.duan.user.center.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duan.user.center.model.dto.QuerySysDeptDto;
import com.duan.user.center.model.dto.SysDeptDto;
import com.duan.user.center.model.po.SysDeptPo;
import com.duan.user.center.model.vo.reponse.SysDeptResponseVo;

import java.util.List;


/**
 * [部门表】Service
 * @author duanmx
 */
public interface ISysDeptService extends IService<SysDeptPo> {

    /**
    * 分页查询
    * @param querySysDeptDto 实体条件
    * @param page 分页条件
    * @return 分页数据
    */
    IPage<SysDeptResponseVo> list(QuerySysDeptDto querySysDeptDto, IPage<SysDeptResponseVo> page);

    /**
    * 查询详情
    * @param id id
    * @return SysDeptResponseVo
    */
    SysDeptResponseVo queryInfo(String id);

    /**
    * 新增
    * @param sysDeptDto 实体数据
    * @return 是否成功
    */
    boolean add(SysDeptDto sysDeptDto);

    /**
     * 编辑
     * @param sysDeptDto 实体数据
     * @return 是否成功
     */
    boolean update(SysDeptDto sysDeptDto);

    /**
     * 删除
     * @param sysDeptDto 实体数据
     * @return 是否成功
     */
    boolean del(SysDeptDto sysDeptDto);

    /**
 * 导入数据
 * @param dataList dataList
 */
    void importData(List<SysDeptResponseVo> dataList);

    /**
     * 导出数据
     * @return List<SysDeptResponseVo>
     */
    List<SysDeptResponseVo> exportData(QuerySysDeptDto querySysDeptDto);

}
