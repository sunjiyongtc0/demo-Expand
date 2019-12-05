package com.sunjy.secret.entity;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {
    private Long id;
@Getter@Setter
    private String username; //用户名
    @Getter@Setter
    private String operation; //操作
    @Getter@Setter
    private String method; //方法名
    @Getter@Setter
    private String params; //参数
    @Getter@Setter
    private String ip; //ip地址
    @Getter@Setter
    private Date createDate; //操作时间

}
