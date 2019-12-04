package com.sunjy.secret.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class Order {
    private long id;
    @Getter @Setter
    private User user;
    @Getter @Setter
    private Menu menu;
    private Admin admin;
    @Getter @Setter
    private Date date;
    private int state;
    @Getter @Setter
    private String remarks;
}
