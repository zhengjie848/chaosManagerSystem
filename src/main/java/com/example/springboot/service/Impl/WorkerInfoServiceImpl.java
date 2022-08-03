package com.example.springboot.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.config.ResponseInfo;
import com.example.springboot.entity.WorkerInfo;
import com.example.springboot.mapper.WorkerInfoMapper;
import com.example.springboot.service.WorkerInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("WorkerInfoService")
public class WorkerInfoServiceImpl extends ServiceImpl<WorkerInfoMapper,WorkerInfo> implements WorkerInfoService{

    @Autowired
    WorkerInfoMapper workerInfoMapper;

    @Override
    public JSONObject findAll( String wname, String telno, String applytime) {
        List<WorkerInfo> fingAll = workerInfoMapper.findAll(wname,telno,applytime);
        if(findAll(wname,telno,applytime).size()>0){
            return new ResponseInfo().setSuccess(fingAll);
        }else{
            return new ResponseInfo().setFail(fingAll);
        }
    }

    @Override
    public JSONObject findAllPage(Integer pagenum, Integer pagesize, String wname, String telno, String applytime) {
        PageHelper.startPage(pagenum,pagesize);
        List<WorkerInfo> workerInfoList = workerInfoMapper.findAll(wname,telno,applytime);
        PageInfo<WorkerInfo> pageInfo = new PageInfo<>(workerInfoList);
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("info",pageInfo.getList());
        map.put("total",total);
        if (pageInfo.getList().size()!=0){
            return new ResponseInfo().setSuccess(map);
        }else{
            return new ResponseInfo().setFail(map);
        }
    }

    @Override
    public JSONObject countWorkerInfo() {
        int total = workerInfoMapper.countWorkerInfo();
        if (total!=0){
            return new ResponseInfo().setSuccess(total);
        }else{
            return new ResponseInfo().setFail(total);
        }
    }

    @Override
    public JSONObject deleteByPrimaryKey(Integer id) {
        int deleteByPrimaryKey = workerInfoMapper.deleteByPrimaryKey(id);
        if (deleteByPrimaryKey!=0){
            return new ResponseInfo().setSuccess(deleteByPrimaryKey);
        }else{
            return new ResponseInfo().setFail(deleteByPrimaryKey);
        }
    }

    @Override
    public JSONObject insert(WorkerInfo record) {
        int workerInfo = workerInfoMapper.insert(record);
        if (workerInfo!=0){
            return new ResponseInfo().setSuccess(workerInfo);
        }else{
            return new ResponseInfo().setFail(workerInfo);
        }
    }

    @Override
    public JSONObject insertSelective(WorkerInfo record) {
        int workerInfo = workerInfoMapper.insertSelective(record);
        if (workerInfo!=0){
            return new ResponseInfo().setSuccess(workerInfo);
        }else{
            return new ResponseInfo().setFail(workerInfo);
        }
    }

    @Override
    public JSONObject selectByPrimaryKey(Integer id) {
        WorkerInfo selectByPrimaryKey = workerInfoMapper.selectByPrimaryKey(id);
        if (selectByPrimaryKey!=null){
            return new ResponseInfo().setSuccess(selectByPrimaryKey);
        }else{
            return new ResponseInfo().setFail(selectByPrimaryKey);
        }
    }

    @Override
    public JSONObject updateByPrimaryKeySelective(WorkerInfo record) {
        int updateByPrimaryKeySelective = workerInfoMapper.updateByPrimaryKeySelective(record);
        if (updateByPrimaryKeySelective!=0){
            return new ResponseInfo().setSuccess(updateByPrimaryKeySelective);
        }else{
            return new ResponseInfo().setFail(updateByPrimaryKeySelective);
        }
    }

    @Override
    public JSONObject updateByPrimaryKey(WorkerInfo record) {
        int updateByPrimaryKey = workerInfoMapper.updateByPrimaryKey(record);
        if (updateByPrimaryKey!=0){
            return new ResponseInfo().setSuccess(updateByPrimaryKey);
        }else{
            return new ResponseInfo().setFail(updateByPrimaryKey);
        }
    }

    @Override
    public JSONObject saveWorkInfo(WorkerInfo workerInfo){
        return new ResponseInfo().setSuccess(saveOrUpdate(workerInfo));
    }

    @Override
    public JSONObject removeWorkInfo(Integer id){
        return new ResponseInfo().setSuccess(removeById(id));
    }

    @Override
    public Map<String,Object> findpage(Integer pagenum, Integer pagesize,String wname,String telno,String applytime) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("wname", wname);
        queryWrapper.like("telno",telno);
        queryWrapper.like("applytime",applytime);
        Page<WorkerInfo> iPage = new Page<WorkerInfo>(pagenum, pagesize);
        IPage<WorkerInfo> workerInfoIPage = workerInfoMapper.selectPage(iPage, queryWrapper);
        long total = workerInfoIPage.getTotal();
        List<WorkerInfo> list = workerInfoIPage.getRecords();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("workerInfoList",list);
        return map;
    }

    @Override
    public IPage<WorkerInfo> ipage(IPage<WorkerInfo> infoIPage, QueryWrapper queryWrapper) {
        return workerInfoMapper.selectPage(infoIPage, queryWrapper);
    }
}
