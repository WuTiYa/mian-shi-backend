package com.sun.mianshi.model.dto.questionbank;

import com.sun.mianshi.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 查询题库请求
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionBankQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * id
     */
    private Long notId;

    /**
     * 搜索词
     */
    private String searchText;

    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 图片
     */
    private String picture;
    /*
    * 是否要查询题目列表
    * */
    private boolean needQueryQuestionList;
    /**
     * 创建用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}