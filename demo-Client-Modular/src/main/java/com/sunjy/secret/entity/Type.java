package com.sunjy.secret.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Type {
    @Getter@Setter private long id;
    private String name;
}
