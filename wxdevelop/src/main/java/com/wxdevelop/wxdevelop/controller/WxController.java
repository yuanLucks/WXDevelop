package com.wxdevelop.wxdevelop.controller;

import com.wxdevelop.wxdevelop.service.WxService;
import com.wxdevelop.wxdevelop.utli.EncryptUtli;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class WxController {


    /**
     * 微信接口配置 认证
     * @param request
     * @return
     */
    @GetMapping("/user")
    public String getUser(HttpServletRequest request){
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println("加密前："+signature);
        if(WxService.check(timestamp,nonce,signature)){
            System.out.println("接入成功！");
            return echostr;
        }else {
            System.out.println("接入失败！");
            return null;
        }
    }

    /**
     * 微信接受消息和事件推送
     * @param requert
     * @return
     */
    @PostMapping("/user")
    public String postUser(HttpServletRequest requert) throws IOException {
        //将文件传的xml格式包    解析到map中
        Map<String,String> mapWx = EncryptUtli.parseRequest(requert.getInputStream());
        System.out.println(mapWx.toString());

        String sss = WxService.getResponse(mapWx);
        /*
        //直接用输出流打印请求数据
        try {
            ServletInputStream inputStream = requert.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            if ((len=inputStream.read(bytes))!= -1){
                sb.append(new String(bytes,0,len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        return sss;
    }


}
