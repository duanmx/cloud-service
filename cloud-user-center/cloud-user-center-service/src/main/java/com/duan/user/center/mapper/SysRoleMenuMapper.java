package com.duan.user.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.duan.user.center.model.dto.QuerySysRoleMenuDto;
import com.duan.user.center.model.po.SysRoleMenuPo;
import com.duan.user.center.model.vo.reponse.SysRoleMenuResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;


@Mapper
@Repository
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuPo> {

    /**
    * 分页+自定义条件
    * @param page 分页条件
    * @param querySysRoleMenuDto 实体查询条件
    * @return 分页数据
    */
    IPage<SysRoleMenuResponseVo> selectPageList(
            IPage<SysRoleMenuResponseVo> page,
            @Param(value = "req") QuerySysRoleMenuDto querySysRoleMenuDto);
}
