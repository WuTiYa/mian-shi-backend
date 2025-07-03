package com.sun.mianshi.esdao;

import com.sun.mianshi.model.dto.question.QuestionEsDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 题目 ES 操作
 */
public interface QuestionEsDao extends ElasticsearchRepository<QuestionEsDTO, Long> {

}
