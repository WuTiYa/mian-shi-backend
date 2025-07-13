package com.sun.mianshi.manager;

import cn.hutool.core.collection.CollUtil;
import com.sun.mianshi.common.ErrorCode;
import com.sun.mianshi.config.AiConfig;
import com.sun.mianshi.exception.BusinessException;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionChoice;
import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
*
* 通用的AI调用方法
* */
@Service
public class AiManager {
    @Resource
    private ArkService aiService;
    private static final String DEFAULT_MODEL = "deepseek-v3-250324";
    /*
     * 调用Ai接口，获取响应字符串
     * */
    public String doChat(String userPrompt){
        return doChat("", userPrompt, DEFAULT_MODEL);
    }

    /*
     * 调用Ai接口，获取响应字符串
     * */
    public String doChat(String systemPrompt, String userPrompt){
        return doChat(systemPrompt, userPrompt, DEFAULT_MODEL);
    }

    /*
    * 调用Ai接口，获取响应字符串
    * */
    public String doChat(String systemPrompt, String userPrompt, String model){
        //构造消息列表
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = ChatMessage.builder().role(ChatMessageRole.SYSTEM).content(systemPrompt).build();
        final ChatMessage userMessage = ChatMessage.builder().role(ChatMessageRole.USER).content(userPrompt).build();
        messages.add(systemMessage);
        messages.add(userMessage);
        //构造请求
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                // 指定您创建的方舟推理接入点 ID，此处已帮您修改为您的推理接入点 ID
                //.model("deepseek-v3-250324")
                .model(model)
                .messages(messages)
                .build();
        //调用接口，发送请求
        List<ChatCompletionChoice> choices = aiService.createChatCompletion(chatCompletionRequest).getChoices();
        if(CollUtil.isNotEmpty(choices)){
            return (String)choices.get(0).getMessage().getContent();
        }
        throw new BusinessException(ErrorCode.OPERATION_ERROR, "AI调用失败，没有返回结果");
        //aiService.shutdownExecutor();
    }
}
