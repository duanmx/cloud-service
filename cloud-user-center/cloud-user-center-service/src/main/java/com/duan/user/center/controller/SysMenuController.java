package com.duan.user.center.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.duan.commmon.core.Results;
import com.duan.commmon.core.constants.CommonConstants;
import com.duan.user.center.model.dto.QuerySysMenuDto;
import com.duan.user.center.model.dto.SysMenuDto;
import com.duan.user.center.model.vo.reponse.SysMenuResponseVo;
import com.duan.user.center.service.ISysMenuService;
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
 *  【菜单权限表】Controller
 * @since 2023-12-06 10:04:48
 * @author duanmx
 */
@Slf4j
@RestController
@RequestMapping("/sysMenu")
@Api(tags = "【菜单权限表】")
public class SysMenuController {
    @Resource
    private ISysMenuService sysMenuService;

    @ApiOperation(value = "分页查询【菜单权限表】")
    @GetMapping("/list")
    public Results<IPage<SysMenuResponseVo>> list(QuerySysMenuDto querySysMenuDto,
                                                  @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        IPage<SysMenuResponseVo> page = new Page<>(pageNo, pageSize);
        return Results.success(sysMenuService.list(querySysMenuDto, page));
    }

    @ApiOperation(value = "详情【菜单权限表】")
    @GetMapping("/info/{id}")
    public Results<SysMenuResponseVo> queryInfo(@PathVariable(value = "id", required = true) String id) {
            SysMenuResponseVo vo = sysMenuService.queryInfo(id);
        return Results.success(vo);
    }

    @ApiOperation(value = "新增【菜单权限表】")
    @PostMapping("/add")
    public Results<Void> add(@RequestBody SysMenuDto sysMenuDto) {
        boolean flag = sysMenuService.add(sysMenuDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"新增失败");
    }

    @ApiOperation(value = "编辑【菜单权限表】")
    @PutMapping("/update")
    public Results<Void> update(@RequestBody SysMenuDto sysMenuDto) {
        boolean flag = sysMenuService.update(sysMenuDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"编辑失败");
    }

    @ApiOperation(value = "删除【菜单权限表】")
    @DeleteMapping("/del")
    public Results<Void> del(SysMenuDto sysMenuDto) {
        boolean flag = sysMenuService.del(sysMenuDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"删除失败");
    }

    @ApiOperation(value = "导入【菜单权限表】")
    @PostMapping("/import")
    public Results<Void> importData(@RequestParam("file") MultipartFile file) throws IOException {
        List<SysMenuResponseVo> dataList = EasyExcel.read(file.getInputStream()).head(SysMenuResponseVo.class).sheet().doReadSync();
        sysMenuService.importData(dataList);
        return Results.success();
    }

    @ApiOperation(value = "导入模板【菜单权限表】")
    @PostMapping("/importTemplate")
    public void importTemplate( HttpServletResponse response) throws IOException {
        writeSheet(response, new ArrayList<>());
    }

    @ApiOperation(value = "导出【菜单权限表】")
    @PostMapping("/export")
    public void exportData( @RequestBody QuerySysMenuDto querySysMenuDto, HttpServletResponse response) throws IOException {
        List<SysMenuResponseVo> dataList = sysMenuService.exportData( querySysMenuDto);
        writeSheet(response, dataList);
    }

    private void writeSheet(HttpServletResponse response, List<SysMenuResponseVo> dataList) throws IOException {
        // 设置响应头，指定文件名和类型
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8" );
        response.setHeader("Content-Disposition", "attachment; filename=Data.xlsx" );
        ServletOutputStream outputStream = response.getOutputStream();
        // 将数据写入Excel文件，并将Excel文件的输出流写入响应
        try {
            ExcelWriter excelWriter = EasyExcel.write(outputStream, SysMenuResponseVo.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            excelWriter.write(dataList, writeSheet);
            excelWriter.finish();
        } finally {
            outputStream.close();
        }
    }

}
