package com.duan.user.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.duan.user.center.model.dto.QuerySysRoleDto;
import com.duan.user.center.model.po.SysRolePo;
import com.duan.user.center.model.vo.reponse.SysRoleResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;



@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRolePo> {

    /**
    * 分页+自定义条件
    * @param page 分页条件
    * @param querySysRoleDto 实体查询条件
    * @return 分页数据
    */
    IPage<SysRoleResponseVo> selectPageList(
            IPage<SysRoleResponseVo> page,
            @Param(value = "req") QuerySysRoleDto querySysRoleDto);
}
