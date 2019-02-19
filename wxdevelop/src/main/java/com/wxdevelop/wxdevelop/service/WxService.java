package com.wxdevelop.wxdevelop.service;


import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.wxdevelop.wxdevelop.pojo.message.*;
import com.wxdevelop.wxdevelop.pojo.token.AccessToken;
import com.wxdevelop.wxdevelop.utli.EncryptUtli;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 业务逻辑层
 */
@Service
public class WxService {

    private static final String TOKEN = "xyy";
    private static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static AccessToken at;

    /**
     * 获取token
     */
    private static void getToken(String appid , String appsecret){
            //替换appid  和 secret
            String url = GET_TOKEN_URL.replace("APPID",appid).replace("APPSECRET",appsecret);

            //执行get请求  获取返回数据
            String tokenStr = EncryptUtli.get(url);
            //将返回的数据转成json格式
            JSONObject jsonObject = JSONObject.parseObject(tokenStr);
            //获取token值
            String token = jsonObject.getString("access_token");
            //获取过期时间
            String  timeIn = jsonObject.getString("expires_in");

            //将tokem值存起来
            at = new AccessToken(token,timeIn);
    }

    /**
     * 向外暴露获取token的方法
     * @return
     */
    public static String getAccessToken(String appid , String appsecret){
        //当token为null  或  token过期  就重新创建token
        if (at==null || at.isExpired()){
            getToken(appid , appsecret);
        }
        return at.getAccessToken();
    }

    /**
     * 签名验证
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    public static boolean check(String timestamp,String nonce,String signature){
        //1:将token，timestamp，noce三个参数进行字典排序
        String[] strs = new String[]{TOKEN,timestamp,nonce};
        //将字符串进行字典排序
        Arrays.sort(strs);

        //2：将三个参数字符串拼接进行sha1加密
        String str = strs[0] + strs[1] +strs[2];  //排序后的结果
        String mysig = EncryptUtli.sha1(str);
        System.out.println("加密后："+mysig);

        //3：开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return mysig.equalsIgnoreCase(signature);
    }

    public static void main(String[] args) {
        check("asd","zsd","asd");
    }

    /**
     * 判断消息类型
     * @param mapWx
     * @return
     */
    public static String getResponse(Map<String, String> mapWx) {
        BaseMessage msg = null;
        String msgType = mapWx.get("MsgType");
        switch (msgType){
            case "text":
                msg = dealTextMessage(mapWx);
                 break;
            case "image":
                msg = dealImageMessage(mapWx);
                break;
            case "voice":
                msg = delVoiceMessage(mapWx);
                break;
            case "video":
               // msg = delVideoMessage(mapWx);
                break;
            case "music":
                //msg = delMusicMessage(mapWx);
                break;
            case "news":
                //msg = dealNewsMessage(mapWx);
                break;
             default:
                 break;
        }
        //把消息对象处理为xml数据包
        return beanToXml(msg);
    }


    /**
     * 将数据装换成 xml 包
     * @param msg
     * @return
     */
    private static String beanToXml(BaseMessage msg) {
        //将Object类型数据转成 xml格式的类
        XStream stream = new XStream();
        //启动XStream注解
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(BaseMessage.class);
        stream.processAnnotations(Article.class);
        stream.processAnnotations(Music.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        stream.processAnnotations(ImageMessage.class);
        //转换xml格式 并返回
        System.out.println(stream.toXML(msg));
        return  stream.toXML(msg);

    }




    /*  *//**
     * 处理图形文本消息
     * @param mapWx
     * @return
     *//*
    private static BaseMessage dealNewsMessage(Map<String, String> mapWx) {

    }

    *//**
     * 处理音乐消息
     * @param mapWx
     * @return
     *//*
    private static BaseMessage delMusicMessage(Map<String, String> mapWx) {
    }

    *//**
     * 处理是视屏消息
     * @param mapWx
     * @return
     *//*
    private static BaseMessage delVideoMessage(Map<String, String> mapWx) {
    }
    */

    /**
     * 处理语音消息
     * @param mapWx
     * @return
     */
    private static BaseMessage delVoiceMessage(Map<String, String> mapWx) {
        List<Article> article =new ArrayList<Article>();
        article.add(new Article("这是图文消息标题！","这是图文消息详细内容","http://mmbiz.qpic.cn/mmbiz_jpg/xHIvLXBicpeEERYH9t7ibea0icEpibMOIHNje73cf6PgLMxxt2h4qwlqeibbxD2bmVIQmBhEDicQKEFQySM4j5pkUOoQ/0","www.baidu.com"));
        NewsMessage videoMessage = new NewsMessage(mapWx,article);
        return videoMessage;
    }

    /*
     * 处理图片消息
     * @param mapWx
     * @return
     */
    private static BaseMessage dealImageMessage(Map<String, String> mapWx) {
        ImageMessage imageMessage = new ImageMessage(mapWx,"asdasdasdasd");
        return imageMessage;
    }
    /**
     * 处理文本消息
     * @param mapWx
     * @return
     */
    private static BaseMessage dealTextMessage(Map<String, String> mapWx) {
        TextMessage tm = null;

        String checkName = EncryptUtli.queryName(mapWx.get("Content"));
        if (checkName!= null){
            tm = new TextMessage(mapWx,"帅比"+ checkName+"   同学  欢迎来到大帅比远开发的服务号 测试版! 没事扣1,有事扣2,分享扣3,查看开发源码扣4！");
            return tm;
        }

        if (mapWx.get("Content").equals("谢远阳")){
            tm = new TextMessage(mapWx,"大帅比远 :    嘛呢？？？   叫我干嘛！没事别叫我！没事扣1，有事扣2，分享扣3,查看开发源码扣4！ 有惊喜哦！ 顺便送你一朵花花/:rose/:rose/:rose！");
        }else if(mapWx.get("Content").equals("2")){
            tm = new TextMessage(mapWx,"大帅比远 :   有事加我微信号: xyy20170707");
        }else if (mapWx.get("Content").equals("3")){
            tm = new TextMessage(mapWx,EncryptUtli.context());
        }else if (mapWx.get("Content").equals("4")){
            tm = new TextMessage(mapWx,"大帅比远 :   源码在Github   地址:https://github.com/yuanLucks?tab=repositories");
        }else {
            tm = new TextMessage(mapWx,"您好  没事扣1,有事扣2,分享扣3,查看开发源码扣4！。 你们发的内容我都看的到的哦！");
        }

        return tm;
    }
}
