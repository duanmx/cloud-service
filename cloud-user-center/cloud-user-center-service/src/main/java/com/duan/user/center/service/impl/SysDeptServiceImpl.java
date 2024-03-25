package com.duan.user.center.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duan.user.center.mapper.SysDeptMapper;
import com.duan.user.center.model.dto.QuerySysDeptDto;
import com.duan.user.center.model.dto.SysDeptDto;
import com.duan.user.center.model.po.SysDeptPo;
import com.duan.user.center.model.vo.reponse.SysDeptResponseVo;
import com.duan.user.center.service.ISysDeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门
 * @author duanmx
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDeptPo> implements ISysDeptService {

    @Override
    public IPage<SysDeptResponseVo> list(QuerySysDeptDto querySysDeptDto, IPage<SysDeptResponseVo> page) {
        return baseMapper.selectPageList(page, querySysDeptDto);
    }

    @Override
    public SysDeptResponseVo queryInfo(String id) {
            SysDeptPo sysDeptPo = baseMapper.selectById(id);
            SysDeptResponseVo sysDeptVo = new SysDeptResponseVo();
        BeanUtils.copyProperties(sysDeptPo, sysDeptVo);
        return sysDeptVo;
    }

    @Override
    public boolean add(SysDeptDto sysDeptDto){
        SysDeptPo sysDeptPo = new SysDeptPo();
        BeanUtils.copyProperties(sysDeptDto,sysDeptPo);
        sysDeptPo.setId(null);
        return this.save(sysDeptPo);
    }

    @Override
    public boolean update(SysDeptDto  sysDeptDto) {
        SysDeptPo sysDeptPo = new SysDeptPo();
        BeanUtils.copyProperties(sysDeptDto,sysDeptPo);
        return this.updateById(sysDeptPo);
    }

    @Override
    public boolean del(SysDeptDto sysDeptDto){
        return this.removeById(sysDeptDto.getId());
    }
    @Override
    public void importData(List<SysDeptResponseVo> dataList) {
        // 将导入的数据转换并保存到数据库
        List<SysDeptPo> entities = new ArrayList<>();
        for (SysDeptResponseVo sysDeptVo : dataList) {
            SysDeptPo sysDeptPo = new SysDeptPo();
            BeanUtils.copyProperties(sysDeptVo, sysDeptPo);
            entities.add(sysDeptPo);
        }
        this.saveBatch(entities);
    }

    @Override
    public List<SysDeptResponseVo> exportData(QuerySysDeptDto querySysDeptDto) {
        // 从数据库检索数据并转换为Excel数据
        IPage<SysDeptResponseVo> page = new Page<>(1, -1);
        baseMapper.selectPageList(page, querySysDeptDto);
        return page.getRecords();
    }

}
