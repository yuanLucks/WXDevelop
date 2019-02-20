package com.wxdevelop.wxdevelop.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.wxdevelop.wxdevelop.utli.EncryptUtli;

/**
 * @Author:XieYuanYang
 * @Description: 微信二维码
 * @Date: Created in 21:05 2019/2/20 0020
 */
public class QRCodeService {

    private static final String  QR_CODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";

    /**
     * 生成二维码
     */
    public static void setQRCode(){
        String url = QR_CODE_URL.replace("TOKEN",WxService.getAccessToken("wxfcf12446d226e32d","0d59de8f03d7a099f034e8fa3a3bff8e"));
        String data = "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 185}}}\n";
        String jsonData = EncryptUtli.post(url,data);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(jsonData);
        System.out.println(jsonObject.toString());
    }
}
