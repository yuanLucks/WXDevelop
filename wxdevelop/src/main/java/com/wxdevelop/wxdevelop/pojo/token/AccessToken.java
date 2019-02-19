package com.wxdevelop.wxdevelop.pojo.token;

import lombok.Data;

/**
 * @Author:XieYuanYang
 * @Description:
 * @Date: Created in 12:56 2019/2/19 0019
 */
@Data
public class AccessToken {

    private String accessToken;
    private long expireTime;

    public AccessToken(String accessToken,String expireTime){
        super();
        this.accessToken = accessToken;
        this.expireTime = System.currentTimeMillis() + Integer.parseInt(expireTime) * 1000;
    }

    //判断token是否过期
    public boolean isExpired(){
        return  System.currentTimeMillis() > expireTime;
    }
}
