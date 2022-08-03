package com.example.springboot.config;

import com.alibaba.fastjson.JSONObject;

/**
 * @Auther: llm
 * @Date: 2021/9/6 10:18
 * @Description: 统一返回接口
 * @Modified By:
 */
public class ResponseInfo {
    public  JSONObject  setSuccess(Object  object){
        JSONObject jsonObject  = new JSONObject();
        jsonObject.put("code", 200 );
        jsonObject.put("msg", "访问成功" );
        jsonObject.put("data", object) ;
        return jsonObject ;
    }

    public  JSONObject  setFail(Object  object){
        JSONObject jsonObject  = new JSONObject();
        jsonObject.put("code", 500 );
        jsonObject.put("msg", "无数据" );
        jsonObject.put("data", object) ;
        return jsonObject ;
    }

}
