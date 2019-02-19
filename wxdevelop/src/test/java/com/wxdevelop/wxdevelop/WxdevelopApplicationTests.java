package com.wxdevelop.wxdevelop;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.wxdevelop.wxdevelop.pojo.WechatMenu.*;
import com.wxdevelop.wxdevelop.pojo.message.BaseMessage;
import com.wxdevelop.wxdevelop.pojo.message.TextMessage;
import com.wxdevelop.wxdevelop.utli.EncryptUtli;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxdevelopApplicationTests {

    @Test
    public void contextLoads() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("ToUserName","to");
        map.put("FromUserName","from");
        map.put("MsgType","type");

        TextMessage textMessage = new TextMessage(map,"hhh");

        //将Object类型数据转成 xml格式的类
        XStream stream = new XStream();
        //启动类上的注解
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(BaseMessage.class);
        //转换xml格式
        String xml = stream.toXML(textMessage);
        System.out.println(xml);
    }

    @Test
    public void test1(){
        Button button = new Button();
        button.getButton().add(new ClickButton("一级菜单","1"));
        button.getButton().add(new ViewButton("一级跳转","http://www.baidu.com"));

        SubButton sb = new SubButton("有子菜单");
        sb.getSub_button().add(new PhotoOrAlbumButton("传图","31"));
        sb.getSub_button().add(new ClickButton("点击","32"));
        sb.getSub_button().add(new ViewButton("网易新闻","http://news.163.com"));
        button.getButton().add(sb);

        JSONObject jsonObject =(JSONObject) JSONObject.toJSON(button);
        System.out.println(jsonObject.toJSONString());

    }

}
