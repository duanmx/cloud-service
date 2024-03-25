package com.duan.user.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.duan.user.center.model.dto.QuerySysRoleDeptDto;
import com.duan.user.center.model.po.SysRoleDeptPo;
import com.duan.user.center.model.vo.request.SysRoleDeptResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;


@Mapper
@Repository
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDeptPo> {

    /**
    * 分页+自定义条件
    * @param page 分页条件
    * @param querySysRoleDeptDto 实体查询条件
    * @return 分页数据
    */
    IPage<SysRoleDeptResponseVo> selectPageList(
            IPage<SysRoleDeptResponseVo> page,
            @Param(value = "req") QuerySysRoleDeptDto querySysRoleDeptDto);
}
