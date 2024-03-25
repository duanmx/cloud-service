package com.duan.user.center.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.duan.commmon.core.Results;
import com.duan.commmon.core.constants.CommonConstants;
import com.duan.user.center.model.dto.QuerySysRoleDto;
import com.duan.user.center.model.dto.SysRoleDto;
import com.duan.user.center.model.vo.reponse.SysRoleResponseVo;
import com.duan.user.center.service.ISysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


/**
 *【角色信息表】Controller
 * @since 2023-12-06 10:04:48
 * @author duanmx
 */
@Slf4j
@RestController
@RequestMapping("/sysRole")
@Api(tags = "【角色信息表】")
public class SysRoleController {
    @Resource
    private ISysRoleService sysRoleService;

    @ApiOperation(value = "分页查询【角色信息表】")
    @GetMapping("/list")
    public Results<IPage<SysRoleResponseVo>> list(QuerySysRoleDto querySysRoleDto,
                                                  @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        IPage<SysRoleResponseVo> page = new Page<>(pageNo, pageSize);
        return Results.success(sysRoleService.list(querySysRoleDto, page));
    }

    @ApiOperation(value = "详情【角色信息表】")
    @GetMapping("/info/{id}")
    public Results<SysRoleResponseVo> queryInfo(@PathVariable(value = "id", required = true) String id) {
            SysRoleResponseVo vo = sysRoleService.queryInfo(id);
        return Results.success(vo);
    }

    @ApiOperation(value = "新增【角色信息表】")
    @PostMapping("/add")
    public Results<Void> add(@RequestBody SysRoleDto sysRoleDto) {
        boolean flag = sysRoleService.add(sysRoleDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"新增失败");
    }

    @ApiOperation(value = "编辑【角色信息表】")
    @PutMapping("/update")
    public Results<Void> update(@RequestBody SysRoleDto sysRoleDto) {
        boolean flag = sysRoleService.update(sysRoleDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"编辑失败");
    }

    @ApiOperation(value = "删除【角色信息表】")
    @DeleteMapping("/del")
    public Results<Void> del(SysRoleDto sysRoleDto) {
        boolean flag = sysRoleService.del(sysRoleDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"删除失败");
    }

    @ApiOperation(value = "导入【角色信息表】")
    @PostMapping("/import")
    public Results<Void> importData(@RequestParam("file") MultipartFile file) throws IOException {
        List<SysRoleResponseVo> dataList = EasyExcel.read(file.getInputStream()).head(SysRoleResponseVo.class).sheet().doReadSync();
        sysRoleService.importData(dataList);
        return Results.success();
    }

    @ApiOperation(value = "导入模板【角色信息表】")
    @PostMapping("/importTemplate")
    public void importTemplate( HttpServletResponse response) throws IOException {
        writeSheet(response, new ArrayList<>());
    }

    @ApiOperation(value = "导出【角色信息表】")
    @PostMapping("/export")
    public void exportData( @RequestBody QuerySysRoleDto querySysRoleDto, HttpServletResponse response) throws IOException {
        List<SysRoleResponseVo> dataList = sysRoleService.exportData( querySysRoleDto);
        writeSheet(response, dataList);
    }

    private void writeSheet(HttpServletResponse response, List<SysRoleResponseVo> dataList) throws IOException {
        // 设置响应头，指定文件名和类型
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8" );
        response.setHeader("Content-Disposition", "attachment; filename=Data.xlsx" );
        ServletOutputStream outputStream = response.getOutputStream();
        // 将数据写入Excel文件，并将Excel文件的输出流写入响应
        try {
            ExcelWriter excelWriter = EasyExcel.write(outputStream, SysRoleResponseVo.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            excelWriter.write(dataList, writeSheet);
            excelWriter.finish();
        } finally {
            outputStream.close();
        }
    }

}
