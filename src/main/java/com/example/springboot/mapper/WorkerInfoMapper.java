package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.WorkerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkerInfoMapper extends BaseMapper<WorkerInfo>{

    List<WorkerInfo> findAll(String wname,String telno,String applytime);

    int countWorkerInfo();

    int deleteByPrimaryKey(Integer id);

    int insert(WorkerInfo record);

    int insertSelective(WorkerInfo record);

    WorkerInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkerInfo record);

    int updateByPrimaryKey(WorkerInfo record);
}