package com.example.springboot.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program:
 * @description: 自动填充添加、修改时间
 * @author: ID-Tang
 * @create: 2021-12-15 10:57
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时的填充策略
     *
     * @param metaObject Clinton Begin
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject
        this.setFieldValByName("applytime", new Date(), metaObject);
        this.setFieldValByName("updatetime", new Date(), metaObject);
    }

    /**
     * 更新时的填充策略
     *
     * @param metaObject Clinton Begin
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatetime", new Date(), metaObject);
    }
}
