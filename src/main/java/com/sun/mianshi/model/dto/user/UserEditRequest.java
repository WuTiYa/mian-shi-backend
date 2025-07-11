package com.sun.mianshi.model.dto.user;

import lombok.Data;
/**
 * 用户编辑个人信息请求
 *
 */
@Data
public class UserEditRequest {
    /*
    * 手机号
    * */
    private String phoneNumber;
    /*
    * 邮箱
    * */
    private String email;
    /*
    * 年级
    * */
    private String grade;
    /*
    * 工作经验
    * */
    private String workExperience;
    /*
    * 擅长方向
    * */
    private String expertiseDirection;
    /*
    * 用户昵称
    * */
    private String userName;
    /*
    * 用户头像URL
    * */
    private String userAvatar;
    /*
    * 用户简介
    * */
    private String userProfile;
    private static final long serialVersionUID = 1L;
}
