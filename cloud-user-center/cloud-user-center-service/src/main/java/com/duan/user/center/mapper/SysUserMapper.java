package com.duan.user.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.duan.user.center.model.dto.QuerySysUserDto;
import com.duan.user.center.model.po.SysUserPo;
import com.duan.user.center.model.vo.reponse.SysUserResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;



@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUserPo> {

    /**
    * 分页+自定义条件
    * @param page 分页条件
    * @param querySysUserDto 实体查询条件
    * @return 分页数据
    */
    IPage<SysUserResponseVo> selectPageList(
            IPage<SysUserResponseVo> page,
            @Param(value = "req") QuerySysUserDto querySysUserDto);
}
