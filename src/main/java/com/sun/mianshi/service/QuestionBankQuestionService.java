package com.sun.mianshi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.mianshi.model.dto.questionbankquestion.QuestionBankQuestionQueryRequest;
import com.sun.mianshi.model.entity.QuestionBankQuestion;
import com.sun.mianshi.model.entity.User;
import com.sun.mianshi.model.vo.QuestionBankQuestionVO;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 题库题目关联服务
 *
 */
public interface QuestionBankQuestionService extends IService<QuestionBankQuestion> {

    /**
     * 校验数据
     *
     * @param questionBankQuestion
     * @param add 对创建的数据进行校验
     */
    void validQuestionBankQuestion(QuestionBankQuestion questionBankQuestion, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionBankQuestionQueryRequest
     * @return
     */
    QueryWrapper<QuestionBankQuestion> getQueryWrapper(QuestionBankQuestionQueryRequest questionBankQuestionQueryRequest);
    
    /**
     * 获取题库题目关联封装
     *
     * @param questionBankQuestion
     * @param request
     * @return
     */
    QuestionBankQuestionVO getQuestionBankQuestionVO(QuestionBankQuestion questionBankQuestion, HttpServletRequest request);

    /**
     * 分页获取题库题目关联封装
     *
     * @param questionBankQuestionPage
     * @param request
     * @return
     */
    Page<QuestionBankQuestionVO> getQuestionBankQuestionVOPage(Page<QuestionBankQuestion> questionBankQuestionPage, HttpServletRequest request);

    /*
    * 批量向题库中插入题目
    * */
    void batchAddQuestionToBank(List<Long> questionIdList, long questionBankId, User loginUser);


    /*
     * 批量从题库中移除题目
     * */
    void batchRemoveQuestionFromBank(List<Long> questionIdList, long questionBankId);

    /*
     * 批量添加题目到题库（事务，仅供内部调用使用）
     * */
    @Transactional(rollbackFor = Exception.class)
    void batchAddQuestionToBankInner(List<QuestionBankQuestion> questionBankQuestionList);
}
