package com.wxdevelop.wxdevelop.pojo.WechatMenu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:XieYuanYang
 * @Description:  跳转URL用户
 * @Date: Created in 19:55 2019/2/19 0019
 */
@Data
@NoArgsConstructor
public class ViewButton extends AbstractButton {

    private String type = "view";
    private String url;

    public ViewButton(String name,String url){
        super(name);
        this.url = url;
    }

}
