package com.wxdevelop.wxdevelop.service;

import com.alibaba.fastjson.JSONObject;
import com.wxdevelop.wxdevelop.pojo.WechatMenu.*;
import com.wxdevelop.wxdevelop.utli.EncryptUtli;
import org.springframework.stereotype.Service;


/**
 * @Author:XieYuanYang
 * @Description:  菜单操作
 * @Date: Created in 20:37 2019/2/19 0019
 */
@Service
public class MeumService {

    //设置接口
    private final String URL_MEUM = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN" ;

    /**
     *  将设置的菜单 变为json字符串 放回个微信服务器
     * @param appid
     * @param appsecret
     */
    public void meum(String appid , String appsecret){
        Button button = new Button();
        button.getButton().add(new ClickButton("一级菜单","1"));
        button.getButton().add(new ViewButton("一级跳转","http://www.baidu.com"));

        SubButton sb = new SubButton("有子菜单");
        sb.getSub_button().add(new PhotoOrAlbumButton("传图","32"));
        sb.getSub_button().add(new Photograph("拍照发图","33"));
        sb.getSub_button().add(new ViewButton("网易新闻","http://news.163.com"));
        button.getButton().add(sb);

        JSONObject jsonObject =(JSONObject) JSONObject.toJSON(button);
        System.out.println(jsonObject.toString());

        String url = URL_MEUM.replace("ACCESS_TOKEN",WxService.getAccessToken(appid,appsecret));
        String resp = EncryptUtli.post(url,jsonObject.toJSONString());
        System.out.println(resp);
    }
}
