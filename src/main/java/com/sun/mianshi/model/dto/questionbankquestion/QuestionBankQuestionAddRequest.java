package com.sun.mianshi.model.dto.questionbankquestion;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建题库题目关联请求
 *
 */
@Data
public class QuestionBankQuestionAddRequest implements Serializable {
    /**
     * 题库 id
     */
    private Long questionBankId;

    /**
     * 题目 id
     */
    private Long questionId;
    private static final long serialVersionUID = 1L;
}