package com.wxdevelop.wxdevelop;

import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.wxdevelop.wxdevelop.pojo.WechatMenu.*;
import com.wxdevelop.wxdevelop.pojo.message.BaseMessage;
import com.wxdevelop.wxdevelop.pojo.message.TextMessage;
import com.wxdevelop.wxdevelop.pojo.templace.*;
import com.wxdevelop.wxdevelop.service.MaterialService;
import com.wxdevelop.wxdevelop.service.QRCodeService;
import com.wxdevelop.wxdevelop.service.TemplateMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Test
    public void test2(){
        First first = new First("您好!您投递的简历有新的反馈","#173177");
        Company company = new Company("北京58同城信息技术有限公司","#173177");
        Time time = new Time("2014-06-24","#173177");
        Remark remark = new Remark("产品经理","#173177");
        Result  result = new Result("已查看","#173177");

        TemData data = new TemData(first,company,time,remark,result);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.toJavaObject(TemCreate.class);
        TemCreate temCreate = new TemCreate(data);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(temCreate);
        System.out.println(jsonObject.toString());

    }

    @Test
    public void Test3(){
        String path = "D:\\tupian\\1.PNG";
        String upload = MaterialService.upload(path,"image");
        System.out.println(upload);
    }

    @Test
    public void Test4(){
        QRCodeService.setQRCode();
    }

}
