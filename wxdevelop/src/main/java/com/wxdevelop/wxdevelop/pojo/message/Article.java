package com.wxdevelop.wxdevelop.pojo.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:XieYuanYang
 * @Description:
 * @Date: Created in 17:35 2019/2/18 0018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("item")
public class Article {
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("PicUrl")
    private String picUrl;
    @XStreamAlias("Url")
    private String url;
}
