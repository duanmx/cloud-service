package com.duan.user.center.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duan.user.center.mapper.SysUserMapper;
import com.duan.user.center.model.dto.QuerySysUserDto;
import com.duan.user.center.model.dto.SysUserDto;
import com.duan.user.center.model.po.SysUserPo;
import com.duan.user.center.model.vo.reponse.SysUserResponseVo;
import com.duan.user.center.service.ISysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 用户
 * @author duanmx
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserPo> implements ISysUserService {

    @Override
    public IPage<SysUserResponseVo> list(QuerySysUserDto querySysUserDto, IPage<SysUserResponseVo> page) {
        return baseMapper.selectPageList(page, querySysUserDto);
    }

    @Override
    public SysUserResponseVo queryInfo(String id) {
            SysUserPo sysUserPo = baseMapper.selectById(id);
            SysUserResponseVo sysUserVo = new SysUserResponseVo();
        BeanUtils.copyProperties(sysUserPo, sysUserVo);
        return sysUserVo;
    }

    @Override
    public boolean add(SysUserDto sysUserDto){
        SysUserPo sysUserPo = new SysUserPo();
        BeanUtils.copyProperties(sysUserDto,sysUserPo);
        sysUserPo.setId(null);
        return this.save(sysUserPo);
    }

    @Override
    public boolean update(SysUserDto  sysUserDto) {
        SysUserPo sysUserPo = new SysUserPo();
        BeanUtils.copyProperties(sysUserDto,sysUserPo);
        return this.updateById(sysUserPo);
    }

    @Override
    public boolean del(SysUserDto sysUserDto){
        return this.removeById(sysUserDto.getId());
    }
    @Override
    public void importData(List<SysUserResponseVo> dataList) {
        // 将导入的数据转换并保存到数据库
        List<SysUserPo> entities = new ArrayList<>();
        for (SysUserResponseVo sysUserVo : dataList) {
            SysUserPo sysUserPo = new SysUserPo();
            BeanUtils.copyProperties(sysUserVo, sysUserPo);
            entities.add(sysUserPo);
        }
        this.saveBatch(entities);
    }

    @Override
    public List<SysUserResponseVo> exportData(QuerySysUserDto querySysUserDto) {
        // 从数据库检索数据并转换为Excel数据
        IPage<SysUserResponseVo> page = new Page<>(1, -1);
        baseMapper.selectPageList(page, querySysUserDto);
        return page.getRecords();
    }

}
