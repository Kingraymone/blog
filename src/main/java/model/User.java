package model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User implements Serializable, Cloneable {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String imageName;
    /**
     * 座右铭
     */
    private String motto;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 状态
     */
    private String status;
}

