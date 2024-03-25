package com.duan.user.center.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.duan.commmon.core.Results;
import com.duan.commmon.core.constants.CommonConstants;
import com.duan.user.center.model.dto.QuerySysDeptDto;
import com.duan.user.center.model.dto.SysDeptDto;
import com.duan.user.center.model.vo.reponse.SysDeptResponseVo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duan.user.center.service.ISysDeptService;
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
 * 【部门表】Controller
 * @since 2023-12-06 10:04:48
 * @author duanmx
 */
@Slf4j
@RestController
@RequestMapping("/sysDept")
@Api(tags = "【部门表】")
public class SysDeptController {

    @Resource
    private ISysDeptService sysDeptService;

    @ApiOperation(value = "分页查询【部门表】")
    @GetMapping("/list")
    public Results<IPage<SysDeptResponseVo>> list(QuerySysDeptDto querySysDeptDto,
                                                  @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        IPage<SysDeptResponseVo> page = new Page<>(pageNo, pageSize);
        return Results.success(sysDeptService.list(querySysDeptDto, page));
    }

    @ApiOperation(value = "详情【部门表】")
    @GetMapping("/info/{id}")
    public Results<SysDeptResponseVo> queryInfo(@PathVariable(value = "id", required = true) String id) {
            SysDeptResponseVo vo = sysDeptService.queryInfo(id);
        return Results.success(vo);
    }

    @ApiOperation(value = "新增【部门表】")
    @PostMapping("/add")
    public Results<Void> add(@RequestBody SysDeptDto sysDeptDto) {
        boolean flag = sysDeptService.add(sysDeptDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"新增失败");
    }

    @ApiOperation(value = "编辑【部门表】")
    @PutMapping("/update")
    public Results<Void> update(@RequestBody SysDeptDto sysDeptDto) {
        boolean flag = sysDeptService.update(sysDeptDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"编辑失败");
    }

    @ApiOperation(value = "删除【部门表】")
    @DeleteMapping("/del")
    public Results<Void> del(SysDeptDto sysDeptDto) {
        boolean flag = sysDeptService.del(sysDeptDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"删除失败");
    }

    @ApiOperation(value = "导入【部门表】")
    @PostMapping("/import")
    public Results<Void> importData(@RequestParam("file") MultipartFile file) throws IOException {
        List<SysDeptResponseVo> dataList = EasyExcel.read(file.getInputStream()).head(SysDeptResponseVo.class).sheet().doReadSync();
        sysDeptService.importData(dataList);
        return Results.success();
    }

    @ApiOperation(value = "导入模板【部门表】")
    @PostMapping("/importTemplate")
    public void importTemplate( HttpServletResponse response) throws IOException {
        writeSheet(response, new ArrayList<>());
    }

    @ApiOperation(value = "导出【部门表】")
    @PostMapping("/export")
    public void exportData( @RequestBody QuerySysDeptDto querySysDeptDto, HttpServletResponse response) throws IOException {
        List<SysDeptResponseVo> dataList = sysDeptService.exportData( querySysDeptDto);
        writeSheet(response, dataList);
    }

    private void writeSheet(HttpServletResponse response, List<SysDeptResponseVo> dataList) throws IOException {
        // 设置响应头，指定文件名和类型
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8" );
        response.setHeader("Content-Disposition", "attachment; filename=Data.xlsx" );
        ServletOutputStream outputStream = response.getOutputStream();
        // 将数据写入Excel文件，并将Excel文件的输出流写入响应
        try {
            ExcelWriter excelWriter = EasyExcel.write(outputStream, SysDeptResponseVo.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            excelWriter.write(dataList, writeSheet);
            excelWriter.finish();
        } finally {
            outputStream.close();
        }
    }

}
