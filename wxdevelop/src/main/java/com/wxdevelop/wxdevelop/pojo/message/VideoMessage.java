package com.wxdevelop.wxdevelop.pojo.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wxdevelop.wxdevelop.pojo.message.BaseMessage;
import lombok.Data;

import java.util.Map;

/**
 * @Author:XieYuanYang
 * @Description: 视频消息处理
 * @Date: Created in 17:20 2019/2/18 0018
 */
@Data
@XStreamAlias("xml")
public class VideoMessage extends BaseMessage {

    @XStreamAlias("MediaId")
    private String mediaId;
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;

    public VideoMessage(Map<String,String> requestMap , String mediaId , String title , String description){
        super(requestMap);
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
    }

}
