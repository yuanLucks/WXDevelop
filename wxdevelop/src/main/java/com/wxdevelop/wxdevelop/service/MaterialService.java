package com.wxdevelop.wxdevelop.service;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

/**
 * @Author:XieYuanYang
 * @Description: 微信素材操作
 * @Date: Created in 16:35 2019/2/20 0020
 */
public class MaterialService {

    private static final String MADIA_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

    /**
     * 传临时素材
     * @param path 素材路径
     * @param type 素材类型
     * @return
     */
    public static String upload(String path , String type){
        File file = new File(path);

        String url = MADIA_URL.replace("ACCESS_TOKEN",WxService.getAccessToken("wxfcf12446d226e32d","0d59de8f03d7a099f034e8fa3a3bff8e")).replace("TYPE",type);
        try {
            URL urlObj = new URL(url);
            //强转为案例连接
            HttpsURLConnection conn = (HttpsURLConnection) urlObj.openConnection();
            //设置连接信息
            conn.setDoInput(true);
            conn.setDoOutput(true);

            // 使用post提交需要设置忽略缓存
            conn.setUseCaches(false);

            //消息请求头信息
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");

            //数据边界
            String boundary = "-----" + System.currentTimeMillis();
            conn.setRequestProperty("Content-Type","multipart/form-data;boundary=" + boundary);

            //获取输出流
            OutputStream out = conn.getOutputStream();
            //创建文件出入流
            InputStream is = new FileInputStream(file);

            //第一部分
            //准备头部信息(拼接)
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            sb.append(boundary);
            sb.append("\r\n");
            sb.append("Content-Disposition:form-data;name=\"media\";filename=\"" + file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");

            out.write(sb.toString().getBytes());


            //准备文件内容
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                out.write(bytes,0,len);
            }

            //尾部信息
            //结尾
            String foot = ("\r\n--" + boundary + "--\r\n");
            out.write(foot.getBytes());
            out.flush();
            out.close();

            //读取服务端返回的数据
            InputStream is2 = conn.getInputStream();
            StringBuilder sb2 = new StringBuilder();
            while ((len = is2.read(bytes)) != -1){
                sb2.append(new String(bytes,0,len));
            }
            System.out.println(sb2.toString());
             return  sb2.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
