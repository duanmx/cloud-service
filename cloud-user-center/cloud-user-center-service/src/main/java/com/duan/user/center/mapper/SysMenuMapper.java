package com.duan.user.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.duan.user.center.model.dto.QuerySysMenuDto;
import com.duan.user.center.model.po.SysMenuPo;
import com.duan.user.center.model.vo.reponse.SysMenuResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;



@Mapper
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenuPo> {

    /**
    * 分页+自定义条件
    * @param page 分页条件
    * @param querySysMenuDto 实体查询条件
    * @return 分页数据
    */
    IPage<SysMenuResponseVo> selectPageList(
            IPage<SysMenuResponseVo> page,
            @Param(value = "req") QuerySysMenuDto querySysMenuDto);
}
