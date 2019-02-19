package com.wxdevelop.wxdevelop.utli;

import jdk.internal.util.xml.impl.Input;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.transform.sax.SAXResult;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 微信工具类
 */
public class EncryptUtli {

    /**
     * 向指定的地址发送一个post请求，带着data数据
     * @param url
     * @param data
     * @return
     */
    public static String post(String url , String data){
        try {
            URL urlObj = new URL(url);
            URLConnection connection = urlObj.openConnection();
            //要发送数据出去，必须要设置为可发送数据状态
            connection.setDoOutput(true);
            OutputStream out = connection.getOutputStream();
            out.write(data.getBytes());
            out.close();

            InputStream in = connection.getInputStream();
            int len;
            byte[] bytes = new byte[1024];
            StringBuffer sb = new StringBuffer();
            while ((len = in.read(bytes)) != -1){
                sb.append(new String(bytes,0,len));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 向指定的地址发送get请求
     * @return
     */
    public static String get(String url){
        try {
            //获取连接对象
            URL urlObject = new URL(url);
            //开连接
            URLConnection connection = urlObject.openConnection();

            InputStream is = connection.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();

            while((len=is.read(bytes))!= -1){
                sb.append(new String(bytes,0,len));
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * sha1加密
     * @param str
     * @return
     */
    public static String sha1(String str){
        try {
            //获取加密对象
            MessageDigest md = MessageDigest.getInstance("sha1");
            //加密
            byte[] digest = md.digest(str.getBytes());
            char[] chars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb = new StringBuilder();
            //处理加密结果
            for (byte b:digest){
                sb.append(chars[(b>>4)&15]);
                sb.append(chars[b&15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析xml格式文件  保存到map中
     * @param is   xml格式包
     * @return  map
     */
    public static Map<String,String> parseRequest(InputStream is){
        //用于解析xml格式
        SAXReader reader = new SAXReader();
        try {
            Map<String,String> mapStr = new HashMap<String,String>();
            //获取文档对象
            Document document = reader.read(is);
            //获取文档根节点
            Element element = document.getRootElement();
            //获取文档子节点
            List<Element> listElement = element.elements();
            //便利所有子节点  也可以一个个获取但不太现实
            for (Element l:listElement) {
                //将便利的子节点保存到map中
                mapStr.put(l.getName(),l.getStringValue());
            }
            return mapStr;
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 匹配 姓名是否存在
     * @param checkName
     * @return
     */
    public static String queryName(String checkName){
        String[] strings = {"李小雷","何佳桂","林智茂","梁光华","许智涛","董才华","曹雄君"};
        for (String s: strings) {
            if (checkName.equals(s)){
               return s;
            }
        }
        return null;
    }

    /**
     * 随机抽取
     * @return
     */
    public static String context(){
        String str1 = "失恋的时候，许多年轻人以为整个世界都抛弃了自己，别傻了，世界根本就没需要过你。";
        String str2 = "许多事不要害怕做错，即使错了，也不必懊恼，人生就是对对错错，回头看来，对错已经无所谓了。";
        String str3 = "回首往事，我发现自己失去了很多宝贵的东西。但我并不难过，因为我知道，以后会失去的更多。";
        String str4 = "在逝去的青春里，很多宝贵的东西从我身边溜走。但我知道，以后还会失去更多，所以我并不难过。";
        String str5 = " 很羡慕你们能和你们喜欢的人在一起，不像我，周围都是喜欢我的人。";

        Random random = new Random();
        String temp = null;
        int i = random.nextInt(5) + 1;
        switch (i){
            case 1:
               temp = str1;
               break;
            case 2:
                temp = str2;
                break;
            case 3:
                temp = str3;
                break;
            case 4:
                temp = str4;
                break;
            case 5:
                temp = str5;
                break;
        }
        return temp;
    }
}
