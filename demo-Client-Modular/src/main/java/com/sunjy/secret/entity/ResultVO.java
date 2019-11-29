package com.sunjy.secret.entity;

import lombok.*;


@Data
@AllArgsConstructor
//@NoArgsConstructor
public class ResultVO {
    @Getter @Setter  private int code;
    @Getter @Setter  private String msg;
    @Getter @Setter  private int count;
    @Getter @Setter  private Object data;

}
