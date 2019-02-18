package com.wxdevelop.wxdevelop.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * @Author:XieYuanYang
 * @Description:
 * @Date: Created in 17:29 2019/2/18 0018
 */
@XStreamAlias("xml")
public class Music{
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("MusicURL")
    private String musicURL;
    @XStreamAlias("HQMusicUrl")
    private String hQMusicUrl;
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;

}
