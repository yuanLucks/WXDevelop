package com.wxdevelop.wxdevelop.pojo.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wxdevelop.wxdevelop.pojo.message.BaseMessage;
import lombok.Data;

import java.util.Map;

/**
 * @Author:XieYuanYang
 * @Description:  处理图片消息
 * @Date: Created in 17:13 2019/2/18 0018
 */
@Data
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage {

    @XStreamAlias("MediaId")
    private String mediaId;

    public ImageMessage(Map<String ,String> requestMap,String mediaId){
        super(requestMap);
        this.setMsgType("image");
        this.mediaId = mediaId;
    }


}
