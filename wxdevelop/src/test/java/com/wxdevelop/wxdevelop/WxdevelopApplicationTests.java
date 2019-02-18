package com.wxdevelop.wxdevelop;

import com.thoughtworks.xstream.XStream;
import com.wxdevelop.wxdevelop.pojo.BaseMessage;
import com.wxdevelop.wxdevelop.pojo.TextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.invocation.MatcherApplicationStrategy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
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

}
