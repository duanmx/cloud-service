package com.duan.user.center.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.duan.commmon.core.Results;
import com.duan.commmon.core.constants.CommonConstants;
import com.duan.user.center.model.dto.QuerySysUserDto;
import com.duan.user.center.model.dto.SysUserDto;
import com.duan.user.center.model.vo.reponse.SysUserResponseVo;
import com.duan.user.center.service.ISysUserService;
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
 *【用户信息表】Controller
 * @since 2023-12-06 10:04:48
 * @author duanmx
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
@Api(tags = "【用户信息表】")
public class SysUserController {
    @Resource
    private ISysUserService sysUserService;

    @ApiOperation(value = "分页查询【用户信息表】")
    @GetMapping("/list")
    public Results<IPage<SysUserResponseVo>> list(QuerySysUserDto querySysUserDto,
                                                  @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        IPage<SysUserResponseVo> page = new Page<>(pageNo, pageSize);
        return Results.success(sysUserService.list(querySysUserDto, page));
    }

    @ApiOperation(value = "详情【用户信息表】")
    @GetMapping("/info/{id}")
    public Results<SysUserResponseVo> queryInfo(@PathVariable(value = "id", required = true) String id) {
            SysUserResponseVo vo = sysUserService.queryInfo(id);
        return Results.success(vo);
    }

    @ApiOperation(value = "新增【用户信息表】")
    @PostMapping("/add")
    public Results<Void> add(@RequestBody SysUserDto sysUserDto) {
        boolean flag = sysUserService.add(sysUserDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"新增失败");
    }

    @ApiOperation(value = "编辑【用户信息表】")
    @PutMapping("/update")
    public Results<Void> update(@RequestBody SysUserDto sysUserDto) {
        boolean flag = sysUserService.update(sysUserDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"编辑失败");
    }

    @ApiOperation(value = "删除【用户信息表】")
    @DeleteMapping("/del")
    public Results<Void> del(SysUserDto sysUserDto) {
        boolean flag = sysUserService.del(sysUserDto);
        return flag ? Results.success() : Results.error(CommonConstants.RESULT_OPERATION_FAILED,"删除失败");
    }

    @ApiOperation(value = "导入【用户信息表】")
    @PostMapping("/import")
    public Results<Void> importData(@RequestParam("file") MultipartFile file) throws IOException {
        List<SysUserResponseVo> dataList = EasyExcel.read(file.getInputStream()).head(SysUserResponseVo.class).sheet().doReadSync();
        sysUserService.importData(dataList);
        return Results.success();
    }

    @ApiOperation(value = "导入模板【用户信息表】")
    @PostMapping("/importTemplate")
    public void importTemplate( HttpServletResponse response) throws IOException {
        writeSheet(response, new ArrayList<>());
    }

    @ApiOperation(value = "导出【用户信息表】")
    @PostMapping("/export")
    public void exportData( @RequestBody QuerySysUserDto querySysUserDto, HttpServletResponse response) throws IOException {
        List<SysUserResponseVo> dataList = sysUserService.exportData( querySysUserDto);
        writeSheet(response, dataList);
    }

    private void writeSheet(HttpServletResponse response, List<SysUserResponseVo> dataList) throws IOException {
        // 设置响应头，指定文件名和类型
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8" );
        response.setHeader("Content-Disposition", "attachment; filename=Data.xlsx" );
        ServletOutputStream outputStream = response.getOutputStream();
        // 将数据写入Excel文件，并将Excel文件的输出流写入响应
        try {
            ExcelWriter excelWriter = EasyExcel.write(outputStream, SysUserResponseVo.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            excelWriter.write(dataList, writeSheet);
            excelWriter.finish();
        } finally {
            outputStream.close();
        }
    }

}
