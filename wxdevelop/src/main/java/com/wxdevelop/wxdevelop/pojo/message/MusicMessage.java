package com.wxdevelop.wxdevelop.pojo.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * @Author:XieYuanYang
 * @Description:
 * @Date: Created in 17:24 2019/2/18 0018
 */
@Data
@XStreamAlias("xml")
public class MusicMessage extends BaseMessage {

    @XStreamAlias("Music")
   private Music music;

   public MusicMessage(Map<String,String> requestMap , Music music){
       super(requestMap);
       this.setMsgType("music");
       this.music = music;
   }
}
