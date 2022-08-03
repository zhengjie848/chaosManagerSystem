package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_workerinfo")
@ApiModel(value = "WorkerInfo",description = "工人信息实体类")
public class WorkerInfo {
    @ApiModelProperty(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "身份证号")
    private String sfzid;
    @ApiModelProperty(value = "姓名")
    private String wname;
    @ApiModelProperty(value = "性别")
    private String gender;
    @ApiModelProperty(value = "年龄")
    private Byte wage;
    @ApiModelProperty(value = "民族")
    private String nation;
    @ApiModelProperty(value = "手机号")
    private String telno;
    @ApiModelProperty(value = "注册时间")
    @TableField(value = "applytime" ,fill = FieldFill.INSERT)//该注解表示在插入数据时开启自动生成
    @DateTimeFormat(pattern="yyyy-MM-dd")//set
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")//get
    private Date applytime;
    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updatetime" ,fill = FieldFill.INSERT_UPDATE)//该注解表示在插入和修改数据时开启自动生成
    @DateTimeFormat(pattern="yyyy-MM-dd")//set
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")//get
    private Date updatetime;
    @ApiModelProperty(value = "签名地址")
    private String signurl;
    @ApiModelProperty(value = "是否可用")
    private Byte isactive;
    @ApiModelProperty(value = "城市")
    private String city;
    @ApiModelProperty(value = "区县")
    private String disc;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "是否审核")
    private Byte ispass;
}