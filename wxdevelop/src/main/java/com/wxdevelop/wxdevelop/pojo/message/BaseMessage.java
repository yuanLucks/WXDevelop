package com.wxdevelop.wxdevelop.pojo.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import sun.applet.resources.MsgAppletViewer;

import java.util.Map;

/**
 * @Author:XieYuanYang
 * @Description:
 * @Date: Created in 16:45 2019/2/18 0018
 */

@Data
@XStreamAlias("xml")
public class BaseMessage {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private String createTime;
    @XStreamAlias("MsgType")
    private String msgType;

    public  BaseMessage(Map<String , String > requestMap){
        this.toUserName = requestMap.get("FromUserName");
        this.fromUserName = requestMap.get("ToUserName");
        this.createTime = System.currentTimeMillis()/1000 + "";
    }
}
