package com.example.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.WorkerInfo;
import com.example.springboot.service.WorkerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(tags = "工人信息接口")
@RequestMapping("/workerinfo")
public class WorkerInfoController {

    @Autowired
    WorkerInfoService workerInfoService;

    @ApiOperation("工人信息分页")
    @GetMapping ("/page")
    public JSONObject findAllPage(@ApiParam(value="分页num", required = true) @RequestParam Integer pagenum,
                                  @ApiParam(value="分页size" , required = true) @RequestParam Integer pagesize,
                                  @ApiParam(value="姓名",required = false) @RequestParam String wname,
                                  @ApiParam(value="电话",required = false) @RequestParam String telno,
                                  @ApiParam(value="注册时间",required = false) @RequestParam String applytime){
        JSONObject workerInfoList = workerInfoService.findAllPage(pagenum,pagesize,wname,telno,applytime);
        return workerInfoList;
    }

    @ApiOperation("工人信息总数")
    @GetMapping ("/total")
    public JSONObject total(){
        JSONObject total = workerInfoService.countWorkerInfo();
        return total;
    }

    @ApiOperation("mybatis-plus分页")
    @GetMapping("/findpage")
    public Map<String,Object> findPage(@ApiParam(value="分页num" , required = true) @RequestParam Integer pagenum,
                                       @ApiParam(value="分页size" , required = true) @RequestParam Integer pagesize,
                                       @ApiParam(value="姓名",required = false) @RequestParam String wname,
                                       @ApiParam(value="电话",required = false) @RequestParam String telno,
                                       @ApiParam(value="注册时间",required = false) @RequestParam String applytime){
        return workerInfoService.findpage(pagenum,pagesize,wname,telno,applytime);
    }

    @ApiOperation("mybatis-plus分页")
    @GetMapping("/ipage")
    public IPage<WorkerInfo> ipage(@ApiParam(value="分页num" , required = true) @RequestParam Integer pagenum,
                                       @ApiParam(value="分页size" , required = true) @RequestParam Integer pagesize,
                                       @ApiParam(value="姓名",required = false) @RequestParam(defaultValue = "") String wname,
                                       @ApiParam(value="电话",required = false) @RequestParam(defaultValue = "") String telno,
                                       @ApiParam(value="注册时间",required = false) @RequestParam(defaultValue = "") String applytime){
        IPage<WorkerInfo> page = new Page<>(pagenum,pagesize);
        QueryWrapper<WorkerInfo> queryWrapper = new QueryWrapper<>();
        if (!"".equals(wname)){
            queryWrapper.like("wname",wname);
        }
        if (!"".equals(telno)){
            queryWrapper.like("telno",telno);
        }
        if (!"".equals(applytime)){
            queryWrapper.like("applytime",applytime);
        }
        queryWrapper.orderByDesc("id");
        return workerInfoService.ipage(page,queryWrapper);
    }

    @ApiOperation("修改或新增工人信息")
    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public JSONObject saveOrUpdate(@ApiParam(value="工人信息" , required = false) @RequestBody WorkerInfo workerInfo){
        JSONObject saveOrUpdate = workerInfoService.saveWorkInfo(workerInfo);
        return saveOrUpdate;
    }

    @ApiOperation("删除工人信息")
    @PostMapping("/remove")
    public JSONObject removeWorkInfoById(@ApiParam(value="id" , required = true) Integer id){
        JSONObject removeWorkInfoById = workerInfoService.removeWorkInfo(id);
        return removeWorkInfoById;
    }

}
