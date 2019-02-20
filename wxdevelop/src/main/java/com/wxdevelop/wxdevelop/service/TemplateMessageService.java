package com.wxdevelop.wxdevelop.service;

import com.alibaba.fastjson.JSONObject;
import com.wxdevelop.wxdevelop.pojo.templace.*;
import com.wxdevelop.wxdevelop.utli.EncryptUtli;
import org.springframework.stereotype.Service;

/**
 * @Author:XieYuanYang
 * @Description: 模板操作
 * @Date: Created in 12:41 2019/2/20 0020
 */
@Service
public class TemplateMessageService {

    //设置模板行业 url
    private final String SET_TEMPLATE_TRADE_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
    //获取模板行业 url
    private final String GET_TEMPLATE_TRADE_URL = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
   //发送模板行业  url
    private final String SEND_TEMPLATE_TRADE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";


    /**
     * 设置所属行业
     */
    public void setTemplateTrade(){
        String url = SET_TEMPLATE_TRADE_URL.replace("ACCESS_TOKEN",WxService.getAccessToken("wxfcf12446d226e32d","0d59de8f03d7a099f034e8fa3a3bff8e"));
        TemTrade temTrade = new TemTrade("1","2");
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(temTrade);
        String result = EncryptUtli.post(url,jsonObject.toString());
        System.out.println(result);
    }

    /**
     * 获取设置所属行业
     */
    public void getTemplateTrade(){
        String url = GET_TEMPLATE_TRADE_URL.replace("ACCESS_TOKEN",WxService.getAccessToken("wxfcf12446d226e32d","0d59de8f03d7a099f034e8fa3a3bff8e"));
        String result = EncryptUtli.get(url);
        System.out.println(result);
    }

    /**
     * 发送模板
     */
    public void sendTemplateTrade(){
        String url = SEND_TEMPLATE_TRADE_URL.replace("ACCESS_TOKEN",WxService.getAccessToken("wxfcf12446d226e32d","0d59de8f03d7a099f034e8fa3a3bff8e"));

        String result = EncryptUtli.post(url,setData());
        System.out.println(result);
    }

    /**
     * 设置模板数据
     * @return
     */
    private String setData(){
        First first = new First("您好!您投递的简历有新的反馈","#173177");
        Company company = new Company("北京58同城信息技术有限公司","#173177");
        Time time = new Time("2014-06-24","#173177");
        Remark remark = new Remark("产品经理","#173177");
        Result  result = new Result("已查看","#173177");

        TemData data = new TemData(first,company,time,remark,result);

        TemCreate temCreate = new TemCreate(data);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(temCreate);
        return jsonObject.toString();
    }


}
