package com.wxdevelop.wxdevelop.pojo.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wxdevelop.wxdevelop.pojo.message.BaseMessage;
import lombok.Data;

import java.util.Map;

/**
 * @Author:XieYuanYang
 * @Description: 处理文本消息
 * @Date: Created in 16:48 2019/2/18 0018
 */
@Data
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {

    @XStreamAlias("Content")
    private String content;

    public String getContent(){
        return content;
    }

    public TextMessage(Map<String , String > requestMap,String content){
        super(requestMap);
        //设置文本消息的类型
        this.setMsgType("text");
        this.content = content;
    }

}
