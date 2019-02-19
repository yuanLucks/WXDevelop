package com.wxdevelop.wxdevelop.pojo.token;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author:XieYuanYang
 * @Description: 微信账号密码
 * @Date: Created in 11:56 2019/2/19 0019
 */
@Component
@ConfigurationProperties(prefix = "wechat")
@Data
public class ChatAccount {

    private String mpAppId;
    private String mpAppSecret;
}
