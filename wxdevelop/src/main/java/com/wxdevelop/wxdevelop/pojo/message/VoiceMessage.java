package com.wxdevelop.wxdevelop.pojo.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wxdevelop.wxdevelop.pojo.message.BaseMessage;
import lombok.Data;

import java.util.Map;

/**
 * @Author:XieYuanYang
 * @Description: 语音处理消息
 * @Date: Created in 17:16 2019/2/18 0018
 */
@Data
@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage {

    @XStreamAlias("MediaId")
    private String mediaId;

    public VoiceMessage(Map<String,String> requestMap,String mediaId){
        super(requestMap);
        this.setMsgType("voice");
        this.mediaId = mediaId;
    }
}
