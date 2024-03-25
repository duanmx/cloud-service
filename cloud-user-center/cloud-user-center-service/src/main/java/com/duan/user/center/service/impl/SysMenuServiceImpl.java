package com.duan.user.center.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duan.user.center.mapper.SysMenuMapper;
import com.duan.user.center.model.dto.QuerySysMenuDto;
import com.duan.user.center.model.dto.SysMenuDto;
import com.duan.user.center.model.po.SysMenuPo;
import com.duan.user.center.model.vo.reponse.SysMenuResponseVo;
import com.duan.user.center.service.ISysMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单
 * @author duanmx
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuPo> implements ISysMenuService {

    @Override
    public IPage<SysMenuResponseVo> list(QuerySysMenuDto querySysMenuDto, IPage<SysMenuResponseVo> page) {
        return baseMapper.selectPageList(page, querySysMenuDto);
    }

    @Override
    public SysMenuResponseVo queryInfo(String id) {
            SysMenuPo sysMenuPo = baseMapper.selectById(id);
            SysMenuResponseVo sysMenuVo = new SysMenuResponseVo();
        BeanUtils.copyProperties(sysMenuPo, sysMenuVo);
        return sysMenuVo;
    }

    @Override
    public boolean add(SysMenuDto sysMenuDto){
        SysMenuPo sysMenuPo = new SysMenuPo();
        BeanUtils.copyProperties(sysMenuDto,sysMenuPo);
        sysMenuPo.setId(null);
        return this.save(sysMenuPo);
    }

    @Override
    public boolean update(SysMenuDto  sysMenuDto) {
        SysMenuPo sysMenuPo = new SysMenuPo();
        BeanUtils.copyProperties(sysMenuDto,sysMenuPo);
        return this.updateById(sysMenuPo);
    }

    @Override
    public boolean del(SysMenuDto sysMenuDto){
        return this.removeById(sysMenuDto.getId());
    }
    @Override
    public void importData(List<SysMenuResponseVo> dataList) {
        // 将导入的数据转换并保存到数据库
        List<SysMenuPo> entities = new ArrayList<>();
        for (SysMenuResponseVo sysMenuVo : dataList) {
            SysMenuPo sysMenuPo = new SysMenuPo();
            BeanUtils.copyProperties(sysMenuVo, sysMenuPo);
            entities.add(sysMenuPo);
        }
        this.saveBatch(entities);
    }

    @Override
    public List<SysMenuResponseVo> exportData(QuerySysMenuDto querySysMenuDto) {
        // 从数据库检索数据并转换为Excel数据
        IPage<SysMenuResponseVo> page = new Page<>(1, -1);
        baseMapper.selectPageList(page, querySysMenuDto);
        return page.getRecords();
    }

}
