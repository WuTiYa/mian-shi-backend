package com.sun.mianshi.model.dto.question;

import lombok.Data;

/*
* AI生成题目请求
* */
@Data
public class QuestionAIGenerateRequest {
    /*
    * 题目类型
    * */
    private String questionType;
    /*
    * 题目数量
    * */
    private int number = 10;
    private static final long serialVersionUID = 1L;
}
