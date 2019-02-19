package com.wxdevelop.wxdevelop.pojo.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wxdevelop.wxdevelop.pojo.message.Article;
import com.wxdevelop.wxdevelop.pojo.message.BaseMessage;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:XieYuanYang
 * @Description: 图文消息
 * @Date: Created in 17:34 2019/2/18 0018
 */
@Data
@XStreamAlias("xml")
public class NewsMessage extends BaseMessage {

    @XStreamAlias("ArticleCount")
    private int articleCount;
    @XStreamAlias("Articles")
    private List<Article> articles = new ArrayList<Article>();

    public NewsMessage(Map<String,String> requestMap,List<Article> articles){
        super(requestMap);
        this.setMsgType("news");
        this.articleCount = articles.size();
        this.articles = articles;
    }
}
