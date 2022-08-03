package com.example.springboot.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot.entity.WorkerInfo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface WorkerInfoService {

    JSONObject findAll(String wname,String telno,String applytime);

    JSONObject findAllPage(Integer pagenum, Integer pagesize,String wname,String telno,String applytime);

    JSONObject countWorkerInfo();

    JSONObject deleteByPrimaryKey(Integer id);

    JSONObject insert(WorkerInfo record);

    JSONObject insertSelective(WorkerInfo record);

    JSONObject selectByPrimaryKey(Integer id);

    JSONObject updateByPrimaryKeySelective(WorkerInfo record);

    JSONObject updateByPrimaryKey(WorkerInfo record);

    JSONObject saveWorkInfo(WorkerInfo record);

    JSONObject removeWorkInfo(Integer id);

    Map<String,Object> findpage(Integer pagenum, Integer pagesize, String wname, String telno, String applytime);

    IPage<WorkerInfo> ipage(IPage<WorkerInfo> infoIPage,QueryWrapper queryWrapper);
}
