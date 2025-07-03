package com.sun.mianshi.model.dto.questionbankquestion;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 批量从题库中移除题目关联请求
 *
 */
@Data
public class QuestionBankQuestionBatchRemoveRequest implements Serializable {
    /**
     * 题库 id
     */
    private Long questionBankId;

    /**
     * 题目 id列表
     */
    private List<Long> questionIdList;
    private static final long serialVersionUID = 1L;
}