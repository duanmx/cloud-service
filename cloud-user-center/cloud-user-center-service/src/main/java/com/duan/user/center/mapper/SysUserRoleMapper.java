package com.duan.user.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.duan.user.center.model.dto.QuerySysUserRoleDto;
import com.duan.user.center.model.po.SysUserRolePo;
import com.duan.user.center.model.vo.reponse.SysUserRoleResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;



@Mapper
@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRolePo> {

    /**
    * 分页+自定义条件
    * @param page 分页条件
    * @param querySysUserRoleDto 实体查询条件
    * @return 分页数据
    */
    IPage<SysUserRoleResponseVo> selectPageList(
            IPage<SysUserRoleResponseVo> page,
            @Param(value = "req") QuerySysUserRoleDto querySysUserRoleDto);
}
