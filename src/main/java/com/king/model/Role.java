package com.king.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable,Cloneable {
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 角色名
     */
    private String rolename;
    /**
     * 描述
     */
    private String statement;
    /**
     * 状态
     */
    private String status;
}

