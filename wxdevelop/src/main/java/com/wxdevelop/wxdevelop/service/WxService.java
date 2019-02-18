package com.wxdevelop.wxdevelop.service;

import com.thoughtworks.xstream.XStream;
import com.wxdevelop.wxdevelop.pojo.*;
import com.wxdevelop.wxdevelop.utli.EncryptUtli;

import java.util.Arrays;
import java.util.Map;

public class WxService {

    private static final String TOKEN = "xyy";

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
               // msg = dealImageMessage(mapWx);
                break;
            case "voice":
                //msg = delVoiceMessage(mapWx);
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
        //转换xml格式 并返回
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

    *//**
     * 处理语音消息
     * @param mapWx
     * @return
     *//*
    private static BaseMessage delVoiceMessage(Map<String, String> mapWx) {
    }*/

  /*  *//**
     * 处理图片消息
     * @param mapWx
     * @return
     *//*
    private static BaseMessage dealImageMessage(Map<String, String> mapWx) {
        ImageMessage imageMessage = new ImageMessage(mapWx,"对不起，我还没有图片给您！");
    }
*/
    /**
     * 处理文本消息
     * @param mapWx
     * @return
     */
    private static BaseMessage dealTextMessage(Map<String, String> mapWx) {
        TextMessage tm = null;

        String checkName = EncryptUtli.queryName(mapWx.get("Content"));
        if (checkName!= null){
            tm = new TextMessage(mapWx,checkName+"   :   欢迎来到服务号开发 测试版! 没事扣1,有事扣2！");
            return tm;
        }


        

        return tm;
    }
}
