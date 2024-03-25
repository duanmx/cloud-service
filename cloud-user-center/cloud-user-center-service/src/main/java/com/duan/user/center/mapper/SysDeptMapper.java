package com.duan.user.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.duan.user.center.model.dto.QuerySysDeptDto;
import com.duan.user.center.model.po.SysDeptPo;
import com.duan.user.center.model.vo.reponse.SysDeptResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;



@Mapper
@Repository
public interface SysDeptMapper extends BaseMapper<SysDeptPo> {

    /**
    * 分页+自定义条件
    * @param page 分页条件
    * @param querySysDeptDto 实体查询条件
    * @return 分页数据
    */
    IPage<SysDeptResponseVo> selectPageList(
            IPage<SysDeptResponseVo> page,
            @Param(value = "req") QuerySysDeptDto querySysDeptDto);
}
