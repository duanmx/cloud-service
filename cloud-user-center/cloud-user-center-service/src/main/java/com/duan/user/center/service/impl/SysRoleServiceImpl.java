package com.duan.user.center.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duan.user.center.mapper.SysRoleMapper;
import com.duan.user.center.model.dto.QuerySysRoleDto;
import com.duan.user.center.model.dto.SysRoleDto;
import com.duan.user.center.model.po.SysRolePo;
import com.duan.user.center.model.vo.reponse.SysRoleResponseVo;
import com.duan.user.center.service.ISysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 * @author duanmx
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRolePo> implements ISysRoleService {

    @Override
    public IPage<SysRoleResponseVo> list(QuerySysRoleDto querySysRoleDto, IPage<SysRoleResponseVo> page) {
        return baseMapper.selectPageList(page, querySysRoleDto);
    }

    @Override
    public SysRoleResponseVo queryInfo(String id) {
            SysRolePo sysRolePo = baseMapper.selectById(id);
            SysRoleResponseVo sysRoleVo = new SysRoleResponseVo();
        BeanUtils.copyProperties(sysRolePo, sysRoleVo);
        return sysRoleVo;
    }

    @Override
    public boolean add(SysRoleDto sysRoleDto){
        SysRolePo sysRolePo = new SysRolePo();
        BeanUtils.copyProperties(sysRoleDto,sysRolePo);
        sysRolePo.setId(null);
        return this.save(sysRolePo);
    }

    @Override
    public boolean update(SysRoleDto  sysRoleDto) {
        SysRolePo sysRolePo = new SysRolePo();
        BeanUtils.copyProperties(sysRoleDto,sysRolePo);
        return this.updateById(sysRolePo);
    }

    @Override
    public boolean del(SysRoleDto sysRoleDto){
        return this.removeById(sysRoleDto.getId());
    }
    @Override
    public void importData(List<SysRoleResponseVo> dataList) {
        // 将导入的数据转换并保存到数据库
        List<SysRolePo> entities = new ArrayList<>();
        for (SysRoleResponseVo sysRoleVo : dataList) {
            SysRolePo sysRolePo = new SysRolePo();
            BeanUtils.copyProperties(sysRoleVo, sysRolePo);
            entities.add(sysRolePo);
        }
        this.saveBatch(entities);
    }

    @Override
    public List<SysRoleResponseVo> exportData(QuerySysRoleDto querySysRoleDto) {
        // 从数据库检索数据并转换为Excel数据
        IPage<SysRoleResponseVo> page = new Page<>(1, -1);
        baseMapper.selectPageList(page, querySysRoleDto);
        return page.getRecords();
    }

}
