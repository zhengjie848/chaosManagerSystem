package com.example.springboot.config;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBody {
    private int code;
    private Object data;
}
